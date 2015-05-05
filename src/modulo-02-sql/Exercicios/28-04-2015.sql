BEGIN
	DECLARE @nome varchar(30)
	SET @nome = 'CWI Software'
	PRINT @nome
	PRINT getdate()
END

--2
BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward

	FOR Select ci.Nome, ci.Uf
		From Cidade ci
		Where EXISTS (Select 1
					  from Cliente cl 
					  where cl.IDCidade = ci.IDCidade
					 )
		Group by Nome, Uf
		Having COUNT(1) > 1;

	DECLARE	@vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN

			Print @vNome + '/'+@vUF;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

--3

Select top 1 IDMaterial
from ProdutoMaterial
group by IDMaterial
order by count(IDMaterial) desc

BEGIN
	DECLARE ListaPedidos CURSOR
		Local
		Fast_Forward

	FOR Select ci.Nome, ci.Uf
		From Cidade ci
		Where EXISTS (Select 1
					  from Cliente cl 
					  where cl.IDCidade = ci.IDCidade
					 )
		Group by Nome, Uf
		Having COUNT(1) > 1;

	DECLARE	@vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN

			Print @vNome + '/'+@vUF;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END


select * from produto