package testingModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;

public class ClienteTest {
	private Cliente cliente;

	@Before
	public void setUp() {
		cliente = new Cliente("user", "user");
	}

	@Test
	public void testFlagPremiumDefault() {
		// Verifica che il flagPremium sia impostato a false per impostazione
		// predefinita
		assertFalse(cliente.isFlagPremium());
	}

	@Test
	public void testSetFlagPremium() {
		// Imposta il flagPremium su true
		cliente.setFlagPremium(true);
		assertTrue(cliente.isFlagPremium());
	}

	@Test
	public void testSetFlagPremiumFalse() {
		// Imposta il flagPremium su false
		cliente.setFlagPremium(false);
		assertFalse(cliente.isFlagPremium());
	}

	@Test
	public void testUsernameAndPassword() {
		// Verifica che il nome utente e la password siano correttamente inizializzati
		assertEquals("user", cliente.getUsername());
		assertEquals("user", cliente.getPassword());
	}
}
