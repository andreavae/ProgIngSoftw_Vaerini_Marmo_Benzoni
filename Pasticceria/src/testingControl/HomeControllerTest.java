package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import control.HomeController;
import model.User;
import view.AbbonamentoIF;
import view.HomeIF;
import view.OrdinePersonalizzatoIF;
import view.OrdineStandardIF;

public class HomeControllerTest {

	private HomeController homeController;
	private HomeIFStub homeIFStub;
	private UserStub userStub;

	@Before
	public void setUp() {
		homeIFStub = new HomeIFStub();
		userStub = new UserStub();

		homeController = new HomeController(homeIFStub, "user", "user");
	}

	@Test
	public void testOpenNuovoOrdineIF() {
		// Simula un evento fittizio per aprire l'ordine standard
		homeIFStub.openNuovoOrdineIF(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

		// Verifica che l'interfaccia Home sia nascosta e quella dell'Ordine Standard
		// sia visibile
		assertFalse(homeIFStub.isVisible());
		assertTrue(homeIFStub.ordineStandardIF.isVisible());
	}

	@Test
	public void testOpenOrdinePersonalizzatoIF() {
		// Simula un evento fittizio per aprire l'ordine personalizzato
		homeIFStub.openOrdinePersonalizzatoIFActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

		// Verifica che l'interfaccia Home sia nascosta e quella dell'Ordine
		// Personalizzato sia visibile
		assertFalse(homeIFStub.isVisible());
		assertTrue(homeIFStub.ordinePersonalizzatoIF.isVisible());
	}

	@Test
	public void testOpenSconto() {
		// Simula un evento fittizio per aprire l'interfaccia con sconto
		homeIFStub.openScontoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

		// Verifica che l'interfaccia Home sia nascosta e quella con sconto sia visibile
		assertFalse(homeIFStub.isVisible());
		assertTrue(homeIFStub.homeIFVIP.isVisible());
	}

	@Test
	public void testOpenAbbonamento() {
		// Simula un evento fittizio per aprire l'interfaccia di abbonamento
		homeIFStub.openAbbonamentoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

		// Verifica che l'interfaccia di abbonamento sia visibile
		assertTrue(homeIFStub.abbonamentoIF.isVisible());
	}

	// Classe stub per HomeIF
	private class HomeIFStub extends HomeIF {
		public OrdineStandardIF ordineStandardIF;
		public OrdinePersonalizzatoIF ordinePersonalizzatoIF;
		public HomeIF homeIFVIP;
		public AbbonamentoIF abbonamentoIF;

		@Override
		public void openNuovoOrdineIF(ActionListener listener) {
			ordineStandardIF = new OrdineStandardIF(userStub, 0);
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}

		public boolean isVisible() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void openOrdinePersonalizzato(ActionListener listener) {
			ordinePersonalizzatoIF = new OrdinePersonalizzatoIF(userStub, 0);
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}

		@Override
		public void openSconto(ActionListener listener) {
			homeIFVIP = new HomeIF(userStub, this, 0.3);
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}

		@Override
		public void openAbbonamento(ActionListener listener) {
			abbonamentoIF = new AbbonamentoIF();
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}
	}

	// Classe stub per User
	private class UserStub extends User {
		// Aggiungere eventuali metodi o attributi necessari per il test
	}
}
