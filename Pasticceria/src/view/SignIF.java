package view;

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
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		SignoContentPane = new JPanel();
		SignoContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(SignoContentPane);
		SignoContentPane.setLayout(null);

		JLabel registrazioneLabel = new JLabel("REGISTRAZIONE"); // etichetta registrazione
		registrazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registrazioneLabel.setBounds(146, 11, 171, 33);
		SignoContentPane.add(registrazioneLabel);

		SignUsernameField = new JTextField(); // creazione campo testo
		SignUsernameField.setBounds(231, 74, 86, 20);
		SignoContentPane.add(SignUsernameField);
		SignUsernameField.setColumns(10);

		JLabel signUsernameLabel = new JLabel("Username"); // creazione etichetta Username
		signUsernameLabel.setBounds(139, 77, 82, 14);
		SignoContentPane.add(signUsernameLabel);

		SignPasswordField = new JTextField(); // creazione campo testo
		SignPasswordField.setBounds(231, 105, 86, 20);
		SignoContentPane.add(SignPasswordField);
		SignPasswordField.setColumns(10);

		JLabel signPasswordLabel = new JLabel("Password"); // creazione etichetta password
		signPasswordLabel.setBounds(139, 108, 82, 14);
		SignoContentPane.add(signPasswordLabel);

		registratiButton = new JButton("Registrati"); // creazione bottone
		registratiButton.setBounds(172, 149, 89, 23);
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
