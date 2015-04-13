/**
 * @author Mauricio Borges
 */
public class ElfoNoturno extends Elfo
{
public ElfoNoturno(String nome){
    super(nome,42);
    }
/**
 * Chama o método atirar flecha, mas ganha três de experiência e perde 5% da vida atual.
 * @param umOrc Orc que vai receber a flecha.
 */
protected void atirarFlecha(Orc umOrc) {
    //flechas = flechas - 1;
    super.atirarFlecha(umOrc);
    experiencia++;
    experiencia++;
    vida=vida-(vida/20);
    }
}