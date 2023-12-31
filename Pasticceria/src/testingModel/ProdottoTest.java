package testingModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Prodotto;

public class ProdottoTest {
	private Prodotto prodotto1;
	private Prodotto prodotto2;

	@Before
	public void setUp() {
		prodotto1 = new Prodotto("Prodotto 1", "immagine1.jpg", 10.0);
		prodotto2 = new Prodotto("Prodotto 2", 20.0);
	}

	@Test
	public void testGetNome() {
		assertEquals("Prodotto 1", prodotto1.getNome());
		assertEquals("Prodotto 2", prodotto2.getNome());
	}

	@Test
	public void testGetPrezzo() {
		assertEquals(10.0, prodotto1.getPrezzo(), 0.01);
		assertEquals(20.0, prodotto2.getPrezzo(), 0.01);
	}

}