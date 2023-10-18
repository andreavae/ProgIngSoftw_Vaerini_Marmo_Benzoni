package testingControl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.OrdineStandardController;
import model.Ordine;
import model.OrdineStandard;
import model.Prodotto;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdineStandardIF;

public class OrdineStandardControllerTest {

	@Mock
	private OrdineStandardIF ordinestandardif;
	@Mock
	private OrdineStandard carrello;
	@Mock
	private User utente;
	@Mock
	private LoginIF loginif;
	@Mock
	private Ordine ordine;
	@Mock
	private HomeIF homeif;
	private OrdineStandardController ordinestandardController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // Inizializza i mock

		ordinestandardController = new OrdineStandardController(utente, ordinestandardif, homeif, ordine, loginif);
	}

	@Test
	public void testAddCheesecakeActionPerformed() {
		// Crea un evento fittizio per il pulsante "Cheesecake"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Cheesecake");

		// Esegui l'azione sull'ascoltatore "addCheesecake"
		ordinestandardController.new addCheesecake().actionPerformed(actionEvent);

		// Verifica che il prodotto "Cheesecake" sia stato aggiunto al carrello
		// correttamente
		verify(carrello).addProdotto(any(Prodotto.class));
	}

	// Esegui test simili per gli altri prodotti...

	@Test
    public void testVisualizzaOrdineActionPerformed() {
        // Simula il comportamento di utente non VIP
        when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);

        // Crea un evento fittizio per il pulsante "Visualizza Ordine"
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Visualizza Ordine");

        // Esegui l'azione sull'ascoltatore "visualizzaOrdine"
        ordinestandardController.new visualizzaOrdine().actionPerformed(actionEvent);

        // Verifica che sia stata creata un'istanza di VisualizzaOrdineIF senza sconto sul totale
       // verifyNew(VisualizzaOrdineIF.class).withArguments(loginif, utente, carrello, 0.0);
    }

	// Esegui test simili per utente VIP...

	@Test
	public void testBackActionPerformed() {
		// Crea un evento fittizio per il pulsante "Back"
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Back");

		// Esegui l'azione sull'ascoltatore "back"
		ordinestandardController.new back().actionPerformed(actionEvent);

		// Verifica che la finestra corrente venga nascosta e quella precedente sia resa
		// visibile
		verify(ordinestandardif).dispose();
		verify(homeif).setVisible(true);
	}
}
