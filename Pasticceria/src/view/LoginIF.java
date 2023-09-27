package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginIF extends JFrame {

	private JPanel LoginContentPane; // dichiarazione variabili
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton;
	private JButton signButton;

	/**
	 * Create the frame.
	 */
	public LoginIF() { // interfaccia Login //costruttore per l'aspetto grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		LoginContentPane = new JPanel();
		LoginContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LoginContentPane);
		LoginContentPane.setLayout(null);

		usernameField = new JTextField(); // campo inserimemto username
		usernameField.setBounds(235, 91, 86, 20);
		LoginContentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JTextField(); // campo inserimento password
		passwordField.setBounds(235, 132, 86, 20);
		LoginContentPane.add(passwordField);
		passwordField.setColumns(10);

		JLabel usernameLabel = new JLabel("Username"); // etichetta username
		usernameLabel.setBounds(157, 94, 68, 14);
		LoginContentPane.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password"); // etichetta password
		passwordLabel.setBounds(157, 135, 68, 14);
		LoginContentPane.add(passwordLabel);

		JLabel loginLabel = new JLabel("LOGIN"); // etichetta login
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginLabel.setBounds(201, 34, 96, 40);
		LoginContentPane.add(loginLabel);

		loginButton = new JButton("Login"); // bottone login
		loginButton.setBounds(156, 175, 68, 23);
		LoginContentPane.add(loginButton);

		signButton = new JButton("Sign"); // bottone sign
		signButton.setBounds(252, 175, 68, 23);
		LoginContentPane.add(signButton);
	}

	public String getUsernameField() {
		return usernameField.getText();
	}

	public String getPasswordField() {
		return passwordField.getText();
	}

	public void addLoginListener(ActionListener listener) { // associa ascoltatore
		loginButton.addActionListener(listener);
	}

	public void openSignIF(ActionListener listener) { // associa ascoltatore
		signButton.addActionListener(listener);
	}

}
