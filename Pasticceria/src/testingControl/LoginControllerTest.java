package testingControl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import control.LoginController;
import model.User;
import view.LoginIF;

public class LoginControllerTest {
	private LoginController loginController;
	private LoginIF loginIf;
	private User user;

	@Before
	public void setUp() {
		loginIf = mock(LoginIF.class);
		user = new User("admin", "admin");
		user = mock(User.class);
		loginController = new LoginController(loginIf, user);
	}

	@Test
    public void testLoginListenerValid() {
        when(loginIf.getUsernameField()).thenReturn("admin");
        when(loginIf.getPasswordField()).thenReturn("admin");
        when(loginIf.getClientePremiumRadioButton().isSelected()).thenReturn(false);
        when(loginIf.getClientePremiumRadioButton().isSelected()).thenReturn(false);

        loginController.new LoginListener().actionPerformed(null);

        // Assert the expected behavior here
    }
	/*
	 * @Test public void testLoginListenerInvalid() {
	 * when(loginIf.getUsernameField()).thenReturn("invalidUsername");
	 * when(loginIf.getPasswordField()).thenReturn("invalidPassword");
	 * when(loginIf.getClientePremiumRadioButton().isSelected()).thenReturn(false);
	 * 
	 * loginController.new LoginListener().actionPerformed(null);
	 * 
	 * // Assert the expected behavior here }
	 */
}
