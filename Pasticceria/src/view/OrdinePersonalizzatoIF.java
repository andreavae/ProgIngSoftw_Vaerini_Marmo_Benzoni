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

import model.User;

public class OrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	private JLabel UtenteLabel;
	private JLabel UtenteInLabel;
	private JTextField NumeroPersoneField;
	private JTextField DataConsegnaField;
	private JTextField DescrizioneOrdineField;
	private JButton VisualizzaOrdineButton;

	/**
	 * Create the frame.
	 */
	public OrdinePersonalizzatoIF(User utente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 344);
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
		backButton.setBounds(10, 271, 89, 23);
		contentPane.add(backButton);

		UtenteLabel = new JLabel("User:");
		UtenteLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UtenteLabel);

		UtenteInLabel = new JLabel(utente.getUsername());
		UtenteInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteInLabel.setBounds(45, 11, 81, 14);
		contentPane.add(UtenteInLabel);

		JLabel NumeroPersoneLabel = new JLabel("Numero di Persone");
		NumeroPersoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		NumeroPersoneLabel.setBounds(55, 84, 118, 23);
		contentPane.add(NumeroPersoneLabel);

		NumeroPersoneField = new JTextField();
		NumeroPersoneField.setBounds(194, 84, 86, 20);
		contentPane.add(NumeroPersoneField);
		NumeroPersoneField.setColumns(10);

		JLabel DataConsegnaLabel = new JLabel("Data di Consegna");
		DataConsegnaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DataConsegnaLabel.setBounds(53, 118, 120, 14);
		contentPane.add(DataConsegnaLabel);

		DataConsegnaField = new JTextField();
		DataConsegnaField.setText("");
		DataConsegnaField.setBounds(194, 115, 86, 20);
		contentPane.add(DataConsegnaField);
		DataConsegnaField.setColumns(10);

		JLabel DescrizioneOrdineLabel = new JLabel("Descrizione Ordine");
		DescrizioneOrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DescrizioneOrdineLabel.setBounds(55, 150, 118, 14);
		contentPane.add(DescrizioneOrdineLabel);

		DescrizioneOrdineField = new JTextField();
		DescrizioneOrdineField.setBounds(194, 147, 263, 99);
		contentPane.add(DescrizioneOrdineField);
		DescrizioneOrdineField.setColumns(10);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine");
		VisualizzaOrdineButton.setForeground(new Color(255, 255, 255));
		VisualizzaOrdineButton.setBackground(new Color(0, 128, 255));
		VisualizzaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdineButton.setBounds(346, 271, 135, 23);
		contentPane.add(VisualizzaOrdineButton);
	}

	public void back(ActionListener listener) {
		backButton.addActionListener(listener);
	}

	public void openVisualizzaOrdinePersonalizzatoIF(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

	public JTextField getNumeroPersoneField() {
		return NumeroPersoneField;
	}

	public JTextField getDataConsegnaField() {
		return DataConsegnaField;
	}

	public JTextField getDescrizioneOrdineField() {
		return DescrizioneOrdineField;
	}

}
