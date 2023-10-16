package testingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.IngredientiIF;

public class IngredientiIFTest {
	private IngredientiIF ingredientiIF;

	@Before
	public void setUp() {
		ingredientiIF = new IngredientiIF();
	}

	@After
	public void tearDown() {
		ingredientiIF = null;
	}

	@Test
	public void testBackButtonActionListener() {
		// Creiamo un oggetto fittizio di ActionListener per il test
		ActionListener mockListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};

		// Aggiungiamo il listener fittizio al pulsante
		ingredientiIF.back(mockListener);

		// Verifichiamo che il listener sia stato impostato correttamente

	}
}
