import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnaTest
{
    private final double DELTA = 0.05;
    
    @Test
    public void tresElfosNoturnosEm9AtaquesApenasDoisAtacam() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaNoturna());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo night3 = new ElfoNoturno("Night 3");
        exercito.alistar(night1);
        exercito.alistar(night2);
        exercito.alistar(night3);        
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(39, night1.getFlechas()); // perdeu 1 flecha por orc
        assertEquals(85.73, night1.getVida(), DELTA); // perdendo 5% para cada um dos 3 orcs
        assertEquals(39, night2.getFlechas()); // perdeu 1 flecha por orc
        assertEquals(85.73, night2.getVida(), DELTA); // perdendo 5% para cada um dos 3 orcs
        // este elfo não atacou pois estourou 30% dos ataques
        assertEquals(42, night3.getFlechas());
        assertEquals(100.0, night3.getVida(), DELTA); // perdendo 5% para cada um dos 3 orcs
    }
}
