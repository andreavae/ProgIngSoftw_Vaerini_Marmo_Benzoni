package testingView;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.OrdineStandard;
import model.User;
import view.LoginIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineIFTest {
	private FrameFixture window;
	private LoginIF loginif;
	private User utente;
	private OrdineStandard ordinestandard;

	@Before
	public void setUp() {
		// Crea l'istanza di VisualizzaOrdineIF da testare
		loginif = new LoginIF();
		utente = new User("admin", "admin");
		ordinestandard = new OrdineStandard(utente, 0);
		VisualizzaOrdineIF visualizzaOrdineIF = new VisualizzaOrdineIF(loginif, utente, ordinestandard, 0);
		// Imposta la finestra di test su quella di VisualizzaOrdineIF
		window = new FrameFixture(visualizzaOrdineIF);
		window.show(); // Mostra la finestra
	}

	@After
	public void tearDown() {
		// Chiudi la finestra alla fine del test
		window.cleanUp();
	}

	@Test
	public void testBackButtonListener() {
		// Clicca sul pulsante "Back"
		JButtonFixture backButton = window.button("BackButton");
		backButton.click();

		// Aggiungi le verifiche necessarie qui
	}

	@Test
	public void testConfermaOrdineButtonListener() {
		// Clicca sul pulsante "Conferma Ordine"
		JButtonFixture confermaButton = window.button("ConfermaOrdineButton");
		confermaButton.click();

		// Aggiungi le verifiche necessarie qui
	}

	@Test
	public void testCancellaButtonListener() {
		// Clicca sul pulsante "Cancella"
		JButtonFixture cancellaButton = window.button("CancellaButton");
		cancellaButton.click();

		// Aggiungi le verifiche necessarie qui
	}
}
