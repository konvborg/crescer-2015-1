/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status = Status.VIVO; 

    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
    public Orc()
    {
        //vida = 110;
    }
    **/
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        this.vida -= 10;
        status = Status.FERIDO;
        if(this.vida<=0){
            status = Status.MORTO;
        }
        // this.vida = this.vida - 10;
    }
    
    public int getVida() {
        return this.vida;
    }
    /**
     * Imprime a vida atual do Orc
     * 
     * @return String com a vida atual do Orc. Ex. Vida Atual: 110
     */
    public String toString(){
        return String.format("Vida Atual: %d. Status: %s.",
                    this.vida,
                    this.status
                    );
  }
  
    //public String toString(){
    //    return "oi";
    //}
    
}