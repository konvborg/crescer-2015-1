package mestrecuca;

public class NomeOuReceitaNuloException extends RuntimeException {
		public NomeOuReceitaNuloException(){
			super("Nome ou Receita n�o podem ser nulos.");
		}
}
