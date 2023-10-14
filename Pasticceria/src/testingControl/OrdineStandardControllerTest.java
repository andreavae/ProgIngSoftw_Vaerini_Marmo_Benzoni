package testingControl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import control.OrdineStandardController;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdineStandardIF;

public class OrdineStandardControllerTest {

	private OrdineStandardController ordineStandardController;
	private OrdineStandardIFStub ordineStandardIFStub;
	private UserStub userStub;
	private HomeIFStub homeIFStub;
	private LoginIFStub loginIFStub;

	@Before
	public void setUp() {
		ordineStandardIFStub = new OrdineStandardIFStub();
		userStub = new UserStub();
		homeIFStub = new HomeIFStub();
		loginIFStub = new LoginIFStub();

		ordineStandardController = new OrdineStandardController(userStub, ordineStandardIFStub, null, homeIFStub, null,
				loginIFStub);
	}

	@Test
	public void testAddProdottoCheesecake() {
		// Simuliamo l'azione di aggiunta di un prodotto (es. Cheesecake)
		ordineStandardIFStub.cheesecakeListener.actionPerformed(null);

		// Verifichiamo che il prodotto sia stato aggiunto correttamente al carrello
		assertEquals(1, ordineStandardController.carrello.getCarrello().size());
		assertEquals("Cheesecake", ordineStandardController.carrello.getCarrello().get(0).getNome());
		assertEquals(15, ordineStandardController.carrello.getCarrello().get(0).getPrezzo(), 0.01);
	}

	@Test
	public void testVisualizzaOrdineNonVip() {
		// Simuliamo un utente non VIP
		loginIFStub.clientePremiumRadioButtonSelected = false;

		// Simuliamo l'azione di visualizzazione dell'ordine
		ordineStandardIFStub.visualizzaOrdineListener.actionPerformed(null);

		// Verifichiamo che sia stato creato un VisualizzaOrdineIF senza sconto
		assertTrue(ordineStandardIFStub.visualizzaOrdineIFCreated);
		assertEquals(0, ordineStandardIFStub.scontoApplicato, 0.01);
	}

	@Test
	public void testVisualizzaOrdineVip() {
		// Simuliamo un utente VIP
		loginIFStub.clientePremiumRadioButtonSelected = true;

		// Simuliamo l'azione di visualizzazione dell'ordine
		ordineStandardIFStub.visualizzaOrdineListener.actionPerformed(null);

		// Verifichiamo che sia stato creato un VisualizzaOrdineIF con sconto
		assertTrue(ordineStandardIFStub.visualizzaOrdineIFCreated);
		assertEquals(0.3, ordineStandardIFStub.scontoApplicato, 0.01);
	}

	// Classe stub per OrdineStandardIF
	private class OrdineStandardIFStub extends OrdineStandardIF {
		public boolean visualizzaOrdineIFCreated = false;
		public double scontoApplicato = 0;

		@Override
		public void addCheesecake(ActionListener listener) {
			cheesecakeListener = listener;
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
	}

	// Classe stub per LoginIF
	private class LoginIFStub extends LoginIF {
		public boolean clientePremiumRadioButtonSelected = false;

		@Override
		public boolean getClientePremiumRadioButton() {
			return clientePremiumRadioButtonSelected;
		}
	}
}
