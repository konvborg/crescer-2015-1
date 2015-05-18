package whatevator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Letratorteste {
	@Test
	public void palavraComLetrasMaiusculas() throws Exception {
		Letrator oi = new Letrator();
		ArrayList<Integer> atual = oi.getIndiceMaisculas("OlaTd");
		ArrayList<Integer> esperado = new ArrayList<>();
		esperado.add(0);
		esperado.add(3);
		assertEquals(esperado, atual);
	}
	
	@Test
	public void palavraComMuitasLetrasMaiusculas() throws Exception {
		Letrator oi = new Letrator();
		ArrayList<Integer> atual = oi.getIndiceMaisculas("OlaTdMuitoLegal");
		ArrayList<Integer> esperado = new ArrayList<>();
		esperado.add(0);
		esperado.add(3);
		esperado.add(5);
		esperado.add(10);
		assertEquals(esperado, atual);
	}
}
