package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.OrdinePersonalizzatoController;
import model.Prodotto;
import model.User;

public class VisualizzaOrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane;
	public String descrizioneOrdine;
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private OrdinePersonalizzatoController ordinepersonalizzatocontroller;
	public JButton BackButton;
	public JButton ConfermaOrdineButton;

	/**
	 * Create the frame.
	 */
	public VisualizzaOrdinePersonalizzatoIF(User utente, String dataConsegna, String occasione, String piani,
			String persone, Prodotto torta, double totale, double sconto) { // costruttore

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiusura interfaccia
		setBounds(100, 100, 512, 352);
		setLocationRelativeTo(null);
		setResizable(false); // impedisce all'utente di ridimensionare la finestra
		contentPane = new JPanel(); // per aggiungere componenti grafici
		contentPane.setBackground(new Color(255, 180, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel OrdineLabel = new JLabel("ORDINE PERSONALIZZATO"); // etichetta ordine personalizzato
		OrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		OrdineLabel.setBounds(10, 36, 223, 34);
		contentPane.add(OrdineLabel);

		JLabel UserLabel = new JLabel("User:"); // etichetta user
		UserLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UserLabel);

		JLabel UserInLabel = new JLabel(utente.getUsername()); // ottenimento nome user
		UserInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserInLabel.setBounds(50, 11, 92, 14);
		contentPane.add(UserInLabel);

		BackButton = new JButton("Back"); // bottone back
		BackButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		BackButton.setBounds(10, 279, 75, 23);
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.setBackground(new Color(255, 80, 120));
		contentPane.add(BackButton);

		// visualizzaione data consegna
		JLabel DataLabel = new JLabel("Data Consegna:");
		DataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DataLabel.setBounds(10, 191, 114, 23);
		contentPane.add(DataLabel);

		JLabel SetDataLabel = new JLabel(dataConsegna);
		SetDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		SetDataLabel.setBounds(141, 195, 92, 14);
		contentPane.add(SetDataLabel);

		// visualizzazione occasione
		JLabel OccasioneLabel = new JLabel("Occasione:");
		OccasioneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OccasioneLabel.setBounds(10, 225, 92, 23);
		contentPane.add(OccasioneLabel);

		JLabel SetOccasioneLabel = new JLabel(occasione);
		SetOccasioneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		SetOccasioneLabel.setBounds(141, 227, 75, 19);
		contentPane.add(SetOccasioneLabel);

		// viualizzazione numero piani
		JLabel PianiLabel = new JLabel("Numero di piani:");
		PianiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		PianiLabel.setBounds(10, 104, 92, 34);
		contentPane.add(PianiLabel);

		JLabel SetPianiLabel = new JLabel(piani);
		SetPianiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		SetPianiLabel.setBounds(143, 114, 126, 14);
		contentPane.add(SetPianiLabel);

		// visualizzazione nuemero persone
		JLabel NumPersoneLabel = new JLabel("Numero di persone:");
		NumPersoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		NumPersoneLabel.setBounds(10, 149, 132, 23);
		contentPane.add(NumPersoneLabel);

		JLabel SetNumPersoneLabel = new JLabel(persone);
		SetNumPersoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		SetNumPersoneLabel.setBounds(145, 153, 263, 14);
		contentPane.add(SetNumPersoneLabel);

		// Totale prezzo
		double prezzoTotale = totale + torta.getPrezzo();
		double prezzoConSconto = prezzoTotale - prezzoTotale * sconto;
		JLabel TotaleLabel = new JLabel("Totale: " + prezzoConSconto + "€");
		TotaleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		TotaleLabel.setBounds(141, 271, 75, 14);
		contentPane.add(TotaleLabel);

		// Bottone di conferma ordine
		ConfermaOrdineButton = new JButton("Conferma Ordine");
		ConfermaOrdineButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ConfermaOrdineButton.setBounds(336, 279, 150, 23);
		ConfermaOrdineButton.setForeground(new Color(255, 255, 255));
		ConfermaOrdineButton.setBackground(new Color(255, 80, 120));
		contentPane.add(ConfermaOrdineButton);

		// visualizzazione sconto
		JLabel ScontoLabel = new JLabel("Sconto: ");
		ScontoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoLabel.setBounds(373, 11, 46, 14);
		contentPane.add(ScontoLabel);

		JLabel ScontoSetLabel = new JLabel(sconto * 100 + "%");
		ScontoSetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ScontoSetLabel.setBounds(421, 11, 46, 14);
		contentPane.add(ScontoSetLabel);

		JLabel TortaLabel = new JLabel("Torta");
		TortaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		TortaLabel.setBounds(10, 79, 46, 14);
		contentPane.add(TortaLabel);

		JLabel setTortaLabel = new JLabel("" + torta);
		setTortaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		setTortaLabel.setBounds(141, 79, 190, 14);
		contentPane.add(setTortaLabel);

	}

	// descrizione ordine
	public void setDescrizioneOrdine(String descrizioneOrdine) {
		this.descrizioneOrdine = descrizioneOrdine;
	}

	// attivazione ascoltatore
	public void back(ActionListener listener) {
		this.BackButton.addActionListener(listener);
	}

	public void conferma(ActionListener listener) {
		ConfermaOrdineButton.addActionListener(listener);
	}

}
