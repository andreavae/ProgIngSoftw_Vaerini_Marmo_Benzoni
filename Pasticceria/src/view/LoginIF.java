package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginIF extends JFrame {

	private JPanel LoginContentPane; // dichiarazione variabili
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton;
	private JRadioButton ClientePremiumRadioButton;
	private JButton BackButton;

	/**
	 * Create the frame.
	 */
	public LoginIF() { // interfaccia Login //costruttore per l'aspetto grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 334, 225);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		LoginContentPane = new JPanel(); // per aggiungere componenti grafici
		LoginContentPane.setBackground(new Color(255, 180, 180));
		LoginContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LoginContentPane);
		LoginContentPane.setLayout(null);

		usernameField = new JTextField(); // campo inserimemto username
		usernameField.setBounds(115, 62, 86, 20);
		LoginContentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JTextField(); // campo inserimento password
		passwordField.setBounds(115, 97, 86, 20);
		LoginContentPane.add(passwordField);
		passwordField.setColumns(10);

		JLabel usernameLabel = new JLabel("Username"); // etichetta username
		usernameLabel.setForeground(new Color(0, 0, 0));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		usernameLabel.setBounds(26, 65, 68, 14);
		LoginContentPane.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password"); // etichetta password
		passwordLabel.setForeground(new Color(0, 0, 0));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		passwordLabel.setBounds(26, 100, 68, 14);
		LoginContentPane.add(passwordLabel);

		JLabel loginLabel = new JLabel("Welcome"); // etichetta login
		loginLabel.setForeground(new Color(0, 0, 0));
		loginLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		loginLabel.setBounds(71, 11, 96, 40);
		LoginContentPane.add(loginLabel);

		loginButton = new JButton("Login"); // bottone login
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		loginButton.setBackground(new Color(255, 80, 120));
		loginButton.setBounds(221, 75, 68, 31);
		LoginContentPane.add(loginButton);

		ClientePremiumRadioButton = new JRadioButton("Cliente Premium"); // selezione cliente premium
		ClientePremiumRadioButton.setBackground(new Color(255, 80, 120));
		ClientePremiumRadioButton.setForeground(new Color(255, 255, 255));
		ClientePremiumRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ClientePremiumRadioButton.setBounds(21, 137, 146, 23);
		LoginContentPane.add(ClientePremiumRadioButton);

		BackButton = new JButton("Back");
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(200, 137, 89, 23);
		LoginContentPane.add(BackButton);
	}

	// cattura testo inserito nei campi di testo

	public String getUsernameField() {
		return usernameField.getText();
	}

	public String getPasswordField() {
		return passwordField.getText();
	}

	public JRadioButton getClientePremiumRadioButton() {
		return ClientePremiumRadioButton;
	}

	public void addLoginListener(ActionListener listener) { // associa ascoltatore
		loginButton.addActionListener(listener);
	}

	public void addBackListener(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

	public void setUsernameFieldText(String string) {

	}

	public void setPasswordFieldText(String string) {
		// TODO Auto-generated method stub

	}

}
