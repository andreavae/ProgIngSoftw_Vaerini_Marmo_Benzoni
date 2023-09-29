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
import javax.swing.border.LineBorder;

import model.Prodotto;
import model.User;

public class NuovoOrdineIF extends JFrame {

	private JPanel contentPane;
	private JButton addCheesecakeButton; // aggiungi cheesecake nel carrello
	private JButton addCubanaButton; // aggiungi cubana nel carrello
	private JButton VisualizzaOrdineButton;

	/**
	 * Create the frame.
	 */
	public NuovoOrdineIF(User utente) {
		Prodotto Cheesecake = new Prodotto("Cheesecake", "resources/cheesecake.jpg");
		Prodotto Cubana = new Prodotto("Cubana", "resources/cubana.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel CheesecakeImagepanel = new JPanel();
		CheesecakeImagepanel.setBounds(10, 89, 137, 92);
		contentPane.add(CheesecakeImagepanel);
		CheesecakeImagepanel.setLayout(new BorderLayout());
		String pathImmagine = Cheesecake.getPathImmagine();
		ImageIcon imageIcon = new ImageIcon(pathImmagine);
		JLabel CheesecakeImageLabel = new JLabel(imageIcon);
		CheesecakeImagepanel.add(CheesecakeImageLabel, BorderLayout.WEST);

		String nomeProdotto = Cheesecake.getNome(); // Assumiamo che ci sia un metodo getNome()

		addCheesecakeButton = new JButton("Add");
		addCheesecakeButton.setBackground(Color.YELLOW);
		addCheesecakeButton.setBorder(new LineBorder(Color.BLUE, 2));
		addCheesecakeButton.setBounds(29, 214, 80, 23);
		contentPane.add(addCheesecakeButton);

		JLabel CheesecakeLabel = new JLabel(nomeProdotto);
		CheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CheesecakeLabel.setBounds(40, 180, 80, 23);
		contentPane.add(CheesecakeLabel);

		JLabel CatalogoLabel = new JLabel("ORDINA");
		CatalogoLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
		CatalogoLabel.setBounds(221, 11, 161, 47);
		contentPane.add(CatalogoLabel);

		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(10, 11, 35, 14);
		contentPane.add(userLabel);

		JLabel UserINLabel = new JLabel(utente.getUsername());
		UserINLabel.setBounds(40, 11, 69, 14);
		contentPane.add(UserINLabel);

		JPanel CubanaImagepanel = new JPanel();
		CubanaImagepanel.setBounds(195, 89, 137, 92);
		contentPane.add(CubanaImagepanel);
		CubanaImagepanel.setLayout(new BorderLayout());
		String pathCubana = Cubana.getPathImmagine();
		ImageIcon imageiconcubana = new ImageIcon(pathCubana);
		JLabel CubanaImageLabel = new JLabel(imageiconcubana);
		CubanaImagepanel.add(CubanaImageLabel, BorderLayout.WEST);

		JLabel CubanaLabel = new JLabel("Cubana");
		CubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		CubanaLabel.setBounds(244, 184, 46, 14);
		contentPane.add(CubanaLabel);

		addCubanaButton = new JButton("Add");
		addCubanaButton.setBounds(221, 214, 80, 23);
		contentPane.add(addCubanaButton);

		VisualizzaOrdineButton = new JButton("Visualizza Ordine");
		VisualizzaOrdineButton.setBounds(406, 508, 168, 23);
		contentPane.add(VisualizzaOrdineButton);

		JLabel prezzoCheesecakeLabel = new JLabel("15,00 €");
		prezzoCheesecakeLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCheesecakeLabel.setBounds(50, 201, 46, 14);
		contentPane.add(prezzoCheesecakeLabel);

		JLabel prezzoCubanaLabel = new JLabel("12,00 €");
		prezzoCubanaLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 11));
		prezzoCubanaLabel.setBounds(244, 201, 46, 14);
		contentPane.add(prezzoCubanaLabel);

		setVisible(true);
	}

	public void addCheesecake(ActionListener listener) {
		addCheesecakeButton.addActionListener(listener);
	}

	public void addCubana(ActionListener listern) {
		addCubanaButton.addActionListener(listern);
	}

	public void visualizzaOrdine(ActionListener listener) {
		VisualizzaOrdineButton.addActionListener(listener);
	}

}
