use [Crescer15-1]
go


/*
1) Identifique e liste quantos valores diferentes estão definidos para a coluna Situacao da tabela Produto 
(somente os distintos valores).
*/


select count(distinct situacao) as Total_Valores
from   Produto

/*
2) Liste todos os clientes que tenham o LTDA no nome ou na razao social.
*/
Select IDCliente, Nome, RazaoSocial
From   Cliente
Where  upper(Nome)        like '%LTDA%'
   or  upper(RazaoSocial) like '%LTDA%'

/*
3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
*/
Insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
 Values  ('Galocha Maragato', 35.67, 77.95, 'A');

 
SP_HELP 'PRODUTO'

/*
4) Identifique e liste os produtos que não tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, 
pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
Obs.: o produto criado anteriormente deverá ser listado.
*/

-- opcao 1
 Select IDProduto,
        Nome
 From   Produto
 Where  not exists (select 1
                    from   PedidoItem
					where  PedidoItem.IDProduto = Produto.IDProduto);

-- Eliminando o índice
drop index PedidoItem.IX_PedidoItem_Produto;

-- Criando o índice 
create index IX_PedidoItem_Produto on PedidoItem (IDProduto);

 -- opcao 2
 Select pro.IDProduto,
        pro.Nome
 From   Produto pro
   left join PedidoItem item on item.IDProduto = pro.IDProduto
 Where  item.IDProduto is null;

/*
5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes 
(tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.
*/ 

-- criando view para reutilização de código
Create view vwEstados as
	Select cid.UF, Count(1) AS TotalClientes
	From   Cidade cid
	 inner join Cliente cli on cli.IDCidade = cid.IDCidade
	Group by cid.UF

-- utilizando a view para projetar o menor e maior
select * from vwEstados
where TotalClientes = (select min(TotalClientes) from vwEstados)
   or TotalClientes = (select max(TotalClientes) from vwEstados);

/*
6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido.
*/
Select Count(distinct Nome) as TotalCidades
From   Cidade
Where  EXISTS (select 1
               from   Cliente cli
			    inner join Pedido ped on ped.IDCliente = cli.IDCliente
			   where cli.IDCidade = Cidade.IDCidade);

-- 4287 IDCidades distintas / nomes distintos: 2891

Select count(distinct cid.Nome) as TotalCidades
From   Cidade cid
  inner join Cliente cli on cli.IDCidade  = cid.IDCidade
  inner join Pedido  ped on ped.IDCliente = cli.IDCliente;

/*
7) Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial). 
Identifique se existe algum produto sem material relacionado.
Obs.: o produto criado anteriormente deverá ser listado.
*/

Select pro.IDProduto, pro.Nome
From   Produto pro
Where  NOT EXISTS (Select 1
                   From   ProdutoMaterial pm
			       where  pm.IDProduto = pro.IDProduto );

/*
8) Liste os produtos, com seu preço de custo, e relacione com seus os materiais (ProdutoMaterial), 
e liste também o somatório do PrecoCusto de todos seus materiais. 
Veja um exemplo abaixo: IDProduto Produto Preco Custo R$ Preco Custo Materiais R$
*/
   select pro.IDProduto,
          pro.Nome,
	      pro.PrecoCusto,
          SUM (ma.PrecoCusto * ISNULL(pm.Quantidade, 1) ) as Preco_Custo_Material
	from Produto pro
	 inner join produtoMaterial pm  on pm.idproduto = pro.idproduto
	 inner join Material ma         on ma.IDMaterial = pm.IDMaterial
   group by pro.IDProduto,
            pro.Nome,
	        pro.PrecoCusto
	

-- criação de uma função (precisa ser criado índices)
create function busca_precoCusto_Material (@IDProduto int)
  returns decimal(9,2) as
begin
	declare @preco_custo decimal(9,2)

	select @preco_custo = SUM (ma.PrecoCusto * ISNULL(pm.Quantidade, 1) ) 
	from produtoMaterial pm 
	 inner join Material ma on ma.IDMaterial = pm.IDMaterial
	where pm.idproduto = @IDProduto

	return @preco_custo

end;  
go

-- criação de índice necessário
create index IX_ProdutoMaterial_MatProd on produtoMaterial (IDProduto, IDMaterial);

select idproduto,
       nome,
	   precocusto,
	   dbo.busca_precoCusto_Material(idproduto) as valor_de_custo
from produto where idproduto = 123;
-----------------------------------------------------------------------------------------------------------------------

/*
9)	Após identificar o preço de custo dos produtos e seus materiais será preciso acertar os produtos que estão com o valor de custo inferior ao custo dos materiais. 
    Pra isso faça uma alteração (update) na tabela de Produtos, definindo o PrecoCusto, para que fique igual ao custo dos seus materiais.
*/

