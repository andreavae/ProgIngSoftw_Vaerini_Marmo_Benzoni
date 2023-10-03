package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.OrdinePersonalizzatoController;
import model.User;

public class VisualizzaOrdinePersonalizzatoIF extends JFrame {

	private JPanel contentPane;
	private String descrizioneOrdine;
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private OrdinePersonalizzatoController ordinepersonalizzatocontroller;

	/**
	 * Create the frame.
	 */
	public VisualizzaOrdinePersonalizzatoIF(User utente) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 352);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel OrdineLabel = new JLabel("ORDINE PERSONALIZZATO");
		OrdineLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		OrdineLabel.setBounds(10, 36, 159, 34);
		contentPane.add(OrdineLabel);

		JLabel UserLabel = new JLabel("User:");
		UserLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserLabel.setBounds(10, 11, 46, 14);
		contentPane.add(UserLabel);

		JLabel UserInLabel = new JLabel(utente.getUsername());
		UserInLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		UserInLabel.setBounds(50, 11, 92, 14);
		contentPane.add(UserInLabel);

		JLabel DescrizioneLabel = new JLabel(descrizioneOrdine);
		DescrizioneLabel.setBounds(10, 81, 343, 53);
		contentPane.add(DescrizioneLabel);
	}

	public void setDescrizioneOrdine(String descrizioneOrdine) {
		this.descrizioneOrdine = descrizioneOrdine;
	}

}
