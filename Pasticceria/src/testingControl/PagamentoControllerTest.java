package testingControl;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.PagamentoController;
import model.Ordine;
import model.OrdinePersonalizzato;
import model.OrdineStandard;
import model.User;
import view.LoginIF;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class PagamentoControllerTest {

	@Mock
	private User utente;
	@Mock
	private PagamentoIF pagamentoif;
	@Mock
	private VisualizzaOrdineIF visualizzaordineif;
	@Mock
	private OrdineStandard carrello;
	@Mock
	private Ordine ordine;
	@Mock
	private LoginIF loginif;
	@Mock
	private OrdinePersonalizzato ordinepersonalizzato;
	@Mock
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;

	private PagamentoController pagamentoController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		pagamentoController = new PagamentoController(utente, pagamentoif, visualizzaordineif, carrello, ordine,
				loginif);
	}

	@Test
    public void testPagamentoStandardActionPerformed() {
        // Simula il comportamento di utente non VIP
        when(loginif.getClientePremiumRadioButton().isSelected()).thenReturn(false);

        // Crea un evento fittizio per il pagamento standard
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Pagamento Standard");

        // Esegui l'azione sull'ascoltatore "pagamentostandard"
        pagamentoController.new pagamentostandard().actionPerformed(actionEvent);

        // Verifica il comportamento corretto dopo il pagamento
        // Puoi utilizzare Mockito per verificare le chiamate ai metodi e i messaggi visualizzati
        verify(pagamentoif).dispose(); // Assicurati che la finestra di pagamento sia stata chiusa
        verify(ordine).isOrderValid(eq(ordine), eq(utente), anyDouble()); // Verifica il comportamento di ordine
        verify(carrello).svuotaCarrello(); // Assicurati che il carrello sia stato svuotato
       // verify(pagamentoif).showMessageDialog(eq("Pagamento confermato!")); // Assicurati che sia visualizzato un messaggio
    }

}
