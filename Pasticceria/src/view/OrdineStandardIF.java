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
	private JButton addCheesecakeButton;
	private JButton addCubanaButton;
	private JButton addCreamtartButton;
	private JButton addIrisButton;
	private JButton VisualizzaOrdineButton;
	private JButton BackButton;

	/**
	 * Create the frame.
	 */
	public OrdineStandardIF(User utente, double sconto) {
		// prodotti
		Prodotto Cheesecake = new Prodotto("Cheesecake", "resources/cheesecake.jpg");
		Prodotto Cubana = new Prodotto("Cubana", "resources/cubana.jpg");
		Prodotto Creamtart = new Prodotto("Cream Tart", "resources/Cream-tart.jpg");
		Prodotto Iris = new Prodotto("Iris", "resources/Iris.jpg");

		// chiusura interfaccia
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JLabel CheesecakeLabel = new JLabel("Cheesecake");
		CheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CheesecakeLabel.setBounds(52, 180, 80, 23);
		contentPane.add(CheesecakeLabel);

		JLabel prezzoCheesecakeLabel = new JLabel("15,00 €"); // prezzo cheesecake
		prezzoCheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCheesecakeLabel.setBounds(60, 201, 46, 14);
		contentPane.add(prezzoCheesecakeLabel);

		addCheesecakeButton = new JButton("Add"); // bottone per aggiungere al carrello
		addCheesecakeButton.setForeground(new Color(255, 255, 255));
		addCheesecakeButton.setBackground(new Color(255, 80, 120));
		// addCheesecakeButton.setBorder(new LineBorder(Color.BLUE, 2));
		addCheesecakeButton.setBounds(36, 220, 80, 23);
		contentPane.add(addCheesecakeButton);

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

		JLabel prezzoCubanaLabel = new JLabel("12,00 €"); // prezzo cubana
		prezzoCubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCubanaLabel.setBounds(244, 201, 46, 14);
		contentPane.add(prezzoCubanaLabel);

		addCubanaButton = new JButton("Add"); // bottone inserimento nel carrello
		addCubanaButton.setForeground(new Color(255, 255, 255));
		addCubanaButton.setBackground(new Color(255, 80, 120));
		addCubanaButton.setBounds(221, 220, 80, 23);
		contentPane.add(addCubanaButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel CreamtartImagepanel = new JPanel();
		CreamtartImagepanel.setBounds(380, 89, 137, 92);
		contentPane.add(CreamtartImagepanel);
		CreamtartImagepanel.setLayout(new BorderLayout());
		String pathCreamtart = Creamtart.getPathImmagine();
		ImageIcon imageiconcreamtart = new ImageIcon(pathCreamtart);
		JLabel CreamtartImageLabel = new JLabel(imageiconcreamtart);
		CreamtartImagepanel.add(CreamtartImageLabel, BorderLayout.WEST);

		JLabel CreamtartLabel = new JLabel("Cream Tart"); // etichetta Iris
		CreamtartLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CreamtartLabel.setBounds(417, 184, 80, 15); // 80 23
		contentPane.add(CreamtartLabel);

		JLabel prezzoCreamtartLabel = new JLabel("20,00 €"); // prezzo Iris
		prezzoCreamtartLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCreamtartLabel.setBounds(427, 201, 46, 14);
		contentPane.add(prezzoCreamtartLabel);

		addCreamtartButton = new JButton("Add"); // bottone inserimento nel carrello
		addCreamtartButton.setForeground(new Color(255, 255, 255));
		addCreamtartButton.setBackground(new Color(255, 80, 120));
		addCreamtartButton.setBounds(410, 220, 80, 23);
		contentPane.add(addCreamtartButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel IrisImagepanel = new JPanel();
		IrisImagepanel.setBounds(10, 260, 137, 92);
		contentPane.add(IrisImagepanel);
		IrisImagepanel.setLayout(new BorderLayout());
		String pathIris = Iris.getPathImmagine();
		ImageIcon imageiconIris = new ImageIcon(pathIris);
		JLabel IrisImageLabel = new JLabel(imageiconIris);
		IrisImagepanel.add(IrisImageLabel, BorderLayout.WEST);

		JLabel IrisLabel = new JLabel("Iris"); // nome torta
		IrisLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		IrisLabel.setBounds(68, 350, 40, 26);
		contentPane.add(IrisLabel);

		JLabel prezzoIrisLabel = new JLabel("23,00 €"); // prezzo Iris
		prezzoIrisLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoIrisLabel.setBounds(60, 373, 46, 14);
		contentPane.add(prezzoIrisLabel);

		addIrisButton = new JButton("Add"); // bottone inserimente nel carrello
		addIrisButton.setForeground(new Color(255, 255, 255));
		addIrisButton.setBackground(new Color(255, 80, 120));
		addIrisButton.setBounds(36, 392, 80, 23);
		contentPane.add(addIrisButton);

		JLabel CatalogoLabel = new JLabel("ORDINA"); // etichetta ordina
		CatalogoLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
		CatalogoLabel.setBounds(221, 11, 161, 47);
		contentPane.add(CatalogoLabel);

		JLabel userLabel = new JLabel("User:"); // etichetta user
		userLabel.setBounds(10, 11, 35, 14);
		contentPane.add(userLabel);

		JLabel UserINLabel = new JLabel(" " + utente.getUsername()); // etichetta nome utente
		UserINLabel.setBounds(40, 11, 69, 14);
		contentPane.add(UserINLabel);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine"); // bottone visualizza ordine
		VisualizzaOrdineButton.setForeground(new Color(255, 255, 255));
		VisualizzaOrdineButton.setBackground(new Color(255, 80, 120));
		VisualizzaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdineButton.setBounds(406, 508, 168, 23);
		contentPane.add(VisualizzaOrdineButton);

		BackButton = new JButton("Back"); // bottone back
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(20, 508, 89, 23);
		contentPane.add(BackButton);

		JLabel ScontoLabel = new JLabel("Sconto: " + sconto * 100 + "%");
		ScontoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoLabel.setBounds(435, 11, 117, 14);
		contentPane.add(ScontoLabel);

		setVisible(true);
	}

	// attivazione ascoltatore

	public void addCheesecake(ActionListener listener) {
		addCheesecakeButton.addActionListener(listener);
	}

	public void addCubana(ActionListener listern) {
		addCubanaButton.addActionListener(listern);
	}

	public void addCreamtart(ActionListener listern) {
		addCreamtartButton.addActionListener(listern);
	}

	public void addIris(ActionListener listern) {
		addIrisButton.addActionListener(listern);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

}
