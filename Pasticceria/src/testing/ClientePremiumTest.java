package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.ClientePremium;

public class ClientePremiumTest {
	private ClientePremium clientePremium;

	@Before
	public void setUp() {
		clientePremium = new ClientePremium("admin", "admin");
	}

	@Test
	public void testFlagPremiumDefault() {
		// Verifica che il flagPremium sia impostato a true quando si crea un
		// ClientePremium
		assertTrue(clientePremium.isFlagPremium());
	}

	@Test
	public void testSetFlagPremium() {
		// Imposta il flagPremium su false
		clientePremium.setFlagPremium(false);
		assertFalse(clientePremium.isFlagPremium());
	}

	@Test
	public void testSetFlagPremiumTrue() {
		// Imposta il flagPremium su true
		clientePremium.setFlagPremium(true);
		assertTrue(clientePremium.isFlagPremium());
	}

	@Test
	public void testUsernameAndPassword() {
		// Verifica che il nome utente e la password siano correttamente inizializzati
		assertEquals("admin", clientePremium.getUsername());
		assertEquals("admin", clientePremium.getPassword());
	}
}
