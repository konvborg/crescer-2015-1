import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoAtiraFlecha() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Emo");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 3;
        int flechasEsperadas = 41;
        int vidaEsperada = 95;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    @Test
    public void elfoNoturnoAtira5Flechas() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Emo");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 15;
        int flechasEsperadas = 37;
        int vidaEsperada=79;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
}
