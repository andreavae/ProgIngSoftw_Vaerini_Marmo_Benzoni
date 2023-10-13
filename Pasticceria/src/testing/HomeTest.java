package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import model.ClientePremium;
import model.Home;
import model.User;

public class HomeTest {
	private Home home;

	@Before
	public void setUp() {
		home = new Home(null); // Passiamo null come LoginIF poiché non è rilevante per questi test.
	}

	@Test
	public void testGetClientePremium() {
		User utente = new User("admin", "admin");
		User cliente = home.getCliente(utente, true);

		assertTrue(cliente instanceof ClientePremium);
		assertEquals("admin", cliente.getUsername());
		assertEquals("admin", cliente.getPassword());
	}

	@Test
	public void testGetClienteNonPremium() {
		User utente = new User("user", "user");
		User cliente = home.getCliente(utente, false);

		assertTrue(cliente instanceof Cliente);
		assertEquals("user", cliente.getUsername());
		assertEquals("user", cliente.getPassword());
	}
}
