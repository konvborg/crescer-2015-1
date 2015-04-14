import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    private final double DELTA = 0.005;
    
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        double esperado = 110;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
    public void orcNasceVivo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        Status esperado = Status.VIVO;
        Status obtido = umOrc.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");

        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        double esperado = 100;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");

        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        double esperado = 90;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        double esperado = 60;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcFicaFeridoAoReceberAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");

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
        double esperado = 0;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110.0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Urukhai");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100.0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
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
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0.0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";   
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null; 
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        Status esperado = Status.MORTO;
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
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        
        double vidaEsperada = 110.0;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        double vidaEsperada = 110.0;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        orc.recebeAtaque();
        
        double vidaEsperada = 100.0;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void quandoAdicionoAdagaAoInventario() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        // Act
        urukhai.adicionarItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert...
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventario() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        inventarioEsperado.add(escudo);
        // Act
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaAoInventarioEPercoAdaga() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        urukhai.adicionarItem(adaga);
        // Act
        urukhai.perderItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventarioEPercoEscudo() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        // Act
        urukhai.perderItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void getDescricoesComNenhumItem() {
        // Arrange
        Orc urukhai = new Orc();
        String descricoesEsperada = "";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComUmItem() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        urukhai.adicionarItem(adaga);
        String descricoesEsperada = "Adaga";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo de carvalho");
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        String descricoesEsperada = "Adaga,Escudo de carvalho";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.setStatus(Status.DORMINDO);
        urukhai.setExperiencia(3);
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }
    
    @Test
    public void getMaiorQuantidadeComNenhumItem() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = null;
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComUmItem() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = new ItemDoInventario(1, "Light Saber");
        orc.adicionarItem(esperado);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComDoisOuMaisItensComAMesmaQuantidade() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = new ItemDoInventario(0, "Gatorade da Vovó");
        ItemDoInventario duplicado = new ItemDoInventario(0, "Gatorade da Vovó");
        orc.adicionarItem(esperado);
        orc.adicionarItem(duplicado);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComVariosItensComDiferentesQuantidades() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(15, "Adaga");
        ItemDoInventario pocao = new ItemDoInventario(2, "Poções");
        ItemDoInventario flecha = new ItemDoInventario(17, "Poções");
        ItemDoInventario pedraPreciosa = new ItemDoInventario(9, "Pedras preciosas");
        ItemDoInventario beyBlade = new ItemDoInventario(18, "BeyBlade");
        orc.adicionarItem(adaga);
        orc.adicionarItem(pocao);
        orc.adicionarItem(flecha);
        orc.adicionarItem(pedraPreciosa);
        orc.adicionarItem(beyBlade);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(beyBlade, resultado);
    }
    
    @Test
    public void ordenarItensComInventarioVazio() {
        // Arrange
        Orc orc = new Orc();
        ArrayList<ItemDoInventario> inventarioVazio = new ArrayList<>();
        // Act
        orc.ordenarItens();
        // Assert
        assertEquals(inventarioVazio, orc.getItens());
    }
    
    @Test
    public void ordenarItensComUmItem() {
        // Arrange
        Orc orc = new Orc();
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario adaga = new ItemDoInventario(12, "Adaga");
        inventarioEsperado.add(adaga);
        orc.adicionarItem(adaga);
        // Act
        orc.ordenarItens();
        // Assert
        assertEquals(inventarioEsperado, orc.getItens());
    }
    
    @Test
    public void ordenarItensComDoisItens() {
        // Arrange
        Orc orc = new Orc();
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario adaga = new ItemDoInventario(12, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(1, "Escudo de carvalho");
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(adaga);
        orc.adicionarItem(adaga);
        orc.adicionarItem(escudo);
        // Act
        orc.ordenarItens();
        // Assert
        assertEquals(inventarioEsperado, orc.getItens());
    }
    
    @Test
    public void ordenarItensComNegativoEIguais() {
        // Arrange
        Orc orc = new Orc();
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario adaga = new ItemDoInventario(15, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(15, "Escudo de carvalho");
        ItemDoInventario pikachu = new ItemDoInventario(-2, "Pikachu");
        ItemDoInventario foneTrakinas = new ItemDoInventario(-5, "Fone trakinas");
        ItemDoInventario patinete = new ItemDoInventario(3, "Patinete da Sandy");
        inventarioEsperado.add(foneTrakinas);
        inventarioEsperado.add(pikachu);
        inventarioEsperado.add(patinete);
        inventarioEsperado.add(adaga);
        inventarioEsperado.add(escudo);        
        orc.adicionarItem(adaga);
        orc.adicionarItem(escudo);
        orc.adicionarItem(pikachu);
        orc.adicionarItem(foneTrakinas);        
        orc.adicionarItem(patinete);        
        // Act
        orc.ordenarItens();
        // Assert
        assertEquals(inventarioEsperado, orc.getItens());
    }
}
