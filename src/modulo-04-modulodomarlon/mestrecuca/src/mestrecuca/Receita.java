package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	public String nome;
	public List<Ingrediente> listaIngrediente = new ArrayList<>();
	public List<Instrucao> listaInstrucao = new ArrayList<>();
	
	public Receita(String nome){
		this.nome=nome;
	}
	
	public void adicionarIngrediente(Ingrediente ingrediente){
		this.listaIngrediente.add(ingrediente);
	}
	
	public void adicionarInstrucao(Instrucao instrucao){
		this.listaInstrucao.add(instrucao);
	}
	
	public double calcularValor(){
		double soma=0;
		for(Ingrediente ingrediente: listaIngrediente){
			soma+=ingrediente.valor;
		}
		return soma;
	}
	
	
}
