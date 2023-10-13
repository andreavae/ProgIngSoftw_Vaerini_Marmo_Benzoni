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

public class OrdineStandardIF extends JFrame {

	private JPanel contentPane;
	public JButton addCheesecakeButton;
	public JButton addCubanaButton;
	private JButton addCreamtartButton;
	private JButton addIrisButton;
	private JButton addMimosaButton;
	private JButton addSaintButton;
	private JButton addSacherButton;
	private JButton addSetteveliButton;
	private JButton addTiramisuButton;
	private JButton VisualizzaOrdineButton;
	private JButton BackButton;

	/**
	 * Create the frame.
	 */
	public OrdineStandardIF(String string, double sconto) {
		// prodotti
		Prodotto Cheesecake = new Prodotto("Cheesecake", "resources/cheesecake.jpg", 15);
		Prodotto Cubana = new Prodotto("Cubana", "resources/cubana.jpg", 12);
		Prodotto Creamtart = new Prodotto("Cream Tart", "resources/Cream-tart.jpg", 20);
		Prodotto Iris = new Prodotto("Iris", "resources/Iris.jpg", 23);
		Prodotto Mimosa = new Prodotto("Mimosa", "resources/mimosa.jpg", 20);
		Prodotto SaintHonore = new Prodotto("Saint Honorè", "resources/Saint-honore.jpg", 25);
		Prodotto Sacher = new Prodotto("Sacher", "resources/Sacher.jpg", 18);
		Prodotto Setteveli = new Prodotto("Setteveli", "resources/Setteveli.jpg", 15);
		Prodotto Tiramisu = new Prodotto("Tiramis�", "resources/Tiramisu.jpg", 16);

		// chiusura interfaccia
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 710); // grandezza finestra
		setLocationRelativeTo(null); // posizione della finsetra al centro
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
		CheesecakeLabel.setBounds(48, 180, 80, 23);
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
		CubanaImagepanel.setBounds(380, 89, 137, 92);
		contentPane.add(CubanaImagepanel);
		CubanaImagepanel.setLayout(new BorderLayout());
		String pathCubana = Cubana.getPathImmagine();
		ImageIcon imageiconcubana = new ImageIcon(pathCubana);
		JLabel CubanaImageLabel = new JLabel(imageiconcubana);
		CubanaImagepanel.add(CubanaImageLabel, BorderLayout.WEST);

		JLabel CubanaLabel = new JLabel("Cubana"); // etichetta Cubana
		CubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CubanaLabel.setBounds(424, 184, 46, 14);
		contentPane.add(CubanaLabel);

		JLabel prezzoCubanaLabel = new JLabel("12,00 €"); // prezzo cubana
		prezzoCubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCubanaLabel.setBounds(430, 201, 46, 14);
		contentPane.add(prezzoCubanaLabel);

