package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Prodotto;
import model.User;

public class OrdineStandardIF extends JFrame {

	private JPanel contentPane;
	private JButton addCheesecakeButton; // aggiungi cheesecake nel carrello
	private JButton addCubanaButton; // aggiungi cubana nel carrello
	private JButton VisualizzaOrdineButton;
	private JButton BackButton;

	/**
	 * Create the frame.
	 */
	public OrdineStandardIF(User utente) {
		// foto prodotti
		Prodotto Cheesecake = new Prodotto("Cheesecake", "resources/cheesecake.jpg");
		Prodotto Cubana = new Prodotto("Cubana", "resources/cubana.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		contentPane = new JPanel(); // per aggiungere componenti grafici
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 180, 180));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// creazione pannello per visualizzare l'immagine (cheesecake) e inserirlo
		// nell'interfaccia utente
		JPanel CheesecakeImagepanel = new JPanel();
		CheesecakeImagepanel.setBounds(10, 89, 137, 92);
		contentPane.add(CheesecakeImagepanel);
		CheesecakeImagepanel.setLayout(new BorderLayout());
		String pathImmagine = Cheesecake.getPathImmagine();
		ImageIcon imageIcon = new ImageIcon(pathImmagine);
		JLabel CheesecakeImageLabel = new JLabel(imageIcon);
		CheesecakeImagepanel.add(CheesecakeImageLabel, BorderLayout.WEST);

		String nomeProdotto = Cheesecake.getNome(); // Assumiamo che ci sia un metodo getNome()

		addCheesecakeButton = new JButton("Add"); // bottone per aggiungere al carrello
		// addCheesecakeButton.setBackground(Color.WHITE);
		// addCheesecakeButton.setBorder(new LineBorder(Color.BLUE, 2));
		addCheesecakeButton.setBounds(29, 214, 80, 23);
		contentPane.add(addCheesecakeButton);

		JLabel CheesecakeLabel = new JLabel(nomeProdotto);
		CheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CheesecakeLabel.setBounds(40, 180, 80, 23);
		contentPane.add(CheesecakeLabel);

		JLabel CatalogoLabel = new JLabel("ORDINA"); // etichetta ordina
		CatalogoLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
		CatalogoLabel.setBounds(221, 11, 161, 47);
		contentPane.add(CatalogoLabel);

		JLabel userLabel = new JLabel("User:"); // etichetta user
		userLabel.setBounds(10, 11, 35, 14);
		contentPane.add(userLabel);

		JLabel UserINLabel = new JLabel(utente.getUsername()); // etichetta nome utente
		UserINLabel.setBounds(40, 11, 69, 14);
		contentPane.add(UserINLabel);

		// creazione pannello per visualizzare l'immagine (Cubana) e inserirlo
		// nell'interfaccia utente
		JPanel CubanaImagepanel = new JPanel();
		CubanaImagepanel.setBounds(195, 89, 137, 92);
		contentPane.add(CubanaImagepanel);
		CubanaImagepanel.setLayout(new BorderLayout());
		String pathCubana = Cubana.getPathImmagine();
		ImageIcon imageiconcubana = new ImageIcon(pathCubana);
		JLabel CubanaImageLabel = new JLabel(imageiconcubana);
		CubanaImagepanel.add(CubanaImageLabel, BorderLayout.WEST);

		JLabel CubanaLabel = new JLabel("Cubana"); // etichetta Cubana
		CubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CubanaLabel.setBounds(244, 184, 46, 14);
		contentPane.add(CubanaLabel);

		addCubanaButton = new JButton("Add"); // bottone inserimente nel carrello
		addCubanaButton.setBounds(221, 214, 80, 23);
		contentPane.add(addCubanaButton);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine"); // bottone visualizza ordine
		VisualizzaOrdineButton.setForeground(new Color(255, 255, 255));
		VisualizzaOrdineButton.setBackground(new Color(255, 80, 120));
		VisualizzaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdineButton.setBounds(406, 508, 168, 23);
		contentPane.add(VisualizzaOrdineButton);

		JLabel prezzoCheesecakeLabel = new JLabel("15,00 €"); // prezzo cheesecake
		prezzoCheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCheesecakeLabel.setBounds(50, 201, 46, 14);
		contentPane.add(prezzoCheesecakeLabel);

		JLabel prezzoCubanaLabel = new JLabel("12,00 €"); // prezzo cubana
		prezzoCubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCubanaLabel.setBounds(244, 201, 46, 14);
		contentPane.add(prezzoCubanaLabel);

		BackButton = new JButton("Back"); // bottone back
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(20, 508, 89, 23);
		contentPane.add(BackButton);

		setVisible(true);
	}

	// attivazione ascoltatore

	public void addCheesecake(ActionListener listener) {
		addCheesecakeButton.addActionListener(listener);
	}

	public void addCubana(ActionListener listern) {
		addCubanaButton.addActionListener(listern);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

}
