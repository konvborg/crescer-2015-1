import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Suíte de testes para ElfoNoturno.
 *
 * @author  CWI Software
 */
public class ElfoNoturnoTest
{
    private final double DELTA = 0.005;
    
    @Test
    public void quandoatirarFlechaGanha3DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        int experienciaEsperada = 3;
        elfoNoturno.atirarFlecha(new Orc());
        int experienciaObtido = elfoNoturno.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtido);
    }

    @Test
    public void quandoatirarDuasFlechasGanha6DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        int experienciaEsperada = 6;
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        int experienciaObtido = elfoNoturno.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtido);
    }

    @Test
    public void quandoatirarTresFlechasGanha9DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        int experienciaEsperada = 9;
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        int experienciaObtido = elfoNoturno.getExperiencia();
        assertEquals(experienciaEsperada, experienciaObtido);
    }

    @Test
    public void quandoatirarFlechaPerde5DeVida() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        double esperado = 95;
        elfoNoturno.atirarFlecha(new Orc());
        double obtido = elfoNoturno.getVida();

        assertEquals(esperado, obtido, DELTA); 
    }

    @Test
    public void quandoAtirarDuasFlechasPerde9ponto75DeVida() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        double esperado = 90.25;
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        double obtido = elfoNoturno.getVida();

        assertEquals(esperado, obtido, DELTA); 
    }

    @Test
    public void quandoAtirarTresFlechasPerde14pontos() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        double esperado = 85.7375;
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        elfoNoturno.atirarFlecha(new Orc());
        double obtido = elfoNoturno.getVida();

        assertEquals(esperado, obtido, DELTA); 
    }

    @Test
    public void quandoatirarFlechaStatusAtacando() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        Status statusEsperado = Status.ATACANDO;
        elfoNoturno.atirarFlecha(new Orc());
        Status obtido = elfoNoturno.getStatus();

        assertEquals(statusEsperado, obtido); 
    }

    @Test
    public void quandoAtirarMuitasFlechasStatusMorto() {
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Night Legolas");
        Status statusEsperado = Status.MORTO;

        for (int i = 0; i < 90; i++)
            elfoSuiçida.atirarFlecha(new Orc());

        Status obtido = elfoSuiçida.getStatus();

        assertEquals(statusEsperado, obtido); 
    }   
}