		addCubanaButton = new JButton("Add"); // bottone inserimento nel carrello
		addCubanaButton.setForeground(new Color(255, 255, 255));
		addCubanaButton.setBackground(new Color(255, 80, 120));
		addCubanaButton.setBounds(410, 220, 80, 23);
		contentPane.add(addCubanaButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel CreamtartImagepanel = new JPanel();
		CreamtartImagepanel.setBounds(195, 89, 137, 92); // 195, 89, 137, 92
		contentPane.add(CreamtartImagepanel);
		CreamtartImagepanel.setLayout(new BorderLayout());
		String pathCreamtart = Creamtart.getPathImmagine();
		ImageIcon imageiconcreamtart = new ImageIcon(pathCreamtart);
		JLabel CreamtartImageLabel = new JLabel(imageiconcreamtart);
		CreamtartImagepanel.add(CreamtartImageLabel, BorderLayout.WEST);

		JLabel CreamtartLabel = new JLabel("Cream Tart"); // etichetta crea tart
		CreamtartLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CreamtartLabel.setBounds(233, 184, 80, 15); // 244, 184, 46, 14
		contentPane.add(CreamtartLabel);

		JLabel prezzoCreamtartLabel = new JLabel("20,00 €"); // prezzo cream tart
		prezzoCreamtartLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCreamtartLabel.setBounds(244, 201, 46, 14); // 244, 201, 46, 14
		contentPane.add(prezzoCreamtartLabel);

		addCreamtartButton = new JButton("Add"); // bottone inserimento nel carrello
		addCreamtartButton.setForeground(new Color(255, 255, 255));
		addCreamtartButton.setBackground(new Color(255, 80, 120));
		addCreamtartButton.setBounds(221, 220, 80, 23); // 221, 220, 80, 23
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

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel MimosaImagepanel = new JPanel();
		MimosaImagepanel.setBounds(195, 260, 137, 92);
		contentPane.add(MimosaImagepanel);
		MimosaImagepanel.setLayout(new BorderLayout());
		String pathMimosa = Mimosa.getPathImmagine();
		ImageIcon imageiconMimosa = new ImageIcon(pathMimosa);
		JLabel MimosaImageLabel = new JLabel(imageiconMimosa);
		MimosaImagepanel.add(MimosaImageLabel, BorderLayout.WEST);

		JLabel MimosaLabel = new JLabel("Mimosa"); // nome torta
		MimosaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		MimosaLabel.setBounds(240, 350, 80, 26);
		contentPane.add(MimosaLabel);

		JLabel prezzoMimosaLabel = new JLabel("20,00 €"); // prezzo Mimosa
		prezzoMimosaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoMimosaLabel.setBounds(244, 373, 46, 14);
		contentPane.add(prezzoMimosaLabel);

		addMimosaButton = new JButton("Add"); // bottone inserimente nel carrello
		addMimosaButton.setForeground(new Color(255, 255, 255));
		addMimosaButton.setBackground(new Color(255, 80, 120));
		addMimosaButton.setBounds(221, 392, 80, 23);
		contentPane.add(addMimosaButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel SaintImagepanel = new JPanel();
		SaintImagepanel.setBounds(380, 260, 137, 92);
		contentPane.add(SaintImagepanel);
		SaintImagepanel.setLayout(new BorderLayout());
		String pathSaint = SaintHonore.getPathImmagine();
		ImageIcon imageiconSaint = new ImageIcon(pathSaint);
		JLabel SaintImageLabel = new JLabel(imageiconSaint);
		SaintImagepanel.add(SaintImageLabel, BorderLayout.WEST);

		JLabel SaintLabel = new JLabel("Saint Honorè"); // nome torta
		SaintLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		SaintLabel.setBounds(411, 350, 80, 26);
		contentPane.add(SaintLabel);

		JLabel prezzoSaintLabel = new JLabel("25,00 €"); // prezzo Honor�
		prezzoSaintLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoSaintLabel.setBounds(430, 373, 46, 14);
		contentPane.add(prezzoSaintLabel);

		addSaintButton = new JButton("Add"); // bottone inserimento nel carrello
		addSaintButton.setForeground(new Color(255, 255, 255));
		addSaintButton.setBackground(new Color(255, 80, 120));
		addSaintButton.setBounds(410, 392, 80, 23);
		contentPane.add(addSaintButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel SacherImagepanel = new JPanel();
		SacherImagepanel.setBounds(10, 431, 137, 92);
		contentPane.add(SacherImagepanel);
		SacherImagepanel.setLayout(new BorderLayout());
		String pathSacher = Sacher.getPathImmagine();
		ImageIcon imageiconSacher = new ImageIcon(pathSacher);
		JLabel SacherImageLabel = new JLabel(imageiconSacher);
		SacherImagepanel.add(SacherImageLabel, BorderLayout.WEST);

		JLabel SacherLabel = new JLabel("Sacher"); // nome torta
		SacherLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		SacherLabel.setBounds(58, 520, 80, 26);
		contentPane.add(SacherLabel);

		JLabel prezzoSacherLabel = new JLabel("18,00 €"); // prezzo Sacher
		prezzoSacherLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoSacherLabel.setBounds(60, 545, 46, 14);
		contentPane.add(prezzoSacherLabel);

		addSacherButton = new JButton("Add"); // bottone inserimente nel carrello
		addSacherButton.setForeground(new Color(255, 255, 255));
		addSacherButton.setBackground(new Color(255, 80, 120));
		addSacherButton.setBounds(36, 564, 80, 23);
		contentPane.add(addSacherButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel SetteveliImagepanel = new JPanel();
		SetteveliImagepanel.setBounds(195, 431, 137, 92);
		contentPane.add(SetteveliImagepanel);
		SetteveliImagepanel.setLayout(new BorderLayout());
		String pathSetteveli = Setteveli.getPathImmagine();
		ImageIcon imageiconSetteveli = new ImageIcon(pathSetteveli);
		JLabel SetteveliImageLabel = new JLabel(imageiconSetteveli);
		SetteveliImagepanel.add(SetteveliImageLabel, BorderLayout.WEST);

		JLabel SetteveliLabel = new JLabel("Setteveli"); // nome torta
		SetteveliLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		SetteveliLabel.setBounds(240, 520, 80, 26);
		contentPane.add(SetteveliLabel);

		JLabel prezzoSetteveliLabel = new JLabel("15,00 €"); // prezzo Mimosa
		prezzoSetteveliLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoSetteveliLabel.setBounds(244, 545, 46, 14);
		contentPane.add(prezzoSetteveliLabel);

		addSetteveliButton = new JButton("Add"); // bottone inserimente nel carrello
		addSetteveliButton.setForeground(new Color(255, 255, 255));
		addSetteveliButton.setBackground(new Color(255, 80, 120));
		addSetteveliButton.setBounds(221, 564, 80, 23);
		contentPane.add(addSetteveliButton);

		// creazione pannello per visualizzare l'immagine e inserirlo
		// nell'interfaccia utente
		JPanel TiramisuImagepanel = new JPanel();
		TiramisuImagepanel.setBounds(380, 431, 137, 92);
		contentPane.add(TiramisuImagepanel);
		TiramisuImagepanel.setLayout(new BorderLayout());
		String pathTiramisu = Tiramisu.getPathImmagine();
		ImageIcon imageiconTiramisu = new ImageIcon(pathTiramisu);
		JLabel TiramisuImageLabel = new JLabel(imageiconTiramisu);
		TiramisuImagepanel.add(TiramisuImageLabel, BorderLayout.WEST);

		JLabel TiramisuLabel = new JLabel("Tiramisu"); // nome torta
		TiramisuLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		TiramisuLabel.setBounds(421, 520, 80, 26);
		contentPane.add(TiramisuLabel);

		JLabel prezzoTiramisuLabel = new JLabel("16,00 €"); // prezzo Tiramisu
		prezzoTiramisuLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoTiramisuLabel.setBounds(430, 545, 46, 14);
		contentPane.add(prezzoTiramisuLabel);

		addTiramisuButton = new JButton("Add"); // bottone inserimento nel carrello
		addTiramisuButton.setForeground(new Color(255, 255, 255));
		addTiramisuButton.setBackground(new Color(255, 80, 120));
		addTiramisuButton.setBounds(410, 564, 80, 23);
		contentPane.add(addTiramisuButton);

		JLabel CatalogoLabel = new JLabel("ORDINA"); // etichetta ordina
		CatalogoLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
		CatalogoLabel.setBounds(221, 11, 161, 47);
		contentPane.add(CatalogoLabel);

		JLabel userLabel = new JLabel("User:"); // etichetta user
		userLabel.setBounds(10, 11, 35, 14);
		contentPane.add(userLabel);

		JLabel UserINLabel = new JLabel(" " + string.getUsername()); // etichetta nome utente
		UserINLabel.setBounds(40, 11, 69, 14);
		contentPane.add(UserINLabel);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine"); // bottone visualizza ordine
		VisualizzaOrdineButton.setForeground(new Color(255, 255, 255));
		VisualizzaOrdineButton.setBackground(new Color(255, 80, 120));
		VisualizzaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		VisualizzaOrdineButton.setBounds(340, 630, 168, 23); // 340
		contentPane.add(VisualizzaOrdineButton);

		BackButton = new JButton("Back"); // bottone back
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(20, 630, 89, 23);
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

	public void addMimosa(ActionListener listern) {
		addMimosaButton.addActionListener(listern);
	}

	public void addSaintHonore(ActionListener listern) {
		addSaintButton.addActionListener(listern);
	}

	public void addSacher(ActionListener listern) {
		addSacherButton.addActionListener(listern);
	}

	public void addSetteveli(ActionListener listern) {
		addSetteveliButton.addActionListener(listern);
	}

	public void addTiramisu(ActionListener listern) {
		addTiramisuButton.addActionListener(listern);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

}
