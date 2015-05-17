package filmator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetfloxTest {

	
	@Test
	public void reproduzFilmeDeveIncrementerEstatisticas() throws Exception {
		
		// Arrange
		Netflox netflox = new Netflox();
		assistirDoisFilmesDeAcaoUmDeDrama(netflox);
		
		// Assert
		assertTrue("Deve ter coletado estatísticas de drama", netflox.getEstatisticasPorGenero().containsKey(Genero.DRAMA));
		assertTrue("Deve ter coletado estatísticas de ação", netflox.getEstatisticasPorGenero().containsKey(Genero.ACAO));
		
		assertEquals("Deve ter coletado estatísticas de ação", netflox.getEstatisticasPorGenero().get(Genero.ACAO), new Integer(2));
		assertEquals("Deve ter coletado estatísticas de drama", netflox.getEstatisticasPorGenero().get(Genero.DRAMA), new Integer(1));	
	}
	
	@Test
	public void geraRelatorio() throws Exception {
		Netflox netflox = new Netflox();
		assistirDoisFilmesDeAcaoUmDeDrama(netflox);
		
		// Assert
		assertTrue("Deve ter gerado relatório de ação", netflox.geraRelatorio().contains("Ação: 2"));
		assertTrue("Deve ter gerado relatório de drama", netflox.geraRelatorio().contains("Drama: 1"));
	}
	

	private Netflox assistirDoisFilmesDeAcaoUmDeDrama(Netflox netflox) {
		Filme acao = new Filme("O poderoso chefão", Genero.ACAO);
		Filme drama = new Filme("Titanic", Genero.DRAMA);
		
		// Act
		netflox.reproduzirFilme(acao);
		netflox.reproduzirFilme(acao);
		netflox.reproduzirFilme(drama);
		return netflox;
	}
}
