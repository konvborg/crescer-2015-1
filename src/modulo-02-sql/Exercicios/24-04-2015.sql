--1
Select count(DISTINCT situacao) as TotalValores
From produto

--2 
Select IDCliente, Nome, RazaoSocial
from Cliente
where upper(nome) like '%LTDA%' 
   or upper(razaosocial) like '%LTDA%'

--3
begin transaction
INSERT into Produto (nome,
					 PrecoCusto,
					 PrecoVenda,
					 Situacao)
       Values('Galocha Maragato',
			  35.67,
			  77.95,
			  'A');.
commit

--4

create index IX_PedidoItem_Produto on PedidoItem (IDProduto);

select p.Nome
from produto p
where NOT EXISTS( Select 1
				  from PedidoItem ip
				  where ip.IDProduto = p.IDProduto
				  )
 
--5 
/* Correçao
Create view cwEstado as
Select cid.UF, count(1) as TotalClientes
from Cidade cid
	inner join Cliente cle on cli.IDCidade = cid.IDCidade
group by cid.UF

Select * from vwEstados
where TotalClientes = (Select min(TotalClientes) from vwEstados)
   or TotalClientes = (Select max(TotalClientes) from vwEstados


*/
create view vwSelectMaior
AS
Select top 1 UF MaiorEMenor
from cliente cl inner join Cidade ci on cl.idcidade = ci.idcidade
group by uf
order by count(1) desc;

select * from vwSelectMaior
UNION ALL
Select top 1 UF
from cliente cl inner join Cidade ci on cl.idcidade = ci.idcidade
group by uf
order by count(1);

--6
 
 
--7
select p.Nome
from produto p
where NOT EXISTS (Select 1
				  from ProdutoMaterial pm
				  where pm.IDProduto = p.IDProduto
				  )

--8 Liste os produtos, com seu preço de custo, e relacione com seus os materiais (ProdutoMaterial),
-- e liste também o somatório do PrecoCusto de todos seus materiais. Veja um exemplo abaixo
-- Preciso editar para botar a soma no lugar do precocustomateriais


Select  p.idproduto,
		p.nome as nomeproduto,
		p.precocusto,
		(ISNULL(m.precocusto,0)*ISNULL(pm.quantidade,0)) as precocustomaterias
from produto p left join produtomaterial pm on p.IDProduto = pm.IDProduto
						left join material m on m.IDMaterial = pm.IDMaterial

--9


--10
Select nome
from cliente
group by nome
having count(1)>1

--11

--12