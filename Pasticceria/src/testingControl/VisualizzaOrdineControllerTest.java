package testingControl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import control.VisualizzaOrdineController;
import model.Ordine;
import model.OrdineStandard;
import model.User;
import view.LoginIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineControllerTest {
	private User utente;
	private VisualizzaOrdineIF visualizzaordineif;
	private OrdineStandard carrello;
	private Ordine ordine;
	private LoginIF loginif;

	@Before
	public void setUp() {
		// Inizializza gli oggetti necessari prima di ciascun test
		User utente = new User("admin", "admin");
		visualizzaordineif = new VisualizzaOrdineIF(loginif, utente, carrello, 0);
		carrello = new OrdineStandard(utente, 0);
		ordine = new Ordine(utente);
		loginif = new LoginIF();
	}

	@Test
	public void testBackButton() {
		// Assicurati che VisualizzaOrdineController sia in grado di gestire l'evento
		// del pulsante "back".

		// Simula il clic sul pulsante "back".
		visualizzaordineif.back(new VisualizzaOrdineController.back());

		// Verifica che la finestra VisualizzaOrdineIF non sia più visibile.
		assertFalse(visualizzaordineif.isVisible());
	}

	@Test
	public void testConfermaButton() {
		// Assicurati che VisualizzaOrdineController sia in grado di gestire l'evento
		// del pulsante "conferma".

		// Simula il clic sul pulsante "conferma".
		VisualizzaOrdineController controller = new VisualizzaOrdineController(utente, visualizzaordineif, carrello,
				ordine, loginif);
		visualizzaordineif.conferma(controller.new conferma());

		// Verifica che la finestra PagamentoIF sia visibile.
		assertTrue(pagamentoif.isVisible());

		// Puoi aggiungere ulteriori asserzioni per verificare che le azioni previste
		// siano state eseguite correttamente.
	}

	@Test
	public void testCancellaButton() {
		// Assicurati che VisualizzaOrdineController sia in grado di gestire l'evento
		// del pulsante "cancella".

		// Simula il clic sul pulsante "cancella".
		visualizzaordineif.cancellaOrdine(new VisualizzaOrdineController.cancella());

		// Verifica che la finestra VisualizzaOrdineIF sia stata chiusa.
		assertFalse(visualizzaordineif.isVisible());

		// Verifica che l'ordine sia stato cancellato.
		assertEquals(0, carrello.getNumeroProdotti());
	}
}
