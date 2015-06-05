package filmator.model;

public class Avaliacao {
	private int idfilme;
	private int idusuario;
	private int nota;
	
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getNota() {
		return nota;
	}
	public int getIdfilme() {
		return idfilme;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
}
