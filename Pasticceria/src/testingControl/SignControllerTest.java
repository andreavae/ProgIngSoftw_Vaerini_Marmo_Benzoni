package testingControl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import control.SignController;
import model.User;
import view.SignIF;

public class SignControllerTest {

	@Test
	public void testRegistrationSuccess() {
		User utente = new User("user", "user");
		SignIF signif = new SignIF();
		SignController controller = new SignController(signif, utente);

		// Simula un'azione di registrazione
		signif.getSignUsernameField().setText("testuser");
		signif.getSignPasswordField().setText("password");
		controller.new RegistratiListener().actionPerformed(null);

		// Verifica che il SignIF sia ancora visibile
		assertTrue(signif.isVisible());

	}

	@Test
	public void testRegistrationFailure() {
		User utente = new User("user", "user");
		SignIF signif = new SignIF();
		SignController controller = new SignController(signif, utente);

		// Simula un'azione di registrazione con dati errati
		signif.getSignUsernameField().setText("testuser");
		signif.getSignPasswordField().setText("wrongpassword");
		controller.new RegistratiListener().actionPerformed(null);

		// Verifica che il SignIF sia ancora visibile
		assertTrue(signif.isVisible());
	}
}
