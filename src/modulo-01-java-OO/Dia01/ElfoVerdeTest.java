import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Testes para classe ElfoVerde.
 *
 * @author  CWI Software
 */
public class ElfoVerdeTest
{
    @Test
    public void quandoatirarFlechaGanha2() {
        ElfoVerde elfoVerde = new ElfoVerde("Green Legolas");
        int experienciaEsperada = 2;
        elfoVerde.atirarFlecha(new Orc());
        int experienciaObtida = elfoVerde.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtida);
    }

    @Test
    public void quandoatirarFlechaDuasVezesGanha4() {
        ElfoVerde elfoVerde = new ElfoVerde("Denethor, filho de Lenwë");
        int experienciaEsperada = 4;
        elfoVerde.atirarFlecha(new Orc());
        elfoVerde.atirarFlecha(new Orc());
        int experienciaObtida = elfoVerde.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtida);
    }

    @Test
    public void quandoatirarFlechaCincoVezesGanha10() {
        ElfoVerde elfoVerde = new ElfoVerde("Green Legolas");
        int experienciaEsperada = 10;
        elfoVerde.atirarFlecha(new Orc());
        elfoVerde.atirarFlecha(new Orc());
        elfoVerde.atirarFlecha(new Orc());
        elfoVerde.atirarFlecha(new Orc());
        elfoVerde.atirarFlecha(new Orc());
        int experienciaObtida = elfoVerde.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtida);
    }

    @Test
    public void quandoAdicionaItemNulo() {
        ElfoVerde elfoVerde = new ElfoVerde("Denethor, filho de Lenwë");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        elfoVerde.adicionarItem(null);
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void quandoAdicionaItemComDescricaoInvalida() {
        ElfoVerde elfoVerde = new ElfoVerde("Denethor, filho de Lenwë");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        elfoVerde.adicionarItem(new ItemDoInventario(1, "Canivete suiço"));
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionaUmItemComDescricaoValida() {
        ElfoVerde elfoVerde = new ElfoVerde("Denethor, filho de Lenwë");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        ItemDoInventario espadaValiriana = new ItemDoInventario(1, "Espada de aço valiriano");
        inventarioEsperado.add(espadaValiriana);
        elfoVerde.adicionarItem(espadaValiriana);
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionaDoisItensComDescricaoValida() {
        ElfoVerde elfoVerde = new ElfoVerde("Denethor, filho de Lenwë");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        ItemDoInventario espadaValiriana = new ItemDoInventario(1, "Espada de aço valiriano");
        ItemDoInventario arcoEFlechaVidro = new ItemDoInventario(2, "Arco e Flecha de vidro");
        inventarioEsperado.add(espadaValiriana);
        inventarioEsperado.add(arcoEFlechaVidro);
        elfoVerde.adicionarItem(espadaValiriana);
        elfoVerde.adicionarItem(new ItemDoInventario(2, "Botas de couro"));
        elfoVerde.adicionarItem(arcoEFlechaVidro);
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        assertEquals(inventarioEsperado, inventarioObtido);
    }
}
