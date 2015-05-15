package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EmpresaTest {
	@Test
	public void insereUmFilme() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim");
		cwi.inserirFilme(ruim);
		ArrayList<Filme> aux = new ArrayList<>();
		aux.add(ruim);
		assertEquals(aux,cwi.getListaFilmes());
	}
	
	@Test
	public void insereTresFilmes() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim");
		Filme ruim1 = new Filme("Filme Podre");
		Filme ruim2 = new Filme("Filme Terrivel");
		cwi.inserirFilme(ruim);
		cwi.inserirFilme(ruim1);
		cwi.inserirFilme(ruim2);
		ArrayList<Filme> aux = new ArrayList<>();
		aux.add(ruim);
		aux.add(ruim1);
		aux.add(ruim2);
		assertEquals(aux,cwi.getListaFilmes());
	}
	
	@Test
	public void insereDezFilmes() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim");
		Filme ruim1 = new Filme("Filme Podre");
		Filme ruim2 = new Filme("Filme Terrivel");
		Filme ruim3 = new Filme("Filme Horrendo");
		Filme ruim4 = new Filme("Filme Tri Ruim");
		Filme ruim5 = new Filme("Filme Pior que os outros");
		Filme ruim6 = new Filme("Filme Podrão");
		Filme ruim7 = new Filme("Filme Lixo");
		Filme ruim8 = new Filme("Filme Meio Escremento");
		Filme ruim9 = new Filme("Donnie Darko");
		cwi.inserirFilme(ruim);
		cwi.inserirFilme(ruim1);
		cwi.inserirFilme(ruim2);
		cwi.inserirFilme(ruim3);
		cwi.inserirFilme(ruim4);
		cwi.inserirFilme(ruim5);
		cwi.inserirFilme(ruim6);
		cwi.inserirFilme(ruim7);
		cwi.inserirFilme(ruim8);
		cwi.inserirFilme(ruim9);
		ArrayList<Filme> aux = new ArrayList<>();
		aux.add(ruim);
		aux.add(ruim1);
		aux.add(ruim2);
		aux.add(ruim3);
		aux.add(ruim4);
		aux.add(ruim5);
		aux.add(ruim6);
		aux.add(ruim7);
		aux.add(ruim8);
		aux.add(ruim9);
		assertEquals(aux,cwi.getListaFilmes());
	}
	
	@Test
	public void reproduzirFilmeDeUmGeneroPelaPrimeiraVez() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim",Genero.ACAO);
		cwi.inserirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		int resultado = cwi.getVis().get(Genero.ACAO);
		assertEquals(1,resultado);
	}
	
	@Test
	public void reproduzirFilmeDeUmGeneroDezVezes() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim",Genero.ACAO);
		cwi.inserirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim);
		int resultado = cwi.getVis().get(Genero.ACAO);
		assertEquals(10,resultado);
	}
	
	@Test
	public void reproduzirFilmeQueNaoEstaNaLista() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim",Genero.ACAO);
		cwi.reproduzirFilme(ruim);
		int resultado = cwi.getVis().getOrDefault(Genero.ACAO,0);
		assertEquals(0,resultado);
	}
	
	@Test
	public void gerarRelatorioComUmaReprodução() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim",Genero.ACAO);
		Filme ruim1 = new Filme("Filme Ruim 2",Genero.COMEDIA);
		Filme ruim2 = new Filme("Filme Ruim 3",Genero.DRAMA);
		Filme ruim3 = new Filme("Filme Ruim 4",Genero.EPICO);
		cwi.inserirFilme(ruim);
		cwi.inserirFilme(ruim1);
		cwi.inserirFilme(ruim2);
		cwi.inserirFilme(ruim3);
		cwi.reproduzirFilme(ruim);
		cwi.reproduzirFilme(ruim1);
		cwi.reproduzirFilme(ruim2);
		cwi.reproduzirFilme(ruim3);
		StringBuilder esperado = new StringBuilder();
		esperado.append("Relatório CWI :\n");
		esperado.append(Genero.ACAO.desc +"\nExibido 1 vez.\n\n");
		esperado.append(Genero.COMEDIA.desc +"\nExibido 1 vez.\n\n");
		esperado.append(Genero.DRAMA.desc +"\nExibido 1 vez.\n\n");
		esperado.append(Genero.EPICO.desc +"\nExibido 1 vez.");
		String resultado = cwi.gerarRelatorio();
		assertEquals(esperado.toString(),resultado);
	}

	@Test
	public void gerarRelatorioComZeroOuMaisDeUmaReprodução() throws Exception {
		Empresa cwi = new Empresa("CWI");
		Filme ruim = new Filme("Filme Ruim",Genero.ACAO);
		Filme ruim1 = new Filme("Filme Ruim 2",Genero.COMEDIA);
		Filme ruim2 = new Filme("Filme Ruim 3",Genero.DRAMA);
		Filme ruim3 = new Filme("Filme Ruim 4",Genero.EPICO);
		cwi.inserirFilme(ruim);
		cwi.inserirFilme(ruim1);
		cwi.inserirFilme(ruim2);
		cwi.inserirFilme(ruim3);
		cwi.reproduzirFilme(ruim1);
		cwi.reproduzirFilme(ruim1);
		cwi.reproduzirFilme(ruim3);
		cwi.reproduzirFilme(ruim3);
		cwi.reproduzirFilme(ruim3);
		cwi.reproduzirFilme(ruim3);
		StringBuilder esperado = new StringBuilder();
		esperado.append("Relatório CWI :\n");
		esperado.append(Genero.ACAO.desc +"\nExibido 0 vezes.\n\n");
		esperado.append(Genero.COMEDIA.desc +"\nExibido 2 vezes.\n\n");
		esperado.append(Genero.DRAMA.desc +"\nExibido 0 vezes.\n\n");
		esperado.append(Genero.EPICO.desc +"\nExibido 4 vezes.");
		String resultado = cwi.gerarRelatorio();
		assertEquals(esperado.toString(),resultado);
	}
}
