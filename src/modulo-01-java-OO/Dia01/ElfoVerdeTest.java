

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtiraFlecha() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Burrito");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    @Test
    public void elfoVerdeRecebeArcoVidroeEspadaAçoValiriano() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Burrito");
        Orc orc = new Orc();
        ItemDoInventario espada = new ItemDoInventario(4,"Espada de aço valiriano");
        ItemDoInventario arco = new ItemDoInventario(1,"Arco e Flecha de Vidro");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(espada);
        inventarioEsperado.add(arco);
        // Act
        elfo.adicionarItem(espada);
        elfo.adicionarItem(arco);
        ArrayList<ItemDoInventario> inventarioObtido = elfo.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    @Test
    public void elfoVerdeRecebeItemQualquer() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Burrito");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario pinguim = new ItemDoInventario(1, "Pinguim Perneta");
        // Act
        elfo.adicionarItem(pinguim);
        ArrayList<ItemDoInventario> inventarioObtido = elfo.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
}
