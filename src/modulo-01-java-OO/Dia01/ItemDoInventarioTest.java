

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste do ItemDoInventarioTest.
 *
 * @autor Mauricio Borges
 */
public class ItemDoInventarioTest
{
    @Test
    public void criarItemComDescricaoEQuantidade() {
        // Arrange
        ItemDoInventario item = new ItemDoInventario("Loucura",1);
        // Act
        int quantesperada = 1;
        String descesperada = "Loucura";
        // Assert
        assertEquals(quantesperada, item.getQuantidade());
        assertEquals(descesperada, item.getDescricao());
    }
    
}
