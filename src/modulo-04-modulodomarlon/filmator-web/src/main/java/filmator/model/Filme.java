package filmator.model;

public class Filme {

	private int id;
	private String nome;
	private int anoLancamento;
	private Genero genero;
	private String sinopse;
	private double media;
	private int nota;
	private String imagem;
	
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
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public void setId(int idfilme) {
		this.id = idfilme;
	}
	public int getId() {
		return id;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getNota() {
		return nota;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
