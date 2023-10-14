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

public class AbbonamentoIF extends JFrame {

	public JPanel DiventaPremiumContentPane;
	public JTextField UsernameTextField;
	public JTextField NumeroCartaTextField;
	public JTextField ScadenzaCartaTextField;
	public JButton AbbonatiButton;

	/**
	 * Create the frame.
	 */
	public AbbonamentoIF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		DiventaPremiumContentPane = new JPanel();// per aggiungere componenti grafici
		DiventaPremiumContentPane.setBackground(new Color(255, 180, 180));
		DiventaPremiumContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(DiventaPremiumContentPane);
		DiventaPremiumContentPane.setLayout(null);

		JLabel DiventaPremiumLabel = new JLabel("Diventa un Cliente Premium"); // etichetta
		DiventaPremiumLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		DiventaPremiumLabel.setBounds(85, 23, 308, 49);
		DiventaPremiumContentPane.add(DiventaPremiumLabel);

		JLabel UsernameLabel = new JLabel("Username"); // etichetta
		UsernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UsernameLabel.setBounds(85, 83, 96, 24);
		DiventaPremiumContentPane.add(UsernameLabel);

		UsernameTextField = new JTextField(); // campo di testo
		UsernameTextField.setBounds(168, 83, 173, 20);
		DiventaPremiumContentPane.add(UsernameTextField);
		UsernameTextField.setColumns(10);

		JLabel CodCartaLabel = new JLabel("Numero Carta"); // etichetta
		CodCartaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		CodCartaLabel.setBounds(69, 132, 96, 14);
		DiventaPremiumContentPane.add(CodCartaLabel);

		NumeroCartaTextField = new JTextField(); // campo di testo
		NumeroCartaTextField.setBounds(168, 129, 173, 20);
		DiventaPremiumContentPane.add(NumeroCartaTextField);
		NumeroCartaTextField.setColumns(10);

		JLabel ScadenzaCartaLabel = new JLabel("Scadenza Carta"); // etichetta
		ScadenzaCartaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScadenzaCartaLabel.setBounds(61, 174, 104, 14);
		DiventaPremiumContentPane.add(ScadenzaCartaLabel);

		ScadenzaCartaTextField = new JTextField(); // campo di testo
		ScadenzaCartaTextField.setBounds(168, 171, 86, 20);
		DiventaPremiumContentPane.add(ScadenzaCartaTextField);
		ScadenzaCartaTextField.setColumns(10);

		AbbonatiButton = new JButton("Abbonati"); // bottone
		AbbonatiButton.setBackground(new Color(255, 80, 120));
		AbbonatiButton.setForeground(new Color(255, 255, 255));
		AbbonatiButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		AbbonatiButton.setBounds(202, 212, 89, 23);
		DiventaPremiumContentPane.add(AbbonatiButton);
	}

	// associa ascoltatore
	public void DiventaPremium(ActionListener listener) {
		AbbonatiButton.addActionListener(listener);
	}

	public String showMessageDialog(String string) {
		return string;

	}
}
