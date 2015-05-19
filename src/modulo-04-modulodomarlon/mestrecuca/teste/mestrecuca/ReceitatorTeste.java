package mestrecuca;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReceitatorTeste {
	@Test
	public void inserirUmaReceita() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente passaroraro = new Ingrediente("Papanus Roxo",1,UnidadeMedida.UNIDADE);
		Instrucao assar = new Instrucao("Asse o pássaro.");
		Receita receita = new Receita("Papanus Assado");
		receita.adicionarIngrediente(passaroraro);
		receita.adicionarInstrucao(assar);
		receitator.inserir(receita);
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		assertEquals(esperado,receitator.getTodasReceitas());
	}
	
	@Test
	public void inserirTresReceitas() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente passaroraro = new Ingrediente("Papanus Roxo",1,UnidadeMedida.UNIDADE);
		Instrucao assar = new Instrucao("Asse o pássaro.");
		Receita receita = new Receita("Papanus Assado");
		receita.adicionarIngrediente(passaroraro);
		receita.adicionarInstrucao(assar);
		Ingrediente passaroraro1 = new Ingrediente("Papanus Roxo",1,UnidadeMedida.UNIDADE);
		Instrucao assar1 = new Instrucao("Asse o pássaro.");
		Receita receita1 = new Receita("Papanus Assado");
		receita1.adicionarIngrediente(passaroraro1);
		receita1.adicionarInstrucao(assar1);
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada.");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita);
		receitator.inserir(receita1);
		receitator.inserir(receita2);
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita1);
		esperado.add(receita2);
		assertEquals(esperado,receitator.getTodasReceitas());
	}
	
	@Test(expected=NomeOuReceitaNuloException.class)
	public void inserirUmaReceitaNula() throws Exception {
		Receitator receitator = new Receitator();
		Receita receita = new Receita("Papanus Assado");
		receitator.inserir(receita);
	}
	
	@Test
	public void atualizarReceita() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente passaroraro = new Ingrediente("Papanus Roxo",1,UnidadeMedida.UNIDADE);
		Instrucao assar = new Instrucao("Asse o pássaro.");
		Receita receita = new Receita("Papanus Assado");
		receita.adicionarIngrediente(passaroraro);
		receita.adicionarInstrucao(assar);
		Ingrediente passaroraro1 = new Ingrediente("Papanus Roxo",1,UnidadeMedida.UNIDADE);
		Instrucao assar1 = new Instrucao("Asse o pássaro.");
		Receita receita1 = new Receita("Papanus Assado");
		receita1.adicionarIngrediente(passaroraro1);
		receita1.adicionarInstrucao(assar1);
		receitator.inserir(receita);
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita1);
		receitator.atualizar("Papanus Assado", receita1);
		assertEquals(esperado,receitator.getTodasReceitas());
	}
	
	@Test(expected=NomeOuReceitaNuloException.class)
	public void atualizarUsandoReceitaNula() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		Receita receita = new Receita("Papanus Assado");
		receitator.atualizar("Farinha Polvilhada", receita);
	}
	
	@Test(expected=NomeInvalidoException.class)
	public void atualizarUsandoNomeInvalido() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		receitator.atualizar("Nome que não tem no livro de receitas", receita2);
	}
	
	@Test
	public void excluirReceita() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		receitator.excluir("Farinha polvilhada");
		List<Receita> esperado = new ArrayList<>();
		assertEquals(esperado,receitator.getTodasReceitas());
	}
	
	@Test(expected=NomeInvalidoException.class)
	public void excluirReceitaUsandoNomeInvalido() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		receitator.excluir("Nome que não tem no livro de receitas");
	}

	
	@Test
	public void buscarReceitaPeloNome() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		assertEquals(receita2,receitator.buscaReceitaPeloNome("Farinha polvilhada"));
	}
	
	@Test(expected=NomeInvalidoException.class)
	public void buscarReceitaPeloNomeUsandoNomeInvalido() throws Exception {
		Receitator receitator = new Receitator();
		Ingrediente farinha = new Ingrediente("Farinha",200,UnidadeMedida.GRAMA);
		Instrucao polvilhar = new Instrucao("Polvilhe a farinha.");
		Receita receita2 = new Receita("Farinha polvilhada");
		receita2.adicionarIngrediente(farinha);
		receita2.adicionarInstrucao(polvilhar);
		receitator.inserir(receita2);
		receitator.buscaReceitaPeloNome("Nome que não tem no livro de receitas");
	}
	
}