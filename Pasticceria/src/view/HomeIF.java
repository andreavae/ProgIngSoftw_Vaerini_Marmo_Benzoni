package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeIF extends JFrame {

	private JPanel HomeContentPane;
	private JButton prodottiButton;
	private JButton visualizzaOrdineButton;
	private JButton newOrdineButton;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MenuIF frame = new MenuIF();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */
	/**
	 * Create the frame.
	 */
	public HomeIF(String utente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		HomeContentPane = new JPanel();
		HomeContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(HomeContentPane);
		HomeContentPane.setLayout(null);

		JLabel homeLabel = new JLabel("HOME ");
		homeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		homeLabel.setBounds(182, 11, 114, 48);
		HomeContentPane.add(homeLabel);

		JLabel utenteLabel = new JLabel("Utente: ");
		utenteLabel.setBounds(10, 11, 46, 14);
		HomeContentPane.add(utenteLabel);

		JLabel adminLabel = new JLabel(utente);
		adminLabel.setBounds(55, 11, 65, 14);
		HomeContentPane.add(adminLabel);

		prodottiButton = new JButton("Visualizza Prodotti");
		prodottiButton.setBounds(129, 54, 176, 23);
		HomeContentPane.add(prodottiButton);

		visualizzaOrdineButton = new JButton("Visualizza Ordine");
		visualizzaOrdineButton.setBounds(129, 126, 176, 23);
		HomeContentPane.add(visualizzaOrdineButton);

		newOrdineButton = new JButton("Nuovo Ordine");
		newOrdineButton.setBounds(129, 88, 176, 23);
		HomeContentPane.add(newOrdineButton);
	}
}
