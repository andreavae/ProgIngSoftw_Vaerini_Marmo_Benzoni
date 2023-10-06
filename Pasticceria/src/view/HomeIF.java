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

public class HomeIF extends JFrame {

	private JPanel HomeContentPane;
	private JButton OrdineStandardButton;
	private JButton OrdinePersonalizzatoButton;
	private JButton QuitButton;
	private JButton ScontoButton;
	private JLabel ScontoLabel;
	private JButton AbbonatiButton;

	/**
	 * Create the frame.
	 */
	public HomeIF(User utente, LoginIF loginif, double sconto) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		HomeContentPane = new JPanel(); // per aggiungere componenti grafici
		HomeContentPane.setBackground(new Color(255, 180, 180));
		HomeContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(HomeContentPane);
		HomeContentPane.setLayout(null);

		JLabel HomeLabel = new JLabel("HOME"); // etichetta Home
		HomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		HomeLabel.setBounds(151, 21, 79, 39);
		HomeContentPane.add(HomeLabel);

		JLabel UserLabel = new JLabel("User: "); // etichetta user
		UserLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserLabel.setBounds(10, 11, 41, 14);
		HomeContentPane.add(UserLabel);

		JLabel UserInLabel = new JLabel(utente.getUsername()); // etichetta utente
		UserInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserInLabel.setBounds(46, 11, 72, 14);
		HomeContentPane.add(UserInLabel);

		OrdineStandardButton = new JButton("Ordine Standard"); // bottone oridine standard
		OrdineStandardButton.setForeground(new Color(255, 255, 255));
		OrdineStandardButton.setBackground(new Color(255, 80, 120));
		OrdineStandardButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OrdineStandardButton.setBounds(102, 71, 183, 23);
		HomeContentPane.add(OrdineStandardButton);

		OrdinePersonalizzatoButton = new JButton("Ordine Personalizzato"); // bottone ordine personalizzato
		OrdinePersonalizzatoButton.setForeground(new Color(255, 255, 255));
		OrdinePersonalizzatoButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OrdinePersonalizzatoButton.setBackground(new Color(255, 80, 120));
		OrdinePersonalizzatoButton.setBounds(102, 105, 183, 23);
		HomeContentPane.add(OrdinePersonalizzatoButton);

		QuitButton = new JButton("Quit"); // bottone quit
		QuitButton.setForeground(new Color(255, 255, 255));
		QuitButton.setBackground(new Color(255, 80, 120));
		QuitButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		QuitButton.setBounds(360, 227, 64, 23);
		HomeContentPane.add(QuitButton);

		ScontoButton = new JButton("Ottieni Sconto Giornaliero"); // bottone sconto
		ScontoButton.setForeground(new Color(255, 255, 255));
		ScontoButton.setBackground(new Color(255, 80, 120));
		ScontoButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		if (loginif.getClientePremiumRadioButton().isSelected()) {
			ScontoButton.setEnabled(true);
		} else {
			ScontoButton.setEnabled(false);
		}
		ScontoButton.setBounds(102, 139, 183, 23);
		HomeContentPane.add(ScontoButton);

		ScontoLabel = new JLabel("Sconto:" + sconto * 100 + "%");
		ScontoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoLabel.setBounds(311, 11, 113, 14);
		HomeContentPane.add(ScontoLabel);

		AbbonatiButton = new JButton("Diventa Cliente Premium"); // bottone cliente premium
		AbbonatiButton.setForeground(new Color(255, 255, 255));
		AbbonatiButton.setBackground(new Color(255, 80, 120));
		AbbonatiButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		AbbonatiButton.setBounds(102, 173, 183, 23);
		HomeContentPane.add(AbbonatiButton);
		if (loginif.getClientePremiumRadioButton().isSelected() || utente.isVipLoginValid()) {
			AbbonatiButton.setEnabled(false);
		} else {
			AbbonatiButton.setEnabled(true);
		}
	}

	// attivazione ascoltatori

	public void openNuovoOrdineIF(ActionListener listener) {
		OrdineStandardButton.addActionListener(listener);
	}

	public void openOrdinePersonalizzato(ActionListener listener) {
		OrdinePersonalizzatoButton.addActionListener(listener);
	}

	public void quit(ActionListener listener) {
		QuitButton.addActionListener(listener);
	}

	public void openSconto(ActionListener listener) {
		ScontoButton.addActionListener(listener);
	}

	public void openAbbonamento(ActionListener listener) {
		AbbonatiButton.addActionListener(listener);
	}
}