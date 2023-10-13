package testingModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.OrdineStandard;
import model.Prodotto;
import model.User;

public class OrdineStandardTest {
	private OrdineStandard ordineStandard;

	@Before
	public void setUp() {
		User utente = new User("user", "user");
		ordineStandard = new OrdineStandard(utente, 0); // 0% di sconto
	}

	@Test
	public void testAddProdotto() {
		Prodotto prodotto = new Prodotto("Test Product", "test.jpg", 20.0);
		ordineStandard.addProdotto(prodotto);
		List<Prodotto> carrello = ordineStandard.getCarrello();
		assertNotNull(carrello);
		assertEquals(1, carrello.size());
		assertTrue(carrello.contains(prodotto));
	}

	@Test
	public void testGetTotale() {
		Prodotto prodotto1 = new Prodotto("Product 1", "product1.jpg", 20.0);
		Prodotto prodotto2 = new Prodotto("Product 2", "product2.jpg", 30.0);
		ordineStandard.addProdotto(prodotto1);
		ordineStandard.addProdotto(prodotto2);
		double totale = ordineStandard.getTotale(0);
		// Il totale dovrebbe essere (20 + 30) = 50.0
		assertEquals(50.0, totale, 0.01);
	}

	@Test
	public void testSvuotaCarrello() {
		Prodotto prodotto = new Prodotto("Test Product", "test.jpg", 20.0);
		ordineStandard.addProdotto(prodotto);
		List<Prodotto> carrello = ordineStandard.svuotaCarrello();
		assertNotNull(carrello);
		assertEquals(0, carrello.size());
	}

	@Test
	public void testToString() {
		Prodotto prodotto1 = new Prodotto("Product 1", "product1.jpg", 20.0);
		Prodotto prodotto2 = new Prodotto("Product 2", "product2.jpg", 30.0);
		ordineStandard.addProdotto(prodotto1);
		ordineStandard.addProdotto(prodotto2);
		String toStringResult = ordineStandard.toString();
		assertTrue(toStringResult.contains("Carrello"));
		assertTrue(toStringResult.contains("Product 1"));
		assertTrue(toStringResult.contains("Product 2"));
	}
}
