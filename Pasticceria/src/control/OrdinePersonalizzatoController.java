package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;

import model.User;
import view.HomeIF;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private HomeIF homeif;
	private JComboBox<String> combobox;

	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif, HomeIF homeif) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.homeif = homeif;
		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new visualizzaOrdinePersonalizzato(combobox));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPiani(combobox));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPersone());
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetOccasioni());
	}

	class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ordinepersonalizzatoif.setVisible(false);
			homeif.setVisible(true);
		}
	}

	class GetPiani implements ActionListener {
		private int valoreIntero;
		private JComboBox<String> combobox;

		public GetPiani(JComboBox<String> combobox) {
			this.combobox = combobox;
		}

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
					valoreIntero = Integer.parseInt(valoreNumerico);
					System.out.println("Piani scelti: " + valoreIntero);

				} catch (NumberFormatException ex) {
					System.out.println("Impossibile convertire il valore in un numero.");
				}
			} else {
				System.out.println("Valore numerico non trovato nella stringa selezionata.");
			}
		}

		public int getValoreIntero() {

			return valoreIntero;

		}

	}

	class visualizzaOrdinePersonalizzato implements ActionListener {
		private JComboBox<String> combobox;

		public visualizzaOrdinePersonalizzato(JComboBox<String> combobox) {
			this.combobox = combobox;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersinalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
					utente);
			VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
					visualizzaordinepersinalizzatoif);
			visualizzaordinepersinalizzatoif.setVisible(true);
			GetPiani getpiani = new GetPiani(combobox);

		}

	}

	class GetPersone implements ActionListener {
		private int importoPersone;

		@Override
		public void actionPerformed(ActionEvent e) {
			String valoreSelezionato = (String) ordinepersonalizzatoif.getnPersoneComboBox().getSelectedItem();
			int indicedx = valoreSelezionato.lastIndexOf(")");
			int indicesx = valoreSelezionato.lastIndexOf('(', indicedx);
			String valoreEffettivo = valoreSelezionato.substring(indicesx + 2, indicedx - 4).trim();
			importoPersone = Integer.parseInt(valoreEffettivo);
			System.out.println("COSTO IN BASE AL NUMERO DI PERSONE: " + importoPersone);

		}

		public int getImportoPersone() {
			return importoPersone;
		}

	}

	class GetOccasioni implements ActionListener {
		private String valoreSelezionato;

		@Override
		public void actionPerformed(ActionEvent e) {
			valoreSelezionato = (String) ordinepersonalizzatoif.getOccasioneComboBox().getSelectedItem();
			System.out.println("OCCASIONE = " + valoreSelezionato);

		}

		public String getOccasione() {
			return valoreSelezionato;
		}

	}
}
