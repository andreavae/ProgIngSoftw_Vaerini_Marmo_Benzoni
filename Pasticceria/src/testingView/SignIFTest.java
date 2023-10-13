package testingView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import view.SignIF;

public class SignIFTest {

	private SignIF signFrame;

	@Before
	public void setUp() {
		signFrame = new SignIF();
	}

	@Test
	public void testSignUsernameField() {
		assertNotNull(signFrame.getSignUsernameField());
	}

	@Test
	public void testSignPasswordField() {
		assertNotNull(signFrame.getSignPasswordField());
	}

	@Test
	public void testRegistratiButton() {
		// Verifica che il pulsante di registrazione sia abilitato
		assertTrue(signFrame.registratiButton.isEnabled());
	}

	@Test
	public void testBackButton() {
		// Verifica che il pulsante "Back" sia abilitato
		assertTrue(signFrame.BackButton.isEnabled());
	}
}
