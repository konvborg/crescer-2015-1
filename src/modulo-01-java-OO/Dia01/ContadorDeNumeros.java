/**
 * Objeto que sabe conta.
 * 
 * @author CWI Software
 */
public class ContadorDeNumeros
{
    public static void contarAte5() {
        for (int i = 0; i < 5; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarAte3() {        
        for (int i = 0; i < 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i + 1);
        }
        
        for (int i = 1; i <= 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
        
        for (int i = 1; i < 4; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
    } 
    
    public void contarAte(int numero) {
        for (int i = 0; i < numero; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarRegressivamente(int numero) {
        for (int i = numero; i > 0; i--) {
            // execute tudo que tem aqui dentro
            System.out.println(i);
        }
    }
}
