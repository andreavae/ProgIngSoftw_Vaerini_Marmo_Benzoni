package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

public class OrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	private JLabel UtenteLabel;
	private JLabel UtenteInLabel;

	/**
	 * Create the frame.
	 */
	public OrdinePersonalizzatoIF(User utente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		backButton.setBounds(10, 227, 89, 23);
		contentPane.add(backButton);

		UtenteLabel = new JLabel("User:");
		UtenteLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UtenteLabel);

		UtenteInLabel = new JLabel(utente.getUsername());
		UtenteInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UtenteInLabel.setBounds(45, 11, 81, 14);
		contentPane.add(UtenteInLabel);
	}

	public void back(ActionListener listener) {
		backButton.addActionListener(listener);
	}

}
