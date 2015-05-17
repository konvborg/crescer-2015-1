package filmator;

public enum Genero {

	COMEDIA("Comédia"),
	DRAMA("Drama"),
	ACAO("Ação");
	
	private String descricao;

	private Genero(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}
