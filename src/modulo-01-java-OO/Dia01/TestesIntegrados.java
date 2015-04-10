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
        Orc orc1 = new Orc("Urukhai 1");
        Orc orc2 = new Orc("Urukhai 2");
        // Act
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc = 100;
        String toStringEsperadoOrc = "Vida atual: 100";
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaOrc, orc1.getVida());
        assertEquals(vidaEsperadaOrc, orc2.getVida());
        assertEquals(toStringEsperadoOrc, orc1.toString());
        assertEquals(toStringEsperadoOrc, orc2.toString());
    }
    
    
    
    
    
    
    
    
    
    
    
}
