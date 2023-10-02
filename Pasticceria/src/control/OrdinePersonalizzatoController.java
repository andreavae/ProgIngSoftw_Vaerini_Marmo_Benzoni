package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzato;
	private String descrizione;

	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif,
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.visualizzaordinepersonalizzato = visualizzaordinepersonalizzatoif;

		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.openVisualizzaOrdinePersonalizzatoIF(new visualizzaOrdinePersonalizzato());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ordinepersonalizzatoif.setVisible(false);

		}

	}

	class visualizzaOrdinePersonalizzato implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			descrizione = "Ciao";
			try {
				String stringNpersone = ordinepersonalizzatoif.getNumeroPersoneField().getText();
				if (!stringNpersone.isEmpty()) {
					int nPersone = Integer.parseInt(stringNpersone);
					String dataConsegna = ordinepersonalizzatoif.getDataConsegnaField().getText();
					String descrizioneOrdine = ordinepersonalizzatoif.getDescrizioneOrdineField().getText();
				} else {
					System.out.println("Input mancante");
				}
			} catch (NumberFormatException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}

			visualizzaordinepersonalizzato = new VisualizzaOrdinePersonalizzatoIF(utente.getUsername(), descrizione);
			visualizzaordinepersonalizzato.setVisible(true);
			visualizzaordinepersonalizzato.setDescrizioneOrdine("Ciao");

		}

	}
}
