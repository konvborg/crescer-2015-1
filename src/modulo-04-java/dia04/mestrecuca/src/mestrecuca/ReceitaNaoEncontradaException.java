package mestrecuca;

public class ReceitaNaoEncontradaException extends RuntimeException {

	public ReceitaNaoEncontradaException(String nome){
		super(String.format("Receita %s não encontada", nome));
	}
}
