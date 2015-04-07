

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
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Juarez");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
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
        int esperado = -10;
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
        String esperado = "Vida Atual: -10.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcComNomeFugindoRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        umOrc.setStatus(Status.FUGINDO);
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 90.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcSemNomeFugindoRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc();
        //act
        umOrc.setStatus(Status.FUGINDO);
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 110.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcSemNomeRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc();
        //act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 110.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcComNomeRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc("Juarez");
        //act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 90.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcCom15deVidaRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc();
        //act
        umOrc.setVida(15);
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 15.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcCom15deVidaFugindoRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc();
        //act
        umOrc.setVida(15);
        umOrc.setStatus(Status.FUGINDO);
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 15.";
        assertEquals(esperado, resultadoObtido);
    }
    @Test
    public void testeToStringOrcCom4ExpRecebeDoisAtaques(){
        //Arrange
        Orc umOrc = new Orc();
        //act
        umOrc.setExperiencia(4);
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        //Assert
        String esperado = "Vida Atual: 110.";
        assertEquals(esperado, resultadoObtido);
    }
}




