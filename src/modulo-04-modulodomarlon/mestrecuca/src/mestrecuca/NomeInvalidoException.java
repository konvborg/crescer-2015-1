package mestrecuca;

public class NomeInvalidoException extends RuntimeException{
	public NomeInvalidoException(){
		super("Nome n�o encontrado");
	}
}
