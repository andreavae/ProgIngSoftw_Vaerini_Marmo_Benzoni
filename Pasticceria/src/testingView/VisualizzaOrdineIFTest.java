package testingView;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import view.VisualizzaOrdineIF;

public class VisualizzaOrdineIFTest {

	private VisualizzaOrdineIF visualizzaOrdineFrame;

	@Before
	public void setUp() {
		visualizzaOrdineFrame = new VisualizzaOrdineIF(null, null, null, 0);
	}

	@Test
	public void testBackButton() {
		// Verifica che il pulsante "Back" sia abilitato
		assertTrue(visualizzaOrdineFrame.BackButton.isEnabled());
	}

	@Test
	public void testConfermaOrdineButton() {
		// Verifica che il pulsante "Conferma Ordine" sia abilitato
		assertTrue(visualizzaOrdineFrame.ConfermaOrdineButton.isEnabled());
	}

	@Test
	public void testCancellaButton() {
		// Verifica che il pulsante "Cancella" sia abilitato
		assertTrue(visualizzaOrdineFrame.CancellaButton.isEnabled());
	}
}
