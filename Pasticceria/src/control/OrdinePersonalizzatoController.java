package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.User;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;

	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;

		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new visualizzaOrdinePersonalizzato());
		this.ordinepersonalizzatoif.getPiani(new GetPiani());
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
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersinalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
					utente);
			visualizzaordinepersinalizzatoif.setVisible(true);

		}

	}

	class GetPiani implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Ottieni il valore selezionato dalla JComboBox
			String valoreSelezionato = (String) ordinepersonalizzatoif.getPianiComboBox().getSelectedItem();

			// Utilizza un'espressione regolare per cercare un numero intero
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(valoreSelezionato);

			if (matcher.find()) {
				String valoreNumerico = matcher.group();
				// Converti il valore in un numero intero
				try {
					int valoreIntero = Integer.parseInt(valoreNumerico);
					System.out.println("Piani scelti: " + valoreIntero);

				} catch (NumberFormatException ex) {
					System.out.println("Impossibile convertire il valore in un numero.");
				}
			} else {
				System.out.println("Valore numerico non trovato nella stringa selezionata.");
			}
		}

	}

}
