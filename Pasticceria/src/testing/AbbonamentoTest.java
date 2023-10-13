package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Abbonamento;
import model.User;

class AbbonamentoTest {

	@Test
	void testgetUtente() {
		User utente = new User("admin", "admin");
		Abbonamento abbonamento = new Abbonamento(utente);
		User flag = abbonamento.getUtente();
		assertEquals(utente, flag);

	}

	@Test
	void testgetId() {
		User utente = new User("admin", "admin");
		Abbonamento abbonamento = new Abbonamento(utente);
		int expectedId = abbonamento.getId();
		assertEquals(expectedId, abbonamento.getId());

	}

}
