/**
 * Define o erro lançado quando um elfo não pode ser alistado.
 * 
 * @author CWI Software
 */
public class NaoPodeAlistarException extends Exception {    
    
    public NaoPodeAlistarException() {
        super("Erro ao alistar um Elfo. Por favor tente novamente e se o error persistir contate o Adminstrador.");
    }
}
