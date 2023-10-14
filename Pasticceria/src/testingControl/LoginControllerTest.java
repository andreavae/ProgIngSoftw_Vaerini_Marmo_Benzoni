package testingControl;

import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import control.LoginController;
import model.User;
import view.LoginIF;

public class LoginControllerTest {

	@Mock
	private LoginIF loginif;
	private User user;
	private LoginController loginController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // Inizializza i mock

		// Crea un utente fittizio per i test
		user = new User("cliente", "cliente");

		loginController = new LoginController(loginif, user);
	}

	@Test
    public void testLoginListenerActionPerformed_LoginValid() {
        // Simula il comportamento dell'utente in modo che ritorni true quando si chiama il metodo isLoginValid().
        when(loginif.getClientePremiumRadioButton()).thenReturn(Mockito.mock(JRadioButton.class));
        when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);
        when(user.isLoginValid()).thenReturn(true);

        // Crea un evento fittizio per il pulsante di login
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Login");

        // Esegui l'azione sull'ascoltatore "LoginListener"
        loginController.new LoginListener().actionPerformed(actionEvent);

        // Verifica che sia stata creata un'istanza di HomeIF
     //   assertNotNull(loginif.getHomeIF());

        // Verifica che sia stato creato un HomeController
       // assertNotNull(loginif.getHomeController());
    }

	@Test
    public void testLoginListenerActionPerformed_LoginInvalid() {
        // Simula il comportamento dell'utente in modo che ritorni false quando si chiama il metodo isLoginValid().
        when(loginif.getClientePremiumRadioButton()).thenReturn(Mockito.mock(JRadioButton.class));
        when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);
        when(user.isLoginValid()).thenReturn(false);

        // Crea un evento fittizio per il pulsante di login
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Login");

        // Esegui l'azione sull'ascoltatore "LoginListener"
        loginController.new LoginListener().actionPerformed(actionEvent);

        // Verifica che non sia stata creata un'istanza di HomeIF
      //  assertNull(loginif.getHomeIF());

        // Verifica che non sia stato creato un HomeController
       // assertNull(loginif.getHomeController());
    }
}
