import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContadorDeNumerosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContadorDeNumerosTest{
    @Test
    public void contarSemElfosCriados() {
        // Arrange
        int quantidadeEsperada = 0;
        // Act
        int quantidadeObtida = ContadorDeNumeros.getNumeroDeElfos();
        // Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    @Test
    public void criarElfoEContar() {
        // Arrange
        int quantidadeEsperada = 1;
        // Act
        Elfo elfo = new Elfo("Salogel");
        int quantidadeObtida = ContadorDeNumeros.getNumeroDeElfos();
        // Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    @Test
    public void criarElfoVerdeEContar() {
        // Arrange
        int quantidadeEsperada = 1;
        // Act
        ElfoVerde elfo = new ElfoVerde("Salogel Edrev");
        int quantidadeObtida = ContadorDeNumeros.getNumeroDeElfos();
        // Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    @Test
    public void criarElfoNoturnoEContar() {
        // Arrange
        int quantidadeEsperada = 1;
        // Act
        ElfoNoturno elfo = new ElfoNoturno("Salogel Onruton");
        int quantidadeObtida = ContadorDeNumeros.getNumeroDeElfos();
        // Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    @Test
    public void criarElfosDeTiposDiferentesEContar() {
        // Arrange
        int quantidadeEsperada = 6;
        // Act
        Elfo elfo1 = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Salogel");
        ElfoVerde elfov1 = new ElfoVerde("Legolas Verde");
        ElfoVerde elfov2 = new ElfoVerde("Salogel Edrev");
        ElfoNoturno elfon1 = new ElfoNoturno("Legolas Noturno");
        ElfoNoturno elfon2 = new ElfoNoturno("Salogel Onruton");
        int quantidadeObtida = ContadorDeNumeros.getNumeroDeElfos();
        // Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    @Before
    public void setUp(){
        ContadorDeNumeros.resetarNumeroDeElfos();
    }
    
}