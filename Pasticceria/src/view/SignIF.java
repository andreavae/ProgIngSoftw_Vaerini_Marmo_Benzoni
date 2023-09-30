package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIF extends JFrame {

	private JPanel SignoContentPane; // dichiarazione variabili
	private JTextField SignUsernameField;
	private JTextField SignPasswordField;
	private JButton registratiButton;

	/**
	 * Create the frame.
	 */
	public SignIF() { // interfaccia Sign //costruttore per l'aspetto grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 304, 227);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		SignoContentPane = new JPanel();
		SignoContentPane.setBackground(new Color(0, 0, 0));
		SignoContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(SignoContentPane);
		SignoContentPane.setLayout(null);

		JLabel registrazioneLabel = new JLabel("Crea il tuo account"); // etichetta registrazione
		registrazioneLabel.setForeground(new Color(255, 255, 255));
		registrazioneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		registrazioneLabel.setBounds(53, 23, 208, 40);
		SignoContentPane.add(registrazioneLabel);

		SignUsernameField = new JTextField(); // creazione campo testo
		SignUsernameField.setBounds(135, 71, 86, 20);
		SignoContentPane.add(SignUsernameField);
		SignUsernameField.setColumns(10);

		JLabel signUsernameLabel = new JLabel("Username"); // creazione etichetta Username
		signUsernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		signUsernameLabel.setForeground(new Color(255, 255, 255));
		signUsernameLabel.setBounds(53, 74, 82, 14);
		SignoContentPane.add(signUsernameLabel);

		SignPasswordField = new JTextField(); // creazione campo testo
		SignPasswordField.setBounds(135, 96, 86, 20);
		SignoContentPane.add(SignPasswordField);
		SignPasswordField.setColumns(10);

		JLabel signPasswordLabel = new JLabel("Password"); // creazione etichetta password
		signPasswordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		signPasswordLabel.setForeground(new Color(255, 255, 255));
		signPasswordLabel.setBounds(53, 99, 82, 14);
		SignoContentPane.add(signPasswordLabel);

		registratiButton = new JButton("Registrati"); // creazione bottone
		registratiButton.setBackground(new Color(0, 0, 255));
		registratiButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		registratiButton.setForeground(new Color(255, 255, 255));
		registratiButton.setBounds(81, 124, 101, 53);
		SignoContentPane.add(registratiButton);

	}

	public JTextField getSignUsernameField() {
		return SignUsernameField;
	}

	public JTextField getSignPasswordField() {
		return SignPasswordField;
	}

	public void addResgistratiListener(ActionListener listener) { // associa ascoltatore
		registratiButton.addActionListener(listener);
	}
}
