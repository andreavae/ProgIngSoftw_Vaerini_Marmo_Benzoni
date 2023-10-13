package testingView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import view.LoginIF;

public class LoginIFTest {
	private LoginIF loginIF;

	@Before
	public void setUp() {
		loginIF = new LoginIF();
	}

	@Test
	public void testGetUsernameField() {
		loginIF.setUsernameFieldText("admin");
		assertEquals("admin", loginIF.getUsernameField());
	}

	@Test
	public void testGetPasswordField() {
		loginIF.setPasswordFieldText("user");
		assertEquals("user", loginIF.getPasswordField());
	}

	@Test
	public void testGetClientePremiumRadioButton() {
		JRadioButton radioButton = loginIF.getClientePremiumRadioButton();
		assertTrue(radioButton != null);
	}

	@Test
	public void testAddLoginListener() {
		ActionListener listener = e -> System.out.println("Login button clicked");
		loginIF.addLoginListener(listener);
		// Implementa una logica per verificare che l'ActionListener sia stato associato
		// al pulsante Login
		// Ad esempio, verifica che sia stato associato l'ActionListener desiderato.
	}

	@Test
	public void testAddBackListener() {
		ActionListener listener = e -> System.out.println("Back button clicked");
		loginIF.addBackListener(listener);
		// Implementa una logica per verificare che l'ActionListener sia stato associato
		// al pulsante Back
		// Ad esempio, verifica che sia stato associato l'ActionListener desiderato.
	}
}
