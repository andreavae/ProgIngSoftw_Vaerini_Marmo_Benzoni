package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.User;

class LoginTest {

	@Test
	void test() {
		User utente = new User("admin", "admin");
		boolean flag = utente.isLoginValid();
		assertEquals(true, flag);
	}

	@Test
	void test2() {
		User utente = new User("admin", "admin");
		boolean flagvip = utente.isVipUser("admin");
		assertEquals(true, flagvip);
	}

	@Test
	void test3() {
		User utente = new User("admin", "admin");
		boolean flagvip = utente.isVipLoginValid();
		assertEquals(true, flagvip);
	}

	@Test
	void test4() {
		User utente = new User("admin", "admin");
		boolean flagsign = utente.isSignValid();
		assertEquals(true, flagsign);
	}

	/*
	 * @Test void test5() { User utente = new User("user", 2); boolean flagsignvip =
	 * utente.isSignVip(); assertEquals(true, flagsignvip); }
	 */
}
