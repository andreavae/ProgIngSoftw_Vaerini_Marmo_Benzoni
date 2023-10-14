package testingControl;

import org.junit.Before;
import org.junit.Test;

import control.AbbonamentoController;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

public class AbbonamentoControllerTest {

	private AbbonamentoController abbonamentoController;
	private AbbonamentoIFStub abbonamentoIFStub;

	@Before
    public void setUp() {
        abbonamentoIFStub = new AbbonamentoIFStub();
        
        // Creare oggetti User e Abbonamento se necessario

        abbonamentoController = new AbbonamentoController(/* utenteMock */, /* abbonamentoMock */, abbonamentoIFStub);
    }

	@Test
	public void testAbbonatiActionPerformed_PagamentoAvvenutoConSuccesso() {
		// Imposta il comportamento dell'utente (utenteMock) in modo che ritorni true
		// quando
		// si chiama il metodo isSignVip(username, codiceAbbonamento).
		when(utenteMock.isSignVip(anyString(), anyInt())).thenReturn(true);

		// Crea un evento fittizio per il pulsante di abbonamento
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Abbonati");

		// Esegui l'azione sull'ascoltatore "abbonati"
		abbonamentoController.new abbonati().actionPerformed(actionEvent);

		// Verifica che il messaggio sia stato correttamente impostato nella stub
		assertEquals("Sei diventato un Cliente Premium", abbonamentoIFStub.getDialogMessage());
	}

	private Object anyInt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testAbbonatiActionPerformed_PagamentoNonAvvenutoConSuccesso() {
		// Imposta il comportamento dell'utente (utenteMock) in modo che ritorni false
		// quando
		// si chiama il metodo isSignVip(username, codiceAbbonamento).
		when(utenteMock.isSignVip(anyString(), anyInt())).thenReturn(false);

		// Crea un evento fittizio per il pulsante di abbonamento
		ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "Abbonati");

		// Esegui l'azione sull'ascoltatore "abbonati"
		abbonamentoController.new abbonati().actionPerformed(actionEvent);

		// Verifica che il messaggio sia stato correttamente impostato nella stub
		assertEquals("Pagamento non avvenuto con successo!", abbonamentoIFStub.getDialogMessage());
	}

	// Classe stub per AbbonamentoIF
	private class AbbonamentoIFStub implements AbbonamentoIF {
		private String dialogMessage;

		public void showMessageDialog(Object message) {
			this.dialogMessage = message.toString();
		}

		public String getDialogMessage() {
			return dialogMessage;
		}
	}
}
