package testingView;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import model.User;
import view.HomeIF;
import view.LoginIF;

public class HomeIFTest {
	private HomeIF homeIF;
	private boolean buttonClicked;

	@Before
	public void setUp() {
		homeIF = new HomeIF(new User("user", "user"), new LoginIF(), 0.1);
		buttonClicked = false;
	}

	@Test
	public void testOpenNuovoOrdineIF() {
		ActionListener listener = e -> buttonClicked = true;
		homeIF.openNuovoOrdineIF(listener);

		JButton button = homeIF.getOrdineStandardButton();
		button.doClick(); // Simula un click sul pulsante

		assertTrue(buttonClicked);
	}

	@Test
	public void testOpenOrdinePersonalizzato() {
		ActionListener listener = e -> buttonClicked = true;
		homeIF.openOrdinePersonalizzato(listener);

		JButton button = homeIF.getOrdinePersonalizzatoButton();
		button.doClick(); // Simula un click sul pulsante

		assertTrue(buttonClicked);
	}

	@Test
	public void testQuit() {
		ActionListener listener = e -> buttonClicked = true;
		homeIF.quit(listener);

		JButton button = homeIF.getQuitButton();
		// button.doClick(); // Simula un click sul pulsante

		assertTrue(buttonClicked);
	}

	@Test
	public void testOpenSconto() {
		ActionListener listener = e -> buttonClicked = true;
		homeIF.openSconto(listener);

		JButton button = homeIF.getQuitButton();
		button.setEnabled(true); // Abilita il pulsante sconto
		button.doClick(); // Simula un click sul pulsante

		assertTrue(buttonClicked);

		button.setEnabled(false); // Disabilita il pulsante sconto
		button.doClick(); // Simula un click sul pulsante

		assertFalse(buttonClicked);
	}

	@Test
	public void testOpenAbbonamento() {
		ActionListener listener = e -> buttonClicked = true;
		homeIF.openAbbonamento(listener);

		JButton button = homeIF.getQuitButton();
		button.setEnabled(true); // Abilita il pulsante abbonamento
		button.doClick(); // Simula un click sul pulsante

		assertTrue(buttonClicked);

		button.setEnabled(false); // Disabilita il pulsante abbonamento
		button.doClick(); // Simula un click sul pulsante

		assertFalse(buttonClicked);
	}
}