-- CRIANDO UMA VIEW COM TODOS OS PRODUTOS QUE TENHAM O CUSTO DO PRODUTO E O CUSTO DOS SEUS MATERIAIS
-- E UTILIZANDO UMA FUNÇÃO "ROUND" SOBRE A COLUNA QUE EXIBE O TOTAL DE MATERIAIS, COM ISSO TORNAMOS 
-- OS CAMPOS "TotalMateriais" e "PrecoCusto" DO MESMO FORMATO (2 CASAS DECIMAIS)

Create view vwCustoProduto as
 Select pr.IDProduto, 
        pr.Nome, 
        pr.PrecoCusto, 
        ROUND( SUM( ISNULL(pm.Quantidade,1) * ma.PrecoCusto ),2) as TotalMateriais
 From   Produto pr
   inner join ProdutoMaterial pm on pm.IDProduto  = pr.IDProduto
   inner join Material        ma on ma.IDMaterial = pm.IDMaterial
 Group by pr.IDProduto, 
          pr.Nome, 
          pr.PrecoCusto 
go

BEGIN TRANSACTION
GO

 Update Produto
 Set    PrecoCusto = vw.TotalMateriais
 From   vwCustoProduto vw
 Where  vw.IDProduto = Produto.IDProduto
 and    vw.PrecoCusto < vw.TotalMateriais
go

--ou
Update Produto
Set    PrecoCusto = (select TotalMAteriais
                     From   vwCustoProduto vw
                     Where  vw.IDProduto = Produto.IDProduto
                     and    vw.PrecoCusto < vw.TotalMateriais)
Where  IDProduto in (select IDProduto 
                     from 	vwCustoProduto vw
					 where  vw.PrecoCusto < vw.TotalMateriais)
					 
					 
/*
 10)	Liste os clientes que tenham o mesmo nome (Tabela Cliente, registros com o nome (apenas) duplicado).
*/
 
Select Nome, count(1) Contador
From   Cliente        
Group  by Nome
Having count(1) > 1  --Definindo para exibir somente os que tenham mais de 1 registro!
go


/*
 11) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
*/

Select TOP 1
       Substring( Nome, 1, charIndex(' ', Nome)-1) PrimeiroNome, 
       count(1) Total
From   Cliente
Group  by Substring( Nome, 1, charIndex(' ', Nome)-1)  
Order by Total DESC
go


/*
 12) Liste qual o produto é mais vendido (considere a informação da quantidade).
*/
Select top 1 with ties
       item.IDProduto, 
       pro.Nome,
       sum(item.Quantidade) TotalItens
From   PedidoItem item
  inner join Produto pro on item.IDProduto = pro.IDProduto
Group  by item.IDProduto,
          pro.Nome
Order  by TotalItens desc
go

---================= EXTRAS =============================================================================================================
/*
 13) Liste quais os 30 produtos foram mais vendidos nos últimos 60 dias (pra isso deve ser considerado a data do pedido).
*/

-- Consultando qual a ultima data de pedido (apenas para verificar se existirá algum pedido)
Select MAX(DataPedido) From Pedido
go

-- executando a consulta com as opcoes possiveis de exibir o resultado esperado, porem a data do ultimo pedido é de 01/09/2010 ...
Select top 30
       item.IDProduto, 
       pro.Nome,
       sum(item.Quantidade) TotalItens
From   PedidoItem item
  inner join Produto pro on item.IDProduto = pro.IDProduto
  inner join Pedido  ped on item.IDPedido  = ped.IDPedido
--Where  ped.DataPedido >= convert(datetime, '01/07/2010', 103)
Where ped.DataPedido >= convert(datetime, convert(varchar, getdate()-60,103), 103) -- "truncaria" a hora
--Where ped.DataPedido >= getdate()-60                      -- não truncaria a hora
--Where ped.DataPedido >= DateAdd(DAY, -60, GetDate())      -- não truncaria a hora
--Where ped.DataPedido >= DateAdd(MONTH, -2, GetDate())     -- não truncaria a hora
Group  by item.IDProduto,
          pro.Nome
Order  by TotalItens desc

/*
 14) Identifique quais os produtos estão com o preço de venda inferior ao preço de custo.
*/
Select *
From   Produto
Where  PrecoVenda < PrecoCusto


/*
 15) Identifique quais os pedidos (somente o pedido) possuem produtos com esses produtos (de preço de venda inferior ao de custo).
*/
Select IDPedido, DataPedido, ValorPedido
From   Pedido ped
Where  exists (select 1
               from   PedidoItem item
                 inner join Produto pro on item.IDProduto = pro.IDProduto
               Where pro.PrecoVenda < PrecoCusto 
               and   item.IDPedido = ped.IDPedido)


/*
 16) Atualize todos os produtos com preço de venda inferior ao preço de venda em 44% sobre o preço de custo.
*/			   
BEGIN TRANSACTION 

  Update Produto
  Set    PrecoVenda = PrecoCusto*1.44
  Where  PrecoVenda < PrecoCusto

COMMIT TRANSACTION
go

