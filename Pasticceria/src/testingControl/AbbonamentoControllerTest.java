package testingControl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.AbbonamentoController;
import model.Abbonamento;
import model.User;
import view.AbbonamentoIF;
import view.HomeIF;

public class AbbonamentoControllerTest {

	@Mock
	private AbbonamentoIF abbonamentoif;
	@Mock
	private Abbonamento abbonamento;
	private User utente;
	private AbbonamentoController abbonamentoController;
	private HomeIF homeif;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // Inizializza i mock

		// Crea un utente fittizio per i test
		utente = new User("admin", "admin");

		abbonamentoController = new AbbonamentoController(utente, abbonamento, abbonamentoif, homeif);
	}

	@Test
    public void testAbbonatiActionPerformed_PagamentoAvvenutoConSuccesso() {
        // Simula il comportamento dell'utente in modo che ritorni true quando si chiama il metodo isSignVip.
        when(utente.isSignVip(anyString(), anyInt())).thenReturn(true);

        // Crea un evento fittizio per il pulsante "Diventa Premium"
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Diventa Premium");

        // Esegui l'azione sull'ascoltatore "abbonati"
        abbonamentoController.new abbonati().actionPerformed(actionEvent);

        // Verifica che sia stata mostrata la finestra di dialogo corretta
        verify(abbonamentoif).showMessageDialog("Sei diventato un Cliente Premium");
    }

	@Test
    public void testAbbonatiActionPerformed_PagamentoNonAvvenutoConSuccesso() {
        // Simula il comportamento dell'utente in modo che ritorni false quando si chiama il metodo isSignVip.
        when(utente.isSignVip(anyString(), anyInt())).thenReturn(false);

        // Crea un evento fittizio per il pulsante "Diventa Premium"
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Diventa Premium");

        // Esegui l'azione sull'ascoltatore "abbonati"
        abbonamentoController.new abbonati().actionPerformed(actionEvent);

        // Verifica che sia stata mostrata la finestra di dialogo corretta
        verify(abbonamentoif).showMessageDialog("Pagamento non avvenuto con successo!");
    }
}
