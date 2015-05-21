package mestrecuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mestrecuca.model.Ingrediente;
import mestrecuca.model.Receita;

public class LivroDaVovo implements LivroReceitas {

	private List<Receita> receitas = new ArrayList<Receita>();
	
	@Override
	public void inserir(Receita receita) {
		validaReceita(receita);
		receitas.add(receita);
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		validaReceita(receitaAtualizada);
		Receita receita = buscaReceitaPeloNome(nome);
		int indice = receitas.indexOf(receita);
		receitas.set(indice, receitaAtualizada);
	}

	@Override
	public void excluir(String nome) {
		Receita receita = buscaReceitaPeloNome(nome);
		int indice = receitas.indexOf(receita);
		receitas.remove(indice);
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return receitas;
	}
	
	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		for(Receita receita : receitas){
			if(receita.getNome().equals(nome)){
				return receita;
			}
		}
		throw new ReceitaNaoEncontradaException(nome);
	}
	
	private void validaReceita(Receita receita){
		String nome = receita.getNome();
		if(nome == null ||nome.trim().equals("")){
			throw new IllegalArgumentException("Nome de receita nulo ou inválido");
		}
	}

	public double calcularValorReceitas(Receita... receitas) {
		double total = 0;
		for(Receita receita : receitas){
			total += receita.calcularValorTotal();
		}
		return total;
	}

	public List<Receita> buscaReceitasSemIngrediente(List<String> ingredientesProibidos) {
		List<Receita> resultado = new ArrayList<>();
		for(Receita receita : receitas){
			if(!receita.contemUmDosIngredientes(ingredientesProibidos)){
				resultado.add(receita);
			}
		}
		return resultado;
	}

	public Map<Ingrediente, Double> geraListaDeCompras(List<Receita> receitas) {
		Map<Ingrediente, Double> listaDeCompras = new HashMap<>();
		for(Receita receita : receitas){
			for(Ingrediente ingrediente : receita.getIngredientes()){
				double quantidadeAcumulada = listaDeCompras.getOrDefault(ingrediente, 0.0);
				double quantidadeDoIngrediente = ingrediente.getQuantidade();
				listaDeCompras.put(ingrediente, quantidadeAcumulada + quantidadeDoIngrediente);
			}
		}
		return listaDeCompras;
		
	}
	

}
