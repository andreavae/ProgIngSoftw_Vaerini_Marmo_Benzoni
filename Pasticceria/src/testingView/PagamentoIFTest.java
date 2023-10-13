package testingView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import view.PagamentoIF;

public class PagamentoIFTest {
	private PagamentoIF pagamentoFrame;

	@Before
	public void setUp() {
		// Configura il frame per i test
		pagamentoFrame = new PagamentoIF();
	}

	@Test
	public void testNumeroCartaField() {
		// Verifica che il campo di testo del numero di carta sia vuoto inizialmente
		assertEquals("", pagamentoFrame.getNumeroCartaField().getText());

		// Imposta un valore nel campo di testo
		pagamentoFrame.getNumeroCartaField().setText("1234 5678 9012 3456");

		// Verifica che il campo di testo contenga il valore impostato
		assertEquals("1234 5678 9012 3456", pagamentoFrame.getNumeroCartaField().getText());
	}

	@Test
	public void testDataScadenzaField() {
		// Verifica che il campo di testo della data di scadenza sia vuoto inizialmente
		assertEquals("", pagamentoFrame.getDataScadenzaField().getText());

		// Imposta un valore nel campo di testo
		pagamentoFrame.getDataScadenzaField().setText("12/25");

		// Verifica che il campo di testo contenga il valore impostato
		assertEquals("12/25", pagamentoFrame.getDataScadenzaField().getText());
	}

	@Test
	public void testPagamentoButton() {
		JButton pagamentoButton = pagamentoFrame.PagamentoButton;

		// Verifica che il pulsante di pagamento sia abilitato
		assertTrue(pagamentoButton.isEnabled());

		// Simula un clic sul pulsante (metodo fittizio, poiché non è possibile simulare
		// un clic diretto in un test JUnit)
		pagamentoButton.doClick();

		// Verifica che il pulsante di pagamento sia ancora abilitato (senza azioni
		// specifiche)
		assertTrue(pagamentoButton.isEnabled());
	}

	@Test
	public void testFrameComponents() {
		PagamentoIF pagamentoFrame = new PagamentoIF();

		// Verifica che i componenti desiderati siano presenti
		assertNotNull(pagamentoFrame.getNumeroCartaField());
		assertNotNull(pagamentoFrame.getDataScadenzaField());
		assertNotNull(pagamentoFrame.PagamentoButton);
	}

}
