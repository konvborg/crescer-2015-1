--1

Select NomeEmpregado as Nome
From Empregado
Order by DataAdmissao;

--2
Select NomeEmpregado as Nome,
	   (Salario*12) as SalarioAnual
From Empregado
Where Cargo = 'Atendente' or (salario*12)<18.500;

--3
Select IDCidade as ID
From Cidade
Where Nome = 'Uberlândia';

--4
Select IDCidade,
	   Nome
From Cidade
Where UF = 'RS';