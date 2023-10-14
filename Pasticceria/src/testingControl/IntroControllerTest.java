package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import control.IntroController;
import view.IntroIF;
import view.LoginIF;
import view.SignIF;

public class IntroControllerTest {

	private IntroController introController;
	private IntroIFStub introIFStub;

	@Before
	public void setUp() {
		introIFStub = new IntroIFStub();
		introController = new IntroController(introIFStub);
	}

	@Test
	public void testOpenLogin() {
		// Simula un evento fittizio per aprire l'interfaccia di login
		introIFStub.openLoginActionPerformed(null);

		// Verifica che l'interfaccia Intro sia nascosta e quella di Login sia visibile
		assertFalse(introIFStub.isVisible());
		assertTrue(introIFStub.loginIF.isVisible());
	}

	@Test
	public void testOpenSign() {
		// Simula un evento fittizio per aprire l'interfaccia di registrazione (Sign)
		introIFStub.openSignActionPerformed(null);

		// Verifica che l'interfaccia Intro sia nascosta e quella di Sign sia visibile
		assertFalse(introIFStub.isVisible());
		assertTrue(introIFStub.signIF.isVisible());
	}

	// Classe stub per IntroIF
	private class IntroIFStub extends IntroIF {
		public LoginIF loginIF;
		public SignIF signIF;

		@Override
		public void openLogin(ActionListener listener) {
			loginIF = new LoginIF();
			listener.actionPerformed(null);
		}

		@Override
		public void openSign(ActionListener listener) {
			signIF = new SignIF();
			listener.actionPerformed(null);
		}
	}
}
