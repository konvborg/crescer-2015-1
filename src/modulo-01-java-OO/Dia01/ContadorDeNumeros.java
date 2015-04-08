
/**
 * Objetos que conta.
 * 
 * @author Mauricio Borges 
 * 
 */
public class ContadorDeNumeros
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ContadorDeNumeros
     */
    public ContadorDeNumeros()
    {
    }
    public void contar(int m){   
        for(int i=1;i<=m;i++){
            System.out.println(i);
        }
    }
    public void contarRegressivamente(int m){   
        for(int i=m;i>0;i--){
            System.out.println(i);
        }
    }
}
