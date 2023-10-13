package testingModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Ordine;
import model.User;

public class OrdineTest {

	@Test
	public void testOrdineValido() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		boolean flagOrdine = ordine.isOrderValid(ordine, utente, 12);
		assertEquals(true, flagOrdine);
	}

}