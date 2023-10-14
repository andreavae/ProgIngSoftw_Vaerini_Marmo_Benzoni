package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

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

		// inserimento ingredinti torte
		JLabel CheesecakeLabel = new JLabel(
				"CHEESECAKE:  Biscotti, Burro, Zucchero, Limone, Philadelphia, Panna, Gelatina");
		CheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		CheesecakeLabel.setBounds(20, 40, 700, 23);
		contentPane.add(CheesecakeLabel);

		JLabel CubanaLabel = new JLabel(
				"CUBANA:  Uova, Burro, Zucchero, Latte, Mandorle, Uvetta, Noci, Farina, Arancia");
		CubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		CubanaLabel.setBounds(20, 70, 700, 23);
		contentPane.add(CubanaLabel);

		JLabel CreamtartLabel = new JLabel("CREAM TART:  Farina, Burro, Uova, Zucchero, Panna, Mascarpone, Vaniglia");
		CreamtartLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		CreamtartLabel.setBounds(20, 100, 700, 23);
		contentPane.add(CreamtartLabel);

		JLabel IrisLabel = new JLabel(
				"IRIS:  Latte, Farina, Zuccero, Uova, Burro, Ricotta di pecora, Gocce di cioccolato");
		IrisLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		IrisLabel.setBounds(20, 130, 700, 23);
		contentPane.add(IrisLabel);

		JLabel MimosaLabel = new JLabel(
				"MIMOSA:  Farina, Zucchero, Fecola di patate, Uova, Vaniglia, Panna, Latte, Grand Marnier");
		MimosaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		MimosaLabel.setBounds(20, 160, 700, 23);
		contentPane.add(MimosaLabel);

		JLabel SaintLabel = new JLabel(
				"SAINT HONORÈ:  Uova, Farina, Zucchero, Fecola di patate, Panna, Latte, Cioccolato fondente, Gelatina, Vaniglia");
		SaintLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		SaintLabel.setBounds(20, 190, 900, 23);
		contentPane.add(SaintLabel);

		JLabel SacherLabel = new JLabel(
				"SACHER:  Uova, Cioccolato, Burro, Farina, Panna, Zucchero, Vaniglia, Confettura di albicocche");
		SacherLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		SacherLabel.setBounds(20, 220, 900, 23);
		contentPane.add(SacherLabel);

		JLabel SetteveliLabel = new JLabel(
				"SETTEVELI:  Farina, Panna, Latte, Zucchero, Cioccolato, Uova, Gelatina, Nocciole, Cereali corn flakes");
		SetteveliLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		SetteveliLabel.setBounds(20, 250, 900, 23);
		contentPane.add(SetteveliLabel);

		JLabel TiramisuLabel = new JLabel("TIRAMUSÙ:  Farina, Zucchero, Uova, Mascarpone, Caffè, Cacao");
		TiramisuLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 14));
		TiramisuLabel.setBounds(20, 280, 900, 23);
		contentPane.add(TiramisuLabel);
	}

	// attivazione ascoltatore
	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

}
