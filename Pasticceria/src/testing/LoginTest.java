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

}
