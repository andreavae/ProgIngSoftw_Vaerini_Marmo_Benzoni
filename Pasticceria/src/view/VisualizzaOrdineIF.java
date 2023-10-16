package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.OrdineStandard;
import model.Prodotto;
import model.User;

public class VisualizzaOrdineIF extends JFrame {
	private LoginIF loginif;
	private JPanel VisualizzaOrdineContentPane;
	public JButton BackButton;
	public JButton ConfermaOrdineButton;
	public JButton CancellaButton;
	private User utente;
	private double totale;

	/**
	 * Create the frame.
	 */
	public VisualizzaOrdineIF(LoginIF loginif, User utente, OrdineStandard carrello, double sconto) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.loginif = loginif;
		this.utente = utente;
		setMinimumSize(new Dimension(450, 300)); // Imposta le dimensioni minime
		setLocationRelativeTo(null);
		VisualizzaOrdineContentPane = new JPanel();
		VisualizzaOrdineContentPane.setBackground(new Color(255, 180, 180));
		VisualizzaOrdineContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VisualizzaOrdineContentPane);
		VisualizzaOrdineContentPane.setLayout(new BorderLayout()); // Usa BorderLayout

		JLabel VisualizzaOrdineLabel = new JLabel("ORDINE"); // etichetta ordine
		VisualizzaOrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		VisualizzaOrdineLabel.setHorizontalAlignment(JLabel.CENTER); // Centra il testo
		VisualizzaOrdineContentPane.add(VisualizzaOrdineLabel, BorderLayout.NORTH);

		// lista di prodotti nel carrello
		DefaultListModel<Prodotto> listModel = new DefaultListModel<>();
		for (Prodotto prodotto : carrello.getCarrello()) {
			listModel.addElement(prodotto);
		}
		JList<Prodotto> lista = new JList<Prodotto>(listModel);
		JScrollPane scrollPane = new JScrollPane(lista); // per scorrere la lista
		VisualizzaOrdineContentPane.add(scrollPane, BorderLayout.CENTER);

		JLabel ScontoLabel = new JLabel("Sconto: " + sconto * 100 + "%");
		ScontoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		scrollPane.setColumnHeaderView(ScontoLabel);

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Aggiungi le due JLabel affiancate
		boolean flagVip = loginif.getClientePremiumRadioButton().isSelected();
		if (!flagVip) {
			totale = carrello.getTotale(0);
		} else {
			totale = carrello.getTotale(0.3);
		}

		BackButton = new JButton("Back"); // bottone back
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBackground(new Color(255, 80, 120));
		labelPanel.add(BackButton);
		JLabel label1 = new JLabel("Totale: " + totale + " €");
		label1.setBackground(new Color(255, 255, 255));
		label1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelPanel.add(label1);

		/*
		 * JLabel label2 = new JLabel(""+totale+ " €"); // Sostituisci con il valore
		 * effettivo del totale label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 * labelPanel.add(label2);
		 */
		// Aggiungi il pannello delle JLabel alla parte inferiore
		VisualizzaOrdineContentPane.add(labelPanel, BorderLayout.SOUTH);

		ConfermaOrdineButton = new JButton("Conferma Ordine"); // bottone conferma ordine
		ConfermaOrdineButton.setForeground(new Color(255, 255, 255));
		ConfermaOrdineButton.setBackground(new Color(255, 80, 120));
		ConfermaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelPanel.add(ConfermaOrdineButton);

		CancellaButton = new JButton("Cancella"); // bottone cancella
		CancellaButton.setForeground(new Color(255, 255, 255));
		CancellaButton.setBackground(new Color(255, 80, 120));
		CancellaButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelPanel.add(CancellaButton);
		setVisible(true);

	}

	// attivazione ascolatori

	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

	public void conferma(ActionListener listener) {
		ConfermaOrdineButton.addActionListener(listener);
	}

	public void cancellaOrdine(ActionListener listener) {
		CancellaButton.addActionListener(listener);
	}
}
