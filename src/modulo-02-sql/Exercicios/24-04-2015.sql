--felipe dylon 492


--1
Select DISTINCT situacao
From produto

--2 
Select Nome, RazaoSocial
from Cliente
where nome like '%ltda%' or razaosocial like '%ltda%'

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
select p.Nome
from produto p
where NOT EXISTS( Select 1
				  from PedidoItem ip
				  where ip.IDProduto = p.IDProduto
				  )

--5
Select UF
from Cidade ci left join Cliente cl on ci.IDCidade = cl.IDCidade 
where 

--6

Select distinct ci.nome
from Cidade ci left join Cliente cl on ci.IDCidade=cl.IDCidade
where exists (Select 1
			  from pedido p
			  where p.IDCliente = cl.IDCliente
			  )
