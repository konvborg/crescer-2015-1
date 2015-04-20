--1
Select Substring(nome, 1, Charindex(' ', nome) - 1) As PrimeiroNome From Associado

--2
select nome as Nome,
	   DateDiff(Year, DataNascimento, getdate()) as Idade
from Associado

--3
select NomeEmpregado as Nome,
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