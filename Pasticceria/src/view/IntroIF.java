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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 174);
		setLocationRelativeTo(null);
		setResizable(false);
		IntroContentPane = new JPanel();
		IntroContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(IntroContentPane);
		IntroContentPane.setLayout(null);
		IntroContentPane.setBackground(Color.BLACK);

		JLabel GetStartedLabel = new JLabel("Get Started");
		GetStartedLabel.setForeground(new Color(255, 255, 255));
		GetStartedLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		GetStartedLabel.setBounds(48, 0, 204, 83);
		IntroContentPane.add(GetStartedLabel);

		LogButton = new JButton("Login");
		LogButton.setForeground(new Color(255, 255, 255));
		LogButton.setBackground(new Color(0, 0, 255));
		LogButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		LogButton.setBounds(22, 78, 89, 43);
		IntroContentPane.add(LogButton);

		SigButton = new JButton("Sign Up");
		SigButton.setForeground(new Color(255, 255, 255));
		SigButton.setBackground(new Color(0, 0, 255));
		SigButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		SigButton.setBounds(121, 78, 119, 43);
		IntroContentPane.add(SigButton);
	}

	public void openLogin(ActionListener listener) {
		LogButton.addActionListener(listener);
	}

	public void openSign(ActionListener listener) {
		SigButton.addActionListener(listener);
	}

}
