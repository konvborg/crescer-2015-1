package mestrecuca;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceitaTeste {
	@Test
	public void calculaValor() throws Exception {
		Ingrediente legal = new Ingrediente("Oi",2,UnidadeMedida.GRAMA,2);
		Ingrediente louco = new Ingrediente("Oi",2,UnidadeMedida.GRAMA,9);
		Receita loucolegal = new Receita("Louco Legal");
		loucolegal.adicionarIngrediente(legal);
		loucolegal.adicionarIngrediente(louco);
		double esperado = 11;
		double resultado = loucolegal.calcularValor();
		assertEquals(esperado,resultado,0.000005);
	}

}
