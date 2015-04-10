import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes unitários da classe ItemDoInventario
 *
 * @author CWI Software
 */
public class ItemDoInventarioTest
{
    @Test
    public void criarItemComQuantidadeDescricaoInformadas() {
        // Arrange
        int quantidadeEsperada = 12;
        String descricaoEsperada = "Martelo de Thor - Mjollnir";
        // Act
        ItemDoInventario item = new ItemDoInventario(quantidadeEsperada, descricaoEsperada);
        // Assert
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
    
    @Test
    public void criarItemComQuantidadeNegativaDescricaoNula() {
        // Arrange
        int quantidadeEsperada = -3456;
        String descricaoEsperada = null;
        // Act
        ItemDoInventario item = new ItemDoInventario(quantidadeEsperada, descricaoEsperada);
        // Assert
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
}
