package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IngredientiIF extends JFrame {
	private JPanel contentPane;
	public JButton BackButton;

	public IngredientiIF() {
		// chiusura interfaccia
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 440); // grandezza finestra
		setLocationRelativeTo(null); // posizione della finsetra al centro
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		contentPane = new JPanel(); // per aggiungere componenti grafici
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 180, 180));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		BackButton = new JButton("Back"); // bottone back
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(30, 350, 89, 23);
		contentPane.add(BackButton);

		JLabel CheesecakeLabel = new JLabel(
				"CHEESECAKE:  Biscotti, Burro, Zucchero, Limone, Philadelphia, Panna, Gelatina");
		CheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		CheesecakeLabel.setBounds(20, 40, 700, 23);
		contentPane.add(CheesecakeLabel);

	}

}
