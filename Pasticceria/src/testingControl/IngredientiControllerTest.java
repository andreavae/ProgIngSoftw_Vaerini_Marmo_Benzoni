package testingControl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.IngredientiController;
import model.User;
import view.IngredientiIF;
import view.OrdineStandardIF;

public class IngredientiControllerTest {
	private IngredientiIF ingredientiif;
	private OrdineStandardIF ordinestandardif;
	private IngredientiController controller;

	@Before
	public void setUp() {
		ingredientiif = new IngredientiIF();
		User utente = new User("admin", "admin");
		ordinestandardif = new OrdineStandardIF(utente, 0);
		controller = new IngredientiController(ingredientiif, ordinestandardif);
	}

	@After
	public void tearDown() {
		ingredientiif.dispose();
		ordinestandardif.dispose();
		ingredientiif = null;
		ordinestandardif = null;
		controller = null;
	}

	@Test
	public void testBackButtonAction() {
		// Simuliamo un evento di azione sul pulsante "Back"
		ActionEvent mockEvent = Mockito.mock(ActionEvent.class);

		// Chiamiamo il metodo actionPerformed del listener "back"
		controller.new back().actionPerformed(mockEvent);

		// Verifichiamo che l'interfaccia "OrdineStandardIF" sia resa visibile
		assertTrue(ordinestandardif.isVisible());

		// Verifichiamo che l'interfaccia "IngredientiIF" sia stata chiusa
		assertFalse(ingredientiif.isDisplayable());
	}
}
