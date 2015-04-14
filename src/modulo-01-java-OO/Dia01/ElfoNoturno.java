/**
 * Descreve comportamento dos Elfos Noturnos.
 * 
 * @author CWI Software
 */
public class ElfoNoturno extends Elfo
{   
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    /**
     * Atira a flecha em um orc, ganhando o triplo de experiência e perdendo 5% da vida atual.
     * 
     * @param Orc orc que receberá a flechada.
     */
    public void atirarFlecha(Orc orc) {
        super.atirarFlecha(orc);
        this.experiencia += 2;
        double qtdVidaAPerder = this.vida * 0.05;
        //double qtdVidaAPerder = this.vida * 5/100;
        this.vida -= qtdVidaAPerder;
        this.status = (int)this.vida == 0 ? Status.MORTO : this.status;
    }   

}