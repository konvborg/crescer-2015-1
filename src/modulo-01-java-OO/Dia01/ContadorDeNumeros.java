/**
 * Objeto que sabe contar números em ordem!
 * 
 * @author CWI Software
 */
public class ContadorDeNumeros
{
    private static int x;
    private int y;
    
    public static void contarAte5() {
        x = 10;
        for (int i = 0; i < 5; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarAte3() {
        
        x = 11;
        
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
