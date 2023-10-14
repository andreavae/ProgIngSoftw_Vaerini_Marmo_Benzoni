package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Component;

import org.junit.Before;
import org.junit.Test;

import control.VisualizzaOrdinePersonalizzatoController;
import model.Ordine;
import model.OrdinePersonalizzato;
import model.User;
import view.LoginIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoControllerTest {
	private User utente;
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private LoginIF loginif;
	private Ordine ordine;

	@Before
	public void setUp() {
		// Inizializza gli oggetti necessari prima di ciascun test
		User utente = new User("user", "user");
		visualizzaordinepersonalizzatoif = new VisualizzaOrdinePersonalizzatoIF(utente, null, null, null, null, 0, 0);
		ordinepersonalizzato = new OrdinePersonalizzato(utente);
		loginif = new LoginIF();
		ordine = new Ordine(utente);
	}

	@Test
	public void testBackButton() {
		// Assicurati che VisualizzaOrdinePersonalizzatoController sia in grado di
		// gestire l'evento del pulsante "back".

		// Simula il clic sul pulsante "back".
		visualizzaordinepersonalizzatoif.back(new VisualizzaOrdinePersonalizzatoController.back());

		// Verifica che la finestra VisualizzaOrdinePersonalizzatoIF non sia più
		// visibile.
		assertFalse(visualizzaordinepersonalizzatoif.isVisible());
	}

	@Test
	public void testConfermaButton() {
		// Assicurati che VisualizzaOrdinePersonalizzatoController sia in grado di
		// gestire l'evento del pulsante "conferma".

		// Simula il clic sul pulsante "conferma".
		VisualizzaOrdinePersonalizzatoController controller = new VisualizzaOrdinePersonalizzatoController(utente,
				visualizzaordinepersonalizzatoif, ordinepersonalizzato, loginif);
		visualizzaordinepersonalizzatoif.conferma(controller.new conferma());

		Component pagamentoif = null;
		// Verifica che la finestra PagamentoIF sia visibile.
		assertTrue(pagamentoif.isVisible());

		// Puoi aggiungere ulteriori asserzioni per verificare che le azioni previste
		// siano state eseguite correttamente.
	}
}
