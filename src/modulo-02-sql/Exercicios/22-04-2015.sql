--Remover * do inicio dos nomes
Begin Transaction

update Cidade
set Nome = replace (nome, '*', '')
where Nome like '*%'

Commit

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
Select c.UF, count(1) as TotalCidadesSemRegistro
From Cidade c
Where NOT EXISTS(Select 1
				 From Associado a
				 Where a.IDCidade = c.IDCidade)
Group by c.UF

--4
--create view vw_Cidade_Regiao as
Select a.Nome, 
       c.Nome as Cidade_Sul
From Associado a
Left join (Select IDCidade, ('***') as Nome
			From Cidade
			Where UF in ('SC', 'PR', 'RS') )as c
on c.IDCidade = a.IDCidade
--Select * from vw_Cidade_Regiao

--5

Select e.NomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento
	   from Empregado e
		 LEFT JOIN Empregado g
		   ON e.IDGerente = g.IDEmpregado
		 LEFT JOIN Departamento d 
		   ON d.IDDepartamento = e.IDDepartamento

--6
select *
into EmpregadoAux
from Empregado;

begin transaction

Update Empregado 
set Salario = (Salario*1.145)
Where IDDepartamento IN(Select IDDepartamento
						From Departamento
						Where Localizacao = 'SAO PAULO'
						)
commit

--7
Select SUM(ISNULL(e.Salario,0))-SUM(ISNULL(c.Salario,0)) as DiferencaPosAumento
from Empregado e 
	left join EmpregadoAux c on e.IDEmpregado = c.IDEmpregado

--8
Select NomeDepartamento
from Departamento
Where IDDepartamento = (Select TOP 1 d.IDDepartamento
						from Empregado e 
							inner join Departamento d ON d.IDDepartamento = e.IDDepartamento
						order by Salario desc
						)

--9