import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void orcNasceComNomeInformado(){
        //arrange
        Orc umOrc = new Orc("Juarez");
        //act
        String esperado = "Juarez";
        String obtido = umOrc.getNome();
        // Assert
        assertEquals(esperado,obtido);
    }
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        // Assert - Verificação
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void orcRecebeAtaqueUmaVezFicaFerido() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void testeToString(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 110.";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void testeToStringAposReceberUmAtaque(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 100.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringAposReceberDozeAtaques(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 0.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero(){
        //Arrange
        Orc umOrc = new Orc("Joao");
        //act
        umOrc.recebeAtaque();
        int vidaEsperada = 110;
        int expEsperada = 2;
        //Assert
        assertEquals(vidaEsperada, umOrc.getVida());
        assertEquals(expEsperada, umOrc.getExperiencia());
    }
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMaiorQueCem(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        umOrc.recebeAtaque();
        int vidaEsperada = 100;
        //Assert
        assertEquals(vidaEsperada, umOrc.getVida());
    }
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntreCemEZero(){
        //Arrange
        Orc umOrc = new Orc("Juares");
        //act
        umOrc.setExperiencia(1);
        umOrc.recebeAtaque();
        int vidaEsperada = 110;
        int expEsperada = 1;
        //Assert
        assertEquals(vidaEsperada, umOrc.getVida());
        assertEquals(expEsperada, umOrc.getExperiencia());
    }
    @Test
    public void orcRecebeUmIem(){
       //Arrange
       Orc orc = new Orc("Daniela Mercury");
       ItemDoInventario adaga = new ItemDoInventario("Berimbau metalizado",2);
       //Act
       orc.adicionarItem(adaga);
       orc.perderItem(adaga);
       ArrayList <ItemDoInventario> arrayTemp = new ArrayList<ItemDoInventario>();
       //Act
       assertEquals(arrayTemp,orc.itens);
       
    }
}




