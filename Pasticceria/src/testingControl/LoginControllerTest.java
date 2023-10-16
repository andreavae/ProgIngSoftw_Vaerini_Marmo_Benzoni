package testingControl;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import control.LoginController;
import control.LoginController.LoginListener;
import model.User;
import view.LoginIF;

public class LoginControllerTest {
	private LoginIF loginif;
	private User user;
	private LoginController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		loginif = Mockito.mock(LoginIF.class);
		user = Mockito.mock(User.class);
		controller = new LoginController(loginif, user);
	}

	@After
	public void tearDown() {
		loginif = null;
		user = null;
		controller = null;
	}

	@Test
	public void testLoginListenerWithValidUser() {
		// Simuliamo un utente e password validi
		Mockito.when(loginif.getUsernameField()).thenReturn("utenteValido");
		Mockito.when(loginif.getPasswordField()).thenReturn("passwordValida");
		Mockito.when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);
		Mockito.when(user.isLoginValid()).thenReturn(true);

		// Simuliamo un evento di azione
		ActionEvent mockEvent = Mockito.mock(ActionEvent.class);
		controller.new LoginListener().actionPerformed(mockEvent);

		// Verifichiamo che il messaggio di accesso riuscito sia visualizzato
		Mockito.verify(loginif).setVisible(false);
	}

	@Test
	public void testLoginListenerWithInvalidUser() {
		// Simuliamo un utente o password non validi
		Mockito.when(loginif.getUsernameField()).thenReturn("utenteNonValido");
		Mockito.when(loginif.getPasswordField()).thenReturn("passwordNonValida");
		Mockito.when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);
		Mockito.when(user.isLoginValid()).thenReturn(false);

		// Simuliamo un evento di azione
		ActionEvent mockEvent = Mockito.mock(ActionEvent.class);
		controller.new LoginListener().actionPerformed(mockEvent);

		// Verifichiamo che il messaggio di accesso fallito sia visualizzato
		Mockito.verify(loginif).setVisible(false);
	}
}
