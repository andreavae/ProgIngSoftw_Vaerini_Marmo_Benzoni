package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;

public class OrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	private JLabel UtenteLabel;
	private JLabel UtenteInLabel;
	private JLabel NpersoneLabel;
	private JLabel DataConsegnaLabel;
	private JTextField NumeroPersoneField;
	private JTextField DataConsegnaField;
	private JTextField DescrizioneOrdineField;
	private JButton VisualizzaOrdineButton;
	private JLabel OccasioneLabel;

	/**
	 * Create the frame.
	 */
	public OrdinePersonalizzatoIF(User utente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 379);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel personalizzaOrdineLabel = new JLabel("Personalizza il tuo ordine");
		personalizzaOrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		personalizzaOrdineLabel.setBounds(83, 23, 280, 50);
		contentPane.add(personalizzaOrdineLabel);

		backButton = new JButton("Back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 128, 192));
		backButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		backButton.setBounds(10, 306, 89, 23);
		contentPane.add(backButton);

		UtenteLabel = new JLabel("User:");
		UtenteLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UtenteLabel);

		UtenteInLabel = new JLabel(utente.getUsername());
		UtenteInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteInLabel.setBounds(45, 11, 81, 14);
		contentPane.add(UtenteInLabel);

		NpersoneLabel = new JLabel("Numero di Persone");
		NpersoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		NpersoneLabel.setBounds(10, 71, 115, 23);
		contentPane.add(NpersoneLabel);

		DataConsegnaLabel = new JLabel("Data di Consegna");
		DataConsegnaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DataConsegnaLabel.setBounds(10, 166, 121, 23);
		contentPane.add(DataConsegnaLabel);

		DataConsegnaField = new JTextField();
		DataConsegnaField.setBounds(131, 167, 86, 20);
		contentPane.add(DataConsegnaField);
		DataConsegnaField.setColumns(10);

		JLabel PianiLabel = new JLabel("Piani\r\n");
		PianiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		PianiLabel.setBounds(10, 105, 46, 14);
		contentPane.add(PianiLabel);

		String[] piani = { "1 (0,00€)", "2 (+30,00€)", "3 (+50,00)" };
		JComboBox<String> PianiComboBox = new JComboBox<String>();
		for (String piano : piani) {
			PianiComboBox.addItem(piano);
		}
		PianiComboBox.setBounds(131, 101, 150, 22); // Imposta le dimensioni in modo appropriato
		contentPane.add(PianiComboBox);
		PianiComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ottieni il valore selezionato dalla JComboBox
				String valoreSelezionato = (String) PianiComboBox.getSelectedItem();

				// Utilizza un'espressione regolare per cercare un numero intero
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(valoreSelezionato);

				if (matcher.find()) {
					String valoreNumerico = matcher.group();
					// Converti il valore in un numero intero
					try {
						int valoreIntero = Integer.parseInt(valoreNumerico);
						System.out.println("Piani scelti: " + valoreIntero);
					} catch (NumberFormatException ex) {
						System.out.println("Impossibile convertire il valore in un numero.");
					}
				} else {
					System.out.println("Valore numerico non trovato nella stringa selezionata.");
				}
			}
		});

		OccasioneLabel = new JLabel("Occasione");
		OccasioneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OccasioneLabel.setBounds(10, 136, 81, 14);
		contentPane.add(OccasioneLabel);

		String[] occasioni = { "Nessuna occasione", "Compleanno", "Anniversario", "Laurea" };
		JComboBox<String> OccasioneComboBox = new JComboBox<String>();
		for (String occasione : occasioni) {
			OccasioneComboBox.addItem(occasione);
		}
		OccasioneComboBox.setBounds(131, 134, 185, 23); // Imposta le dimensioni in modo appropriato
		contentPane.add(OccasioneComboBox);

		String[] nPersone = { "Da 5 a 10 persone (0,00€)", "Da 10 a 15 persone (+10,00€)",
				"Da 15 a 25 persone (+30,00€)" };
		JComboBox<String> nPersoneComboBox = new JComboBox<String>();
		for (String persona : nPersone) {
			nPersoneComboBox.addItem(persona);
		}
		nPersoneComboBox.setBounds(131, 71, 285, 23);
		contentPane.add(nPersoneComboBox);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine");
		VisualizzaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdineButton.setBounds(349, 306, 133, 23);
		contentPane.add(VisualizzaOrdineButton);

	}

	public void back(ActionListener listener) {
		backButton.addActionListener(listener);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

}
