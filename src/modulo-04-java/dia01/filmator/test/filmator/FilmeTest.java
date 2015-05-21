package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilmeTest {

	@Test
	public void toStringDeveRetornarNomeDoFilmeGenero() throws Exception {
		Filme filme = new Filme("O poderoso chefão", Genero.ACAO);
		assertEquals("Nome do filme e gênero devem aparecer em toString", "O poderoso chefão, Ação", filme.toString());
	}
	
	@Test
	public void adicionarAtorDeveAumentarTamanhoDoElenco() throws Exception {
		Filme filme = new Filme("O poderoso chefão", Genero.ACAO);
		Ator ator = new Ator("Marlon Brando");
		filme.adicionarAtor(ator);
		assertEquals("Tamanho do elenco de um novo filme deve ser zero", 1, filme.getElenco().size());
	}
	
	@Test
	public void tamanhoDoElencoDeUmNovoFilmeDeveSerZero() throws Exception {
		Filme filme = new Filme("O poderoso chefão", Genero.ACAO);
		assertEquals("Tamanho do elenco de um novo filme deve ser zero", 0, filme.getElenco().size());
	}
	
	@Test
	public void buscaAtorPeloNome() throws Exception {
		Filme filme = new Filme("O poderoso chefão", Genero.ACAO);
		Ator ator = new Ator("Marlon Brando");
		Ator atriz = new Ator("Marlene Lene");
		Ator coadjuvante = new Ator("Coadjuvante Brando");
		
		filme.adicionarAtor(ator);
		filme.adicionarAtor(atriz);
		filme.adicionarAtor(coadjuvante);
		
		
		List<Ator> esperado = new ArrayList<Ator>();
		esperado.add(ator);
		esperado.add(atriz);
		
		List<Ator> resultado = filme.buscaAtoresPeloNome("Marl");
		assertEquals(2, resultado.size());
		assertEquals(esperado, resultado);
	}
}
