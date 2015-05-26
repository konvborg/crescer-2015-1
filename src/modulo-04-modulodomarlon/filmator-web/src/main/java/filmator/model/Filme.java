package filmator.model;

public class Filme {

	private String nome;
	private int anoLancamento;
	private Genero genero;
	private String sinopse;
	
	public Filme(){
	}
	
	public Filme(String nome){
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
