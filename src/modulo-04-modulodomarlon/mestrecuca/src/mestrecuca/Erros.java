package mestrecuca;

public class Erros{
	public static NomeInvalidoException nomeInvalidoException() throws NomeInvalidoException {
        throw new NomeInvalidoException();
    }
	public static NomeOuReceitaNuloException nomeOuReceitaNuloException() throws NomeOuReceitaNuloException {
        throw new NomeOuReceitaNuloException();
    }
}
