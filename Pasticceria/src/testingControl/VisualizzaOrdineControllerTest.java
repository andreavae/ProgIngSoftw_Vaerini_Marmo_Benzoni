package testingControl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.VisualizzaOrdineController;
import model.Ordine;
import model.OrdineStandard;
import model.User;
import view.LoginIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineControllerTest {

	@Mock
	private User utente;
	@Mock
	private VisualizzaOrdineIF visualizzaordineif;
	@Mock
	private Ordine ordine;
	@Mock
	private OrdineStandard carrello;
	@Mock
	private LoginIF loginif;

	private VisualizzaOrdineController visualizzaOrdineController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		visualizzaOrdineController = new VisualizzaOrdineController(utente, visualizzaordineif, carrello, ordine,
				loginif);
	}

	@Test
	public void testBackActionPerformed() {
		// Crea un evento fittizio per il pulsante "Back"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Back");

		// Esegui l'azione sull'ascoltatore "back"
		visualizzaOrdineController.new back().actionPerformed(actionEvent);

		// Verifica il comportamento corretto dopo il clic sul pulsante "Back"
		verify(visualizzaordineif).setVisible(false); // Assicurati che la finestra di visualizzazione ordine sia
														// nascosta
	}

	@Test
	public void testConfermaActionPerformed() {
		// Crea un evento fittizio per il pulsante "Conferma"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Conferma");

		// Simula che l'utente sia VIP
		when(utente.isVipUser(utente.getUsername())).thenReturn(true);

		// Esegui l'azione sull'ascoltatore "conferma"
		visualizzaOrdineController.new conferma().actionPerformed(actionEvent);

		// Verifica che sia stato creato un oggetto PagamentoIF e PagamentoController
		// verifyNew(PagamentoIF.class).withNoArguments();
		// verifyNew(PagamentoController.class).withArguments(utente,
		// any(PagamentoIF.class), visualizzaordineif, carrello,
		// ordine, loginif);
	}

}
