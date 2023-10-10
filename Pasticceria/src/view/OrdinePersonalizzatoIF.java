package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;

public class OrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane; // variabili
	private JButton backButton;
	private JLabel UtenteLabel;
	private JLabel UtenteInLabel;
	private JLabel NpersoneLabel;
	private JLabel DataConsegnaLabel;
	private JTextField NumeroPersoneField;
	private JTextField DataConsegnaField;
	private JTextField DescrizioneOrdineField;
	private JButton VisualizzaOrdinePersonalizzatoButton;
	private JLabel OccasioneLabel;
	private JComboBox<String> PianiComboBox;
	private JComboBox<String> nPersoneComboBox;
	private JComboBox<String> OccasioneComboBox;
	private JLabel ScontoLabel;
	private JLabel ScontoSetLabel;

	/**
	 * Create the frame.
	 */
	public OrdinePersonalizzatoIF(User utente) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 508, 379);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		contentPane = new JPanel(); // per aggiungere componenti grafici
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 180, 180));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel personalizzaOrdineLabel = new JLabel("Personalizza il tuo ordine"); // etichetta
		personalizzaOrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		personalizzaOrdineLabel.setBounds(83, 23, 280, 50);
		contentPane.add(personalizzaOrdineLabel);

		backButton = new JButton("Back"); // bottone back
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(255, 80, 120));
		backButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		backButton.setBounds(10, 306, 89, 23);
		contentPane.add(backButton);

		UtenteLabel = new JLabel("User:"); // etichetta user
		UtenteLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UtenteLabel);

		UtenteInLabel = new JLabel(utente.getUsername()); // etichetta utente
		UtenteInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteInLabel.setBounds(45, 11, 81, 14);
		contentPane.add(UtenteInLabel);

		NpersoneLabel = new JLabel("Numero di Persone"); // etichetta num persone
		NpersoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		NpersoneLabel.setBounds(10, 71, 115, 23);
		contentPane.add(NpersoneLabel);

		DataConsegnaLabel = new JLabel("Data di Consegna"); // etichetta data consegna
		DataConsegnaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DataConsegnaLabel.setBounds(10, 166, 121, 23);
		contentPane.add(DataConsegnaLabel);

		DataConsegnaField = new JTextField(); // inserimento data
		DataConsegnaField.setBounds(131, 167, 86, 20);
		contentPane.add(DataConsegnaField);
		DataConsegnaField.setColumns(10);

		JLabel PianiLabel = new JLabel("Piani\r\n"); // etichetta piani
		PianiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		PianiLabel.setBounds(10, 105, 46, 14);
		contentPane.add(PianiLabel);

		String[] piani = { "1 (+00.00€)", "2 (+30.00€)", "3 (+50.00)" }; // scelta da 1 a 3 piani
		PianiComboBox = new JComboBox<String>(); // menu a tendina
		for (String piano : piani) { // inserimento valori nel menu
			PianiComboBox.addItem(piano);
		}
		PianiComboBox.setBounds(131, 101, 150, 22); // Imposta le dimensioni in modo appropriato
		contentPane.add(PianiComboBox);

		OccasioneLabel = new JLabel("Occasione"); // etichetta occasione
		OccasioneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OccasioneLabel.setBounds(10, 136, 81, 14);
		contentPane.add(OccasioneLabel);

		String[] occasioni = { "Nessuna occasione", "Compleanno", "Anniversario", "Laurea" }; // tipologia occcasione
		OccasioneComboBox = new JComboBox<String>(); // menu a tendina
		for (String occasione : occasioni) { // inserimento valori
			OccasioneComboBox.addItem(occasione);
		}
		OccasioneComboBox.setBounds(131, 134, 185, 23); // Imposta le dimensioni in modo appropriato
		contentPane.add(OccasioneComboBox);

		String[] nPersone = { "Da  5 a 10 persone (+00.00€)", "Da 10 a 15 persone (+10.00€)", // num persone per la
																								// torta
				"Da 15 a 25 persone (+30.00€)" };
		nPersoneComboBox = new JComboBox<String>(); // menu a tendina
		for (String persona : nPersone) { // inserimento valori
			nPersoneComboBox.addItem(persona);
		}
		nPersoneComboBox.setBounds(131, 71, 285, 23);
		contentPane.add(nPersoneComboBox);

		VisualizzaOrdinePersonalizzatoButton = new JButton("Visualizza Ordine"); // bottone visualizza ordine
		VisualizzaOrdinePersonalizzatoButton.setForeground(new Color(255, 255, 255));
		VisualizzaOrdinePersonalizzatoButton.setBackground(new Color(255, 80, 120));
		VisualizzaOrdinePersonalizzatoButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdinePersonalizzatoButton.setBounds(349, 306, 133, 23);
		contentPane.add(VisualizzaOrdinePersonalizzatoButton);

		ScontoLabel = new JLabel("Sconto:");
		ScontoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoLabel.setBounds(370, 11, 46, 14);
		contentPane.add(ScontoLabel);

		ScontoSetLabel = new JLabel("");
		ScontoSetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoSetLabel.setBounds(417, 11, 46, 14);
		contentPane.add(ScontoSetLabel);

	}

	// attivazione ascoltatori

	public void back(ActionListener listener) {
		backButton.addActionListener(listener);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdinePersonalizzatoButton.addActionListener(listener);
	}

	// cattura valore del menu a tendina
	public JComboBox<String> getPianiComboBox() {
		return PianiComboBox;
	}

	public JComboBox<String> getnPersoneComboBox() {
		return nPersoneComboBox;
	}

	public JComboBox<String> getOccasioneComboBox() {
		return OccasioneComboBox;
	}

	public JTextField getDataConsegnaField() {
		return DataConsegnaField;
	}

}
