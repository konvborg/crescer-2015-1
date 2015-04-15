
/**
 * Define o erro lançado quando um elfo não pode ser alistado
 * @author Mauricio Borges
 */
public class NaoPodeAlistarException extends Exception
{
    public NaoPodeAlistarException(){
        super("Erro ao alistar um Elfo. Por favor tente novamente e se o erro persistir contate o administrador");
    }
}
