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
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arrange
        Elfo elfo = new Elfo("O Elfo");
        Orc orc1 = new Orc();
        Orc orc2 = new Orc();
        // Act
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc1 = 100;
        int vidaEsperadaOrc2 = 100;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaOrc1, orc1.getVida());
        assertEquals(vidaEsperadaOrc2, orc2.getVida());
    }
    
    
    
    
    
    
    
    
    
    
    
}
