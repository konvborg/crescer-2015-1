package mestrecuca;

public class NomeInvalidoException extends RuntimeException{
	public NomeInvalidoException(){
		super("Nome não encontrado");
	}
}
