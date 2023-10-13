package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IntroIF extends JFrame {

	private JPanel IntroContentPane;
	private JButton LogButton;
	private JButton SigButton;

	/**
	 * Create the frame.
	 */
	public IntroIF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 272, 174);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		IntroContentPane = new JPanel(); // per aggiungere componenti grafici
		IntroContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(IntroContentPane);
		IntroContentPane.setLayout(null);
		IntroContentPane.setBackground(new Color(255, 180, 180));

		JLabel GetStartedLabel = new JLabel("Get Started"); // etichetta
		GetStartedLabel.setForeground(new Color(0, 0, 0));
		GetStartedLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		GetStartedLabel.setBounds(36, 0, 204, 83);
		IntroContentPane.add(GetStartedLabel);

		LogButton = new JButton("Login"); // bottone login
		LogButton.setForeground(new Color(255, 255, 255));
		LogButton.setBackground(new Color(255, 80, 120));
		LogButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		LogButton.setBounds(22, 78, 89, 43);
		IntroContentPane.add(LogButton);

		SigButton = new JButton("Sign Up"); // bottone sign
		SigButton.setForeground(new Color(255, 255, 255));
		SigButton.setBackground(new Color(255, 80, 120));
		SigButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		SigButton.setBounds(121, 78, 119, 43);
		IntroContentPane.add(SigButton);
	}

	// attivazione ascoltatori

	public void openLogin(ActionListener listener) {
		LogButton.addActionListener(listener);
	}

	public void openSign(ActionListener listener) {
		SigButton.addActionListener(listener);
	}

	public JButton getSigButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
