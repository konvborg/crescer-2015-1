package filmator.model;

public enum Genero {
	COMEDIA("Comédia"),
	ACAO("Ação"),
	DRAMA("Drama"),
	EPICO("Épico");
	String desc;
	private Genero(String desc){
		this.desc=desc;
	}
}
