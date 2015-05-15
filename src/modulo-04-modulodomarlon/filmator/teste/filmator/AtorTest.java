package filmator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtorTest {
	@Test
	public void CriaComNome() throws Exception {
		Ator ator = new Ator("Nome");
		assertEquals("Nome",ator.toString());
	}
}
