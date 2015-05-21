package mestrecuca.model;


public class Ingrediente {

	private String nome;
	private double quantidade;
	private double preco;
	private UnidadeMedida unidadeMedida;
	
	public Ingrediente(String nome, UnidadeMedida unidade, double quantidade, double preco){
		this.nome = nome;
		this.unidadeMedida = unidade;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Ingrediente(String nome, UnidadeMedida unidade){
		this.nome = nome;
		this.unidadeMedida = unidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		return true;
	}

	
	
}
