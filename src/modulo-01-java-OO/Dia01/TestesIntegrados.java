import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  CWI Software
 */
public class TestesIntegrados
{
    private final double DELTA = 0.005;
    
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arrange
        Elfo elfo = new Elfo("O Elfo");
        Orc orc1 = new Orc("Urukhai 1");
        Orc orc2 = new Orc("Urukhai 2");
        // Act
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        double vidaEsperadaOrc = 100.0;
        String toStringEsperadoOrc = "Vida atual: 100.0";
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaOrc, orc1.getVida(), DELTA);
        assertEquals(vidaEsperadaOrc, orc2.getVida(), DELTA);
        assertEquals(toStringEsperadoOrc, orc1.toString());
        assertEquals(toStringEsperadoOrc, orc2.toString());
    }
    
    
    
    
    
    
    
    
    
    
    
}
