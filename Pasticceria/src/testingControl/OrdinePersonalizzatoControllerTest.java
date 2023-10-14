package testingControl;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.OrdinePersonalizzatoController;
import model.OrdinePersonalizzato;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdinePersonalizzatoIF;

public class OrdinePersonalizzatoControllerTest {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private HomeIF homeif;
	private LoginIF loginif;
	private OrdinePersonalizzatoController controller;

	@Before
	public void setUp() {
		utente = Mockito.mock(User.class);
		ordinepersonalizzatoif = Mockito.mock(OrdinePersonalizzatoIF.class);
		ordinepersonalizzato = Mockito.mock(OrdinePersonalizzato.class);
		homeif = Mockito.mock(HomeIF.class);
		loginif = Mockito.mock(LoginIF.class);

		controller = new OrdinePersonalizzatoController(utente, ordinepersonalizzatoif, homeif, ordinepersonalizzato,
				loginif);
	}

	@Test
	public void testConstructor() {
		assertNotNull(controller);
	}

	@Test
	public void testBackButtonActionPerformed() {
		// Simulare un evento di pressione del pulsante "Back"
		// Mockito.when(ordinepersonalizzatoif.getDataConsegnaField()).thenReturn(dataConsegna);
		controller.new back().actionPerformed(null);

		// Verifica che l'interfaccia "ordinepersonalizzatoif" sia nascosta e che
		// "homeif" sia visualizzata
		Mockito.verify(ordinepersonalizzatoif).setVisible(false);
		Mockito.verify(homeif).setVisible(true);
	}

	@Test
	public void testVisualizzaOrdinePersonalizzatoActionPerformed() {
		// Simulare un evento di pressione del pulsante "Visualizza Ordine
		// Personalizzato"
		/*
		 * Mockito.when(ordinepersonalizzatoif.getDataConsegnaField()).thenReturn(
		 * "data_consegna");
		 * Mockito.when(ordinepersonalizzatoif.getOccasioneComboBox()).thenReturn(
		 * "occasione");
		 * Mockito.when(ordinepersonalizzatoif.getPianiComboBox()).thenReturn("piani");
		 * Mockito.when(ordinepersonalizzatoif.getnPersoneComboBox()).thenReturn(
		 * "persone");
		 * Mockito.when(ordinepersonalizzato.numerodeipiani("piani")).thenReturn(10.0);
		 * Mockito.when(ordinepersonalizzato.numerodipersone("persone")).thenReturn(5.0)
		 * ;
		 * Mockito.when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(
		 * true);
		 */
		controller.new VisualizzaOrdinePersonalizzato().actionPerformed(null);

		// Verifica che venga creata un'istanza di VisualizzaOrdinePersonalizzatoIF e
		// VisualizzaOrdinePersonalizzatoController
		// e che vengano impostate le corrispondenti chiamate di metodo.
		/*
		 * Mockito.verify(ordinepersonalizzato).dataConsegna("data_consegna");
		 * Mockito.verify(ordinepersonalizzato).occasione("occasione");
		 * Mockito.verify(ordinepersonalizzato).pianiStringa("piani");
		 * Mockito.verify(ordinepersonalizzato).personeStringa("persone");
		 * Mockito.verify(ordinepersonalizzato).numerodeipiani("piani");
		 * Mockito.verify(ordinepersonalizzato).numerodipersone("persone");
		 */
		// Verifica che l'interfaccia "visualizzaordinepersionalizzatoif" sia
		// visualizzata
		Mockito.verify(ordinepersonalizzatoif).setVisible(true);
	}
}
