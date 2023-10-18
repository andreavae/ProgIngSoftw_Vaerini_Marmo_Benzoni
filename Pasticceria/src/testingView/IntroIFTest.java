package testingView;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
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
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked = true;
			}
		};
		introIF.openLogin(listener);

		JButton loginButton = introIF.getSigButton();
		loginButton.doClick(); // Simulate a click on the Login button

		assertTrue(buttonClicked);
	}

	@Test
	public void testOpenSign() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked = true;
			}
		};
		introIF.openSign(listener);

		JButton signButton = introIF.getSigButton();
		signButton.doClick(); // Simulate a click on the Sign Up button

		assertTrue(buttonClicked);
	}
}
