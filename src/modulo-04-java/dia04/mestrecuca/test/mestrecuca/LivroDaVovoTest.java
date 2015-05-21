package mestrecuca;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import mestrecuca.model.Ingrediente;
import mestrecuca.model.Receita;
import mestrecuca.model.UnidadeMedida;

import org.junit.Before;
import org.junit.Test;

public class LivroDaVovoTest {

	private LivroDaVovo livro;
	
	@Before
	public void setUp(){
		livro = new LivroDaVovo();
	}
	
	@Test
	public void quantidadeDeReceitasDeveSerZeroAntesDaInsercao() throws Exception {
		assertEquals(0, livro.getTodasReceitas().size());
	}
	
	@Test
	public void quantidadeDeReceitasDeveAumentarAposInsercao() throws Exception {
		assertEquals(0, livro.getTodasReceitas().size());
		livro.inserir(new Receita("Feijoada"));
		assertEquals(1, livro.getTodasReceitas().size());
	}
	
	@Test
	public void buscaReceitaPeloNomeDeveEncontrarReceita() throws Exception {
		Receita feijoada = new Receita("Feijoada");
		livro.inserir(feijoada);
		assertEquals(feijoada, livro.buscaReceitaPeloNome("Feijoada"));
	}
	
	@Test(expected=ReceitaNaoEncontradaException.class)
	public void buscaReceitaPeloNomeDeveLancarExceptionEmBuscaInvalida() throws Exception {
		livro.buscaReceitaPeloNome("não existe");
	}
	
	@Test
	public void atualizaReceita() throws Exception {
		livro.inserir(new Receita("Feijoada"));
		livro.atualizar("Feijoada", new Receita("Feijoada da Vovó"));
		
		assertEquals(1, livro.getTodasReceitas().size());
		assertTrue(livro.buscaReceitaPeloNome("Feijoada da Vovó") != null);
	}
	
	@Test
	public void valorTotalDasReceitasDeveSerSomaDoValorDasReceitas() throws Exception {
		// Arrange
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA, 1, 10));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.COLHER_SOPA, 1, 5));
		livro.inserir(feijoada);
		
		Receita arroz = new Receita("Arroz com Queijo e Mel");
		arroz.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA, 2, 20));
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.COLHER_SOPA, 2, 10));
		livro.inserir(arroz);
		
		// Act
		double resultado = livro.calcularValorReceitas(feijoada, arroz);
		
		// Assert
		assertEquals(45, resultado, 0.0005);
	}
	
	@Test
	public void buscaReceitasSemIngredientes() throws Exception {
		// Arrange
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA, 1, 10));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.COLHER_SOPA, 1, 5));
		livro.inserir(feijoada);
		
		Receita arroz = new Receita("Arroz com Queijo");
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.COLHER_SOPA, 2, 10));
		livro.inserir(arroz);
		
		// Act
		List<Receita> receitasEncontradas = livro.buscaReceitasSemIngrediente(Arrays.asList("Mel"));
		
		// Assert
		assertEquals(1, receitasEncontradas.size());
		assertEquals(arroz, receitasEncontradas.get(0));	
	}
		
	@Test
	public void excluiReceita() throws Exception {
		// Arrange
		livro.inserir(new Receita("Feijoada"));
		
		// Act
		livro.excluir("Feijoada");
		 
		// Assert 
		assertEquals(0, livro.getTodasReceitas().size());
	}

	@Test(expected=ReceitaNaoEncontradaException.class)
	public void excluiReceitaNaoEncontrada() throws Exception {
		livro.excluir("não existe");
	}
	
	@Test
	public void geraListaDeComprasAgrupandoProdutosComMesmaUnidade() throws Exception {
		// Arrange
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA, 1, 10));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG, 1, 5));
		livro.inserir(feijoada);
		
		Receita arroz = new Receita("Arroz com Queijo");
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG, 2, 10));
		livro.inserir(arroz);
		
		// Act
		Map<Ingrediente, Double> listaDeCompras = livro.geraListaDeCompras(Arrays.asList(feijoada, arroz));
		
		// Assert
		assertEquals(2, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras", listaDeCompras.containsKey(new Ingrediente("Queijo", UnidadeMedida.KG)));
		assertTrue("Deve conter mel na lista de compras", listaDeCompras.containsKey(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA)));
	}
	
	@Test
	public void geraListaDeComprasAgrupandoProdutosComUnidadesDiferentes() throws Exception {
		// Arrange
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA, 1, 10));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG, 1, 5));
		livro.inserir(feijoada);
		
		Receita arroz = new Receita("Arroz com Queijo");
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG, 2, 10));
		arroz.adicionarIngrediente(new Ingrediente("Mel", UnidadeMedida.COLHER_CHA, 1, 10));
		livro.inserir(arroz);
		
		// Act
		Map<Ingrediente, Double> listaDeCompras = livro.geraListaDeCompras(Arrays.asList(feijoada, arroz));
		
		// Assert
		assertEquals(3, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras", listaDeCompras.containsKey(new Ingrediente("Queijo", UnidadeMedida.KG)));
		assertTrue("Deve conter colhe de sopa de mel na lista de compras", listaDeCompras.containsKey(new Ingrediente("Mel", UnidadeMedida.COLHER_SOPA)));
		assertTrue("Deve conter colhe de chá de mel na lista de compras", listaDeCompras.containsKey(new Ingrediente("Mel", UnidadeMedida.COLHER_CHA)));
	}
	


	
}
