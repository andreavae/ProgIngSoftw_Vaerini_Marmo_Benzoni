package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import control.LoginController;
import model.User;
import view.IntroIF;
import view.LoginIF;

public class LoginControllerTest {

	private LoginController loginController;
	private LoginIFStub loginIFStub;
	private UserStub userStub;

	@Before
	public void setUp() {
		loginIFStub = new LoginIFStub();
		userStub = new UserStub();
		loginController = new LoginController(loginIFStub, userStub);
	}

	@Test
	public void testActionPerformedSuccess() {
		// Simula un utente con login valido
		userStub.setLoginValid(true);
		loginIFStub.setUsernameField("username");
		loginIFStub.setPasswordField("password");
		loginIFStub.setClientePremiumRadioButtonSelected(false);

		// Simula un evento fittizio per il login
		loginIFStub.loginListener.actionPerformed(null);

		// Verifica che il messaggio di successo sia visualizzato
		assertTrue(loginIFStub.showDialogCalled);
		assertTrue(loginIFStub.successMessageDisplayed);
	}

	@Test
	public void testActionPerformedFailure() {
		// Simula un utente con login non valido
		userStub.setLoginValid(false);
		loginIFStub.setUsernameField("username");
		loginIFStub.setPasswordField("password");
		loginIFStub.setClientePremiumRadioButtonSelected(false);

		// Simula un evento fittizio per il login
		loginIFStub.loginListener.actionPerformed(null);

		// Verifica che il messaggio di errore sia visualizzato
		assertTrue(loginIFStub.showDialogCalled);
		assertTrue(loginIFStub.failureMessageDisplayed);
	}

	@Test
	public void testActionPerformedVIPSuccess() {
		// Simula un utente con login valido e VIP
		userStub.setLoginValid(true);
		loginIFStub.setUsernameField("username");
		loginIFStub.setPasswordField("password");
		loginIFStub.setClientePremiumRadioButtonSelected(true);

		// Simula un evento fittizio per il login
		loginIFStub.loginListener.actionPerformed(null);

		// Verifica che il messaggio di successo per utente VIP sia visualizzato
		assertTrue(loginIFStub.showDialogCalled);
		assertTrue(loginIFStub.vipSuccessMessageDisplayed);
	}

	@Test
	public void testActionPerformedVIPFailure() {
		// Simula un utente VIP senza login valido
		userStub.setLoginValid(false);
		loginIFStub.setUsernameField("username");
		loginIFStub.setPasswordField("password");
		loginIFStub.setClientePremiumRadioButtonSelected(true);

		// Simula un evento fittizio per il login
		loginIFStub.loginListener.actionPerformed(null);

		// Verifica che il messaggio di errore per utente VIP sia visualizzato
		assertTrue(loginIFStub.showDialogCalled);
		assertTrue(loginIFStub.vipFailureMessageDisplayed);
	}

	@Test
	public void testBackActionPerformed() {
		// Simula un evento fittizio per tornare all'introduzione
		loginIFStub.backListener.actionPerformed(null);

		// Verifica che l'interfaccia di Login sia nascosta e quella di Intro sia
		// visibile
		assertFalse(loginIFStub.isVisible());
		assertTrue(loginIFStub.introIF.isVisible());
	}

	// Classe stub per LoginIF
	private class LoginIFStub extends LoginIF {
		public IntroIF introIF;
		public boolean showDialogCalled = false;
		public boolean successMessageDisplayed = false;
		public boolean failureMessageDisplayed = false;
		public boolean vipSuccessMessageDisplayed = false;
		public boolean vipFailureMessageDisplayed = false;

		@Override
		public void addLoginListener(ActionListener listener) {
			loginListener = listener;
		}

		@Override
		public void addBackListener(ActionListener listener) {
			backListener = listener;
		}

		@Override
		public String getUsernameField() {
			return usernameField;
		}

		@Override
		public String getPasswordField() {
			return passwordField;
		}

		@Override
		public boolean getClientePremiumRadioButtonSelected() {
			return clientePremiumRadioButtonSelected;
		}

		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				if (introIF != null) {
					introIF.setVisible(true);
				}
			} else {
				if (introIF != null) {
					introIF.setVisible(false);
				}
			}
			this.isVisible = visible;
		}

		@Override
		public void showMessageDialog(Object parentComponent, Object message, String title, int messageType) {
			showDialogCalled = true;
			if (message instanceof String) {
				String messageString = (String) message;
				if (messageString.contains("Accesso riuscito!")) {
					successMessageDisplayed = true;
				} else if (messageString.contains("Accesso fallito")) {
					failureMessageDisplayed = true;
				} else if (messageString.contains("Accesso riuscito. Utente riconosciuto come cliente Premium")) {
					vipSuccessMessageDisplayed = true;
				} else if (messageString.contains("Utente non riconosciuto come cliente Premium")) {
					vipFailureMessageDisplayed = true;
				}
			}
		}
	}

	// Classe stub per User
	private class UserStub extends User {
		private boolean loginValid;

		public void setLoginValid(boolean loginValid) {
			this.loginValid = loginValid;
		}

		@Override
		public boolean isLoginValid() {
			return loginValid;
		}
	}
}
