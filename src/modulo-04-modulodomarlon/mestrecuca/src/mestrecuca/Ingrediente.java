package mestrecuca;

public class Ingrediente {
	public String nome;
	public double quantidade;
	public UnidadeMedida unidade;
	
	public Ingrediente(String nome, double quantidade, UnidadeMedida unidade){
		this.nome=nome;
		this.quantidade=quantidade;
		this.unidade=unidade;
	}

}