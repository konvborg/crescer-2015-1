--1

Select e.NomeEmpregado as NomeEmpregado,
	   d.NomeDepartamento as NomeDepartamento
From Empregado e
	LEFT JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento;

--2
Select a.Nome as NomeAssociado,
	   c.Nome as NomeCidade
from Associado a 
	LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade;

--3
Select c.UF, count(1) as CidadesSemRegistro
From Cidade c
Where NOT EXISTS(Select 1
			 From Associado a
			 Where a.IDCidade = c.IDCidade)
Group by c.UF

--4

Select a.Nome, 
       city.Nome as Cidade_Sul
From Associado a
Left join (Select IDCidade, ('***') as Nome
			From Cidade
			Where UF in ('SC', 'PR', 'RS') )as city
on city.IDCidade = a.IDCidade
