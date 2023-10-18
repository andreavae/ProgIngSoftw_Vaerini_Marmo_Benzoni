package testingControl;

import static org.mockito.Mockito.verify;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.VisualizzaOrdinePersonalizzatoController;
import model.Ordine;
import model.OrdinePersonalizzato;
import model.User;
import view.LoginIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoControllerTest {

	@Mock
	private User utente;
	@Mock
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;
	@Mock
	private OrdinePersonalizzato ordinepersonalizzato;
	@Mock
	private LoginIF loginif;
	@Mock
	private Ordine ordine;
	@Mock
	private VisualizzaOrdinePersonalizzatoController visualizzaOrdinePersonalizzatoController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		visualizzaOrdinePersonalizzatoController = new VisualizzaOrdinePersonalizzatoController(utente,
				visualizzaordinepersonalizzatoif, ordinepersonalizzato, loginif, ordine);
	}

	@Test
	public void testBackActionPerformed() {
		// Crea un evento fittizio per il pulsante "Back"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Back");

		// Esegui l'azione sull'ascoltatore "back"
		visualizzaOrdinePersonalizzatoController.new back().actionPerformed(actionEvent);

		// Verifica il comportamento corretto dopo il clic sul pulsante "Back"
		verify(visualizzaordinepersonalizzatoif).setVisible(false); // Assicurati che la finestra di visualizzazione
																	// ordine sia nascosta
	}

	@Test
	public void testConfermaActionPerformed() {
		// Crea un evento fittizio per il pulsante "Conferma"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Conferma");

		// Esegui l'azione sull'ascoltatore "conferma"
		visualizzaOrdinePersonalizzatoController.new conferma().actionPerformed(actionEvent);

		// Verifica che sia stato creato un oggetto PagamentoIF e PagamentoController
		// verifyNew(PagamentoIF.class).withNoArguments();
		// verifyNew(PagamentoController.class).withArguments(utente,
		// any(PagamentoIF.class), ordinepersonalizzato,
		// visualizzaordinepersonalizzatoif, loginif, ordine);
	}
}
