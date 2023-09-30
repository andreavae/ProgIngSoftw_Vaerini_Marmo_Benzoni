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

import model.Carrello;
import model.Prodotto;

public class VisualizzaOrdineIF extends JFrame {

	private JPanel VisualizzaOrdineContentPane;
	private JButton BackButton;
	private JButton ConfermaOrdineButton;

	/**
	 * Create the frame.
	 */
	public VisualizzaOrdineIF(Carrello carrello) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(450, 300)); // Imposta le dimensioni minime
		setLocationRelativeTo(null);
		VisualizzaOrdineContentPane = new JPanel();
		VisualizzaOrdineContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VisualizzaOrdineContentPane);
		VisualizzaOrdineContentPane.setLayout(new BorderLayout()); // Usa BorderLayout

		JLabel VisualizzaOrdineLabel = new JLabel("ORDINE");
		VisualizzaOrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		VisualizzaOrdineLabel.setHorizontalAlignment(JLabel.CENTER); // Centra il testo
		VisualizzaOrdineContentPane.add(VisualizzaOrdineLabel, BorderLayout.NORTH);

		DefaultListModel<Prodotto> listModel = new DefaultListModel<>();
		for (Prodotto prodotto : carrello.getCarrello()) {
			listModel.addElement(prodotto);
		}
		JList<Prodotto> lista = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(lista);
		VisualizzaOrdineContentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Aggiungi le due JLabel affiancate
		float totale = carrello.getTotale();

		BackButton = new JButton("Back");
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBackground(new Color(0, 128, 255));
		labelPanel.add(BackButton);
		JLabel label1 = new JLabel("Totale: " + totale + "€");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelPanel.add(label1);

		/*
		 * JLabel label2 = new JLabel(""+totale+ " €"); // Sostituisci con il valore
		 * effettivo del totale label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 * labelPanel.add(label2);
		 */
		// Aggiungi il pannello delle JLabel alla parte inferiore
		VisualizzaOrdineContentPane.add(labelPanel, BorderLayout.SOUTH);

		ConfermaOrdineButton = new JButton("Conferma Ordine");
		ConfermaOrdineButton.setForeground(new Color(255, 255, 255));
		ConfermaOrdineButton.setBackground(new Color(0, 128, 255));
		ConfermaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelPanel.add(ConfermaOrdineButton);
		setVisible(true);

	}

	public void back(ActionListener listener) {
		BackButton.addActionListener(listener);
	}

	public void conferma(ActionListener listener) {
		ConfermaOrdineButton.addActionListener(listener);
	}
}
