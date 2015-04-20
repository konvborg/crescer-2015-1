import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{
    @Test
    public void alistarElfoBaseNãoAlista(){
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        finally {
            System.out.println("Sdds BlueJ");
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarDoisElfosBaseNãoAlistaNenhum() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Arwen");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfo);
            exercito.alistar(elfo2);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoVerdeAlista() {
        // Arrange
        Elfo elfo = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act

        try {
            exercito.alistar(elfo);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoNoturnoAlista() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act

        try {
            exercito.alistar(elfo);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodos() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfo);
            exercito.alistar(elfo2);
            exercito.alistar(elfo3);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodosMenosBase() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        Elfo elfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfoBase);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        try {
            exercito.alistar(elfo);
            exercito.alistar(elfo2);
            exercito.alistar(elfo3);   
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void buscarElfoPeloNomeNãoAlistado() {
        // Arrange
        Elfo esperado = null;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        Elfo obtido = exercito.buscar("John Elf Doe");
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistado() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try {
            exercito.alistar(esperado);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistadoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try {
            exercito.alistar(esperado);
            exercito.alistar(new ElfoVerde("green elf"));
            exercito.alistar(new ElfoNoturno("Night Elf"));
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void agruparVariosElfosPorStatus() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        esperado.put(Status.ATACANDO, new ArrayList<Elfo>(
        Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
        Arrays.asList(elfoVivo3, elfoVivo2, elfoVivo1)
        ));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try {
            exercito.alistar(elfoAtacando1);
            exercito.alistar(elfoAtacando2);
            exercito.alistar(elfoVivo1);
            exercito.alistar(elfoVivo2);
            exercito.alistar(elfoVivo3);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Act
        exercito.agruparPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = exercito.getExercitoPorStatus();
        // Assert

        assertEquals(esperado, resultado);
    }
    
    @Test
    public void buscarPorStatusAtacandoComVariosElfos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        ArrayList<Elfo> esperado = new ArrayList<Elfo>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        );
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try {
            exercito.alistar(elfoAtacando1);
            exercito.alistar(elfoAtacando2);
            exercito.alistar(elfoVivo1);
            exercito.alistar(elfoVivo2);
            exercito.alistar(elfoVivo3);

        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        // Act
        ArrayList<Elfo> resultado = exercito.buscar(Status.ATACANDO);
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void alistarElfoBaseLançaErro() throws NaoPodeAlistarException {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfo);
        } catch (NaoPodeAlistarException error) {
            throw error;
        }
    }
}
