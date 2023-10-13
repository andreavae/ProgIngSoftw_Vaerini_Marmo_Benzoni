package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.User;

class LoginTest {

	@Test
	void testisLoginValid() {
		User utente = new User("admin", "admin");
		boolean flag = utente.isLoginValid();
		assertEquals(true, flag);
	}

	@Test
	void testisVipUSer() {
		User utente = new User("admin", "admin");
		boolean flagvip = utente.isVipUser("admin");
		assertEquals(true, flagvip);
	}

	@Test
	void testisVipLogin() {
		User utente = new User("admin", "admin");
		boolean flagvip = utente.isVipLoginValid();
		assertEquals(true, flagvip);
	}

	@Test
	void testisSignValid() {
		User utente = new User("cliente", "cliente");
		boolean flagsign = utente.isSignValid();
		assertEquals(true, flagsign);
	}

	@Test
	void testgetUsername() {
		User utente = new User("admin", "admin");
		String flagusername = utente.getUsername();
		assertEquals("admin", flagusername);
	}

	@Test
	void testgetPassword() {
		User utente = new User("admin", "admin");
		String flagpassword = utente.getPassword();
		assertEquals("admin", flagpassword);
	}
}
