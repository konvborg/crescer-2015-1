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