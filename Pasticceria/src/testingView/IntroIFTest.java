package testingView;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import view.IntroIF;

public class IntroIFTest {
	private IntroIF introIF;
	private boolean buttonClicked;

	@Before
	public void setUp() {
		introIF = new IntroIF();
		buttonClicked = false;
	}

	@Test
	public void testOpenLogin() {
		ActionListener listener = e -> buttonClicked = true;
		introIF.openLogin(listener);

		Point button = introIF.getLocation();
		// ((AbstractButton) button).doClick(); // Simula un click sul pulsante Login

		assertTrue(buttonClicked);
	}

	@Test
	public void testOpenSign() {
		ActionListener listener = e -> buttonClicked = true;
		introIF.openSign(listener);

		JButton button = introIF.getSigButton();
		button.doClick(); // Simula un click sul pulsante Sign Up

		assertTrue(buttonClicked);
	}
}
