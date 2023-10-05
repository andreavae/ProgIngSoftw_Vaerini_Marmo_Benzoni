package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AbbonamentoIF extends JFrame {

	private JPanel DiventaPremiumContentPane;
	private JTextField UsernameTextField;
	private JTextField NumeroCartaTextField;
	private JTextField ScadenzaCartaTextField;
	private JButton AbbonatiButton;

	/**
	 * Create the frame.
	 */
	public AbbonamentoIF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		DiventaPremiumContentPane = new JPanel();
		DiventaPremiumContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(DiventaPremiumContentPane);
		DiventaPremiumContentPane.setLayout(null);

		JLabel DiventaPremiumLabel = new JLabel("Diventa un Cliente Premium");
		DiventaPremiumLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		DiventaPremiumLabel.setBounds(85, 23, 308, 49);
		DiventaPremiumContentPane.add(DiventaPremiumLabel);

		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UsernameLabel.setBounds(85, 83, 96, 24);
		DiventaPremiumContentPane.add(UsernameLabel);

		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(168, 83, 173, 20);
		DiventaPremiumContentPane.add(UsernameTextField);
		UsernameTextField.setColumns(10);

		JLabel CodCartaLabel = new JLabel("Numero Carta");
		CodCartaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		CodCartaLabel.setBounds(69, 132, 96, 14);
		DiventaPremiumContentPane.add(CodCartaLabel);

		NumeroCartaTextField = new JTextField();
		NumeroCartaTextField.setBounds(168, 129, 173, 20);
		DiventaPremiumContentPane.add(NumeroCartaTextField);
		NumeroCartaTextField.setColumns(10);

		JLabel ScadenzaCartaLabel = new JLabel("Scadenza Carta");
		ScadenzaCartaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScadenzaCartaLabel.setBounds(61, 174, 104, 14);
		DiventaPremiumContentPane.add(ScadenzaCartaLabel);

		ScadenzaCartaTextField = new JTextField();
		ScadenzaCartaTextField.setBounds(168, 171, 86, 20);
		DiventaPremiumContentPane.add(ScadenzaCartaTextField);
		ScadenzaCartaTextField.setColumns(10);

		AbbonatiButton = new JButton("Abbonati");
		AbbonatiButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		AbbonatiButton.setBounds(202, 212, 89, 23);
		DiventaPremiumContentPane.add(AbbonatiButton);
	}

	public void DiventaPremium(ActionListener listener) {
		AbbonatiButton.addActionListener(listener);
	}
}
