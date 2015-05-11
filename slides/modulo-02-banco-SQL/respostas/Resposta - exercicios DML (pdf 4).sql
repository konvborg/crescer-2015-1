/*************************************
 * Exercícios de SQL (SQL Server)
 **************************************/
-- 1) 
select substring(nome, 0, CHARINDEX(' ', nome)) as primeiro_nome, 
       CHARINDEX(' ', nome) primeiro_espaco,
       nome 
from associado

-- 2) 
Select idassociado, 
       nome, 
	   DataNascimento, 
	   DATEDIFF(Year, DataNascimento, getdate()) Idade -- arredondamento 
from   Associado

-- 3
Select IDEmpregado, 
       NomeEmpregado, 
	   DataAdmissao,
	   DATEDIFF(Month, DataAdmissao, CONVERT(DateTime, '31/12/2000', 103) ) as Meses_Trabalho
From   Empregado
Where  DataAdmissao between CONVERT(DateTime, '01/05/1980', 103)
                        and CONVERT(DateTime, '20/01/1982', 103);

-- 4 
Select top 1 WITH TIES 
       Cargo, 
       COUNT(1) as Total_Empregados
from   Empregado
group  by Cargo
order  by Total_Empregados desc;

select idempregado, cargo from empregado
------------------------------------------------------------
-- apoio para testar critério de empate com TOP (with ties)
begin transaction
go

update empregado 
set    cargo = 'Vendedor'
where  idempregado = 7566
go

rollback
---------------------------------------------------------------

-- 5
Select top 1
       LEN(Nome) as numero_caracteres, 
       nome
from   Associado
Order by numero_caracteres desc
------------------------------------------------------------
-- alternativa utilizando do MAX()
Select nome
from   Associado
where  LEN(Nome) = (select max(len(nome)) from associado);

--------
-- 6)
SET LANGUAGE Portuguese;

Select IDAssociado,
       Nome,
	   DataNascimento,
	   DATEADD(Year, 50, DataNascimento ) Cinquenta_Anos,
	   DATENAME(weekday, DATEADD(Year, 50, DataNascimento )) Dia_Semana
From   Associado;

-- 7)
Select UF,
       COUNT(1) as Total_Cidades
From   Cidade
Group  by UF
Order  by UF;

-- 8) Cidades duplicadas
Select Nome, UF , COUNT(1) as Total
From   Cidade
Group by Nome, UF
Having COUNT(1) > 1;

-- 9)
begin transaction
go

delete from associado;

Select ISNULL(MAX(IDAssociado),0) + 1 Proximo_ID
From   Associado;

ROLLBACK

-- 10) inserir somente as cidades duplicadas de menor ID
Delete from CidadeAux;

Insert into CidadeAux 
  (IDCidade, Nome, UF)
Select MIN(IDCidade) Menor_IDCidade, 
       Nome, 
	   UF
From   Cidade
Group by Nome, UF;

select * from cidadeAux;

-- verificar a estrutura de uma tabela
sp_help 'CidadeAux'


use CursoSQL
go
-------------------------------------------------------------------------
-- 11) alterar cidade
begin transaction
go


-- OPÇÃO COM A SUBQUERY, ONDE O RESULTADO DA SUBQUERY SERÃO OS VALORES OS QUAIS ESTAREI COMPARANDO/FILTRANDO
Update Cidade
set    Nome = '*' + Nome
where  Nome in (select nome
                from   cidade
                group by nome, uf
                having count(1) > 1
				);

-- OPÇÃO COM VALORES FIXOS
Update Cidade
set    Nome = '*' + Nome
where  nome IN ('*Brasilia', '*Belo Horizonte', '*Uberlândia', '*Rio de Janeiro', '*Guarulhos', '*São Paulo')

COMMIT;

-- conversão para concatenar
select '123'+ CAST(23 as varchar(10))

SELECT * FROM CIDADE ORDER BY NOME
-------------------------------------------------------------------------
-- 12)
Select Nome,
       Case Sexo
	     when 'M' then 'Masculino'
		 when 'F' then 'Feminino'
		 else 'Outro'
	   End Genero
From   Associado;
-------------------------------------------------------------------------
-- 13)
/*
Até R$ 1.164,00 = 0% 
De R$ 1.164,00 a R$ 2.326,00 = 15%
Acima de R$ 2.326,00 = 27,5%.
*/
Select NomeEmpregado,
       Salario,
	   Case when Salario > 1164 and Salario <= 2326 then (Salario*0.15)
			when Salario > 2326 then (Salario*0.275)
			else 0
	   End Desconto_IR
From   Empregado

-------------------------------------------------------------------------
-- 14) 
Begin transaction
go

Delete From Cidade
Where  IDCidade in  (Select MAX(IDCidade)
                     From   Cidade
					 Group  by Nome, UF
					 Having count(1) > 1)

Select MAX(IDCidade) Maior_IDCidade_Duplicada
From   Cidade
Group  by Nome, UF
Having count(1) > 1

Select nome, uf
From   Cidade
Group  by nome, uf
having count(1) > 1      

commit

-------------------------------------------------------------------------
-- 15)

Alter table Cidade 
   add constraint UK_Cidade_NomeUF 
   unique (Nome, UF);

-- Tentativa de incluir registro com NOME e UF duplicados
insert into Cidade (IDCidade, Nome, UF) values (1000, 'Bage', 'RS');


