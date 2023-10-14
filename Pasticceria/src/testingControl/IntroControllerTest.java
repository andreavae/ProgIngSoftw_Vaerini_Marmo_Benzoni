package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import control.IntroController;
import view.IntroIF;

public class IntroControllerTest {
	private IntroIF introif;
	private IntroController introController;

	@Before
	public void setUp() {
		// Inizializzazione dei componenti necessari per i test
		introif = new IntroIF();
		introController = new IntroController(introif);
	}

	@Test
	public void testOpenLoginActionPerformed() {
		// Test del listener openLogin
		IntroController.openLogin listener = introController.new openLogin();
		ActionEvent event = new ActionEvent(introif, ActionEvent.ACTION_PERFORMED, "OpenLogin");

		assertFalse(introController.isButtonClick()); // Assicurati che buttonClick sia inizialmente false
		listener.actionPerformed(event); // Simula un evento di clic
		assertTrue(introController.isButtonClick()); // Assicurati che buttonClick sia true dopo il clic
	}

	@Test
	public void testOpenSignActionPerformed() {
		// Test del listener openSign
		IntroController.openSign listener = introController.new openSign();
		ActionEvent event = new ActionEvent(introif, ActionEvent.ACTION_PERFORMED, "OpenSign");

		// Assicurati che buttonClick sia inizialmente false
		assertFalse(introController.isButtonClick());
		listener.actionPerformed(event); // Simula un evento di clic
		assertFalse(introController.isButtonClick()); // Assicurati che buttonClick rimanga false
	}
}
