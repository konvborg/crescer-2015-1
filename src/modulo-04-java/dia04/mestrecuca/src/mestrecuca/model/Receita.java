package mestrecuca.model;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList< >();
	private List<Instrucao> instrucoes = new ArrayList<>();
	
	public Receita(String nome){
		this.nome = nome;
	}
	
	public void adicionarIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}
	
	public void adicionarInstrucao(Instrucao instrucao){
		this.instrucoes.add(instrucao);
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public List<Instrucao> getInstrucoes() {
		return instrucoes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double calcularValorTotal(){
		double total = 0;
		for(Ingrediente ingrediente : ingredientes){
			total += ingrediente.getPreco();
		}
		return total;
	}

	public boolean contemUmDosIngredientes(List<String> ingredientesProibidos) {
		for(Ingrediente ingrediente : ingredientes){
			if(ingredientesProibidos.contains(ingrediente.getNome())){
				return true;
			}
		}
		return false;
	}
}
