package filmator;

public enum Genero {
	COMEDIA(0,"Com�dia"),
	ACAO(0,"A��o"),
	DRAMA(0,"Drama"),
	EPICO(0,"�pico");
	int n;
	String desc;
	private Genero(int n, String desc){
		this.n=n;
		this.desc=desc;
	}
	public void adicionarNumero(){
		this.n++;
	}
}
