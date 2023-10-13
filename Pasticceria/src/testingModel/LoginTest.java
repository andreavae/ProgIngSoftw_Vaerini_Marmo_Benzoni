package testingModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.User;

class LoginTest {

	@Test
	void testisLoginValid() {
		User utente = new User("admin", "admin");
		boolean flagValid = utente.isLoginValid();
		assertEquals(true, flagValid);
	}

	@Test
	void testisVipUSer() {
		User utente = new User("admin", "admin");
		boolean flagvipUser = utente.isVipUser("admin");
		assertEquals(true, flagvipUser);
	}

	@Test
	void testisVipLogin() {
		User utente = new User("admin", "admin");
		boolean flagvipLogin = utente.isVipLoginValid();
		assertEquals(true, flagvipLogin);
	}

	@Test
	void testisSignValid() {
		User utente = new User("cliente", "cliente");
		boolean flagsignValid = utente.isSignValid();
		assertEquals(true, flagsignValid);
	}

	@Test
	void testisSignVip() {
		User utente = new User("admin", "admin");
		boolean flagsignVip = utente.isSignVip("admin", 1);
		assertEquals(true, flagsignVip);
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
