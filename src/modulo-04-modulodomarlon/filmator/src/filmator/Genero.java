package filmator;

public enum Genero {
	COMEDIA("Com�dia"),
	ACAO("A��o"),
	DRAMA("Drama"),
	EPICO("�pico");
	String desc;
	private Genero(String desc){
		this.desc=desc;
	}
}
