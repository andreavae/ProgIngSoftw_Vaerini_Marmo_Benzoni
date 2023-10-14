package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import control.OrdinePersonalizzatoController;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdinePersonalizzatoIF;

public class OrdinePersonalizzatoControllerTest {

	private OrdinePersonalizzatoController ordinePersonalizzatoController;
	private OrdinePersonalizzatoIFStub ordinePersonalizzatoIFStub;
	private UserStub userStub;
	private HomeIFStub homeIFStub;
	private LoginIFStub loginIFStub;

	@Before
	public void setUp() {
		ordinePersonalizzatoIFStub = new OrdinePersonalizzatoIFStub();
		userStub = new UserStub();
		homeIFStub = new HomeIFStub();
		loginIFStub = new LoginIFStub();

		ordinePersonalizzatoController = new OrdinePersonalizzatoController(userStub, ordinePersonalizzatoIFStub,
				homeIFStub, null, loginIFStub);
	}

	@Test
	public void testBackActionPerformed() {
		// Simuliamo un evento "back"
		ordinePersonalizzatoIFStub.backListener.actionPerformed(null);

		// Verifichiamo che l'interfaccia di OrdinePersonalizzato sia nascosta e quella
		// di Home sia visibile
		assertFalse(ordinePersonalizzatoIFStub.isVisible());
		assertTrue(homeIFStub.isVisible());
	}

	@Test
	public void testVisualizzaOrdinePersonalizzato() {
		// Simuliamo un evento "VisualizzaOrdinePersonalizzato"
		ordinePersonalizzatoIFStub.visualizzaOrdineListener.actionPerformed(null);

		// Verifichiamo che venga creata un'istanza di VisualizzaOrdinePersonalizzatoIF
		// e il suo controller
		assertTrue(ordinePersonalizzatoIFStub.visualizzaOrdinePersonalizzatoIFCreated);
	}

	// Classe stub per OrdinePersonalizzatoIF
	private class OrdinePersonalizzatoIFStub extends OrdinePersonalizzatoIF {
		public boolean visualizzaOrdinePersonalizzatoIFCreated = false;

		@Override
		public void addBackListener(ActionListener listener) {
			backListener = listener;
		}

		@Override
		public void visualizzaOrdine(ActionListener listener) {
			visualizzaOrdineListener = listener;
		}
	}

	// Classe stub per User
	private class UserStub extends User {
	}

	// Classe stub per HomeIF
	private class HomeIFStub extends HomeIF {
		@Override
		public void setVisible(boolean visible) {
			this.isVisible = visible;
		}
	}

	// Classe stub per LoginIF
	private class LoginIFStub extends LoginIF {
		@Override
		public boolean getClientePremiumRadioButton() {
			return false;
		}
	}
}
