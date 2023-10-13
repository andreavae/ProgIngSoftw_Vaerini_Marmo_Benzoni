package testingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Test;

import model.User;
import view.OrdinePersonalizzatoIF;

public class OrdinePersonalizzatoIFTest {

	@Test
	public void testBackButton() {
		User utente = new User("user", "user");
		OrdinePersonalizzatoIF ordine = new OrdinePersonalizzatoIF(utente, 0);

		// Simula il clic sul bottone "Back"
		ActionListener[] listeners = ordine.backButton.getActionListeners();
		for (ActionListener listener : listeners) {
			listener.actionPerformed(new ActionEvent(ordine.backButton, ActionEvent.ACTION_PERFORMED, "Back"));
		}

		// Puoi verificare lo stato desiderato dell'interfaccia utente qui

	}
}
