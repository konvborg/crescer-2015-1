--1
Select Substring(nome, 1, Charindex(' ', nome) - 1) As PrimeiroNome From Associado

--2
select nome as Nome,
	   DateDiff(Year, DataNascimento, getdate()) as Idade
from Associado

--3
select NomeEmpregado as Nome,
	   DataAdmissao,
	   DateDiff(MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) as Meses_trabalhados_ate_data
from   Empregado
where DataAdmissao Between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

--4
Select top 1 Cargo
From Empregado
Group By Cargo
Order by count(1) desc;

--5
Select top 1 Nome 
from associado
group by nome
order by len(nome) desc

--6
Select nome,
	   DATEADD(YEAR,50,DataNascimento) as Data_de_50_anos,
	   datename(dw,DATEADD(YEAR,50,DataNascimento)) as Dia_Da_Semana
from associado;

--7
Select UF, 
	   count(1) as NumeroCidades
From Cidade
Group By UF;

--8
Select Nome,
	   UF
From Cidade
Group by Nome, UF
Having count(nome)>1 and count(UF)>1

--9
Select TOP 1 ISNULL(IDAssociado,0) + 1 as proximo_id
From Associado
Order by IDAssociado desc

--10
WITH CTE AS(
   SELECT nome, uf,
       RN = ROW_NUMBER()OVER(PARTITION BY nome, uf ORDER BY nome, uf)
   FROM CidadeAux
)
DELETE FROM CTE WHERE RN > 1	

/*
Delete from CidadeAux;

Select Nome, UF, Count(1) as Total, MIN(IDCidade) Menor_IDCidade	
From Cidade
Group by nome, UF
Having Count(1)>1


*/
--11
begin transaction

Update Cidade 
set Nome = '*' + Nome
Where nome IN(Select nome
			  from cidade
			  group by nome,uf
			  having count(1)>1
			  )

SELECT * FROM CIDADE ORDER BY NOME
COMMIT

--12
Select Nome,
	   case Sexo
			when 'M' then 'Masculino'
			when 'F' then 'Feminino'
			else 'Outro'
			End Genero
From Associado

--13
Select nomeempregado,
	   salario,
	   Case when Salario <= 1164 then 0
			--when Salario > 1164 and salario <= 2326 then (Salario*0.15) 
			when Salario between 1164.01 and 2326 then (Salario*0.15)
			when Salario > 2326 then (Salario*0.275)
			else 0
			End Desconto_IR
From Empregado

--14
Begin Transaction
Delete from cidade
where IDCidade in (Select MAX(IDCidade)
				   from Cidade
				   group by nome, uf
				   having count(1)>1)
Commit


--15

Alter table Cidade add constraint UK_Cidade_Nome_UF unique (Nome, UF);

--16
