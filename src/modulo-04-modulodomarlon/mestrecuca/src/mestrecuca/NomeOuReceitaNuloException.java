package mestrecuca;

public class NomeOuReceitaNuloException extends RuntimeException {
		public NomeOuReceitaNuloException(){
			super("Nome ou Receita não podem ser nulos.");
		}
}
