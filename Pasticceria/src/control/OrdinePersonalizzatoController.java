package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextField;

//import control.OrdinePersonalizzatoController.visualizzaOrdinePersonalizzato;
import model.User;
import view.HomeIF;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private HomeIF homeif;
	private JComboBox<String> nPiani;
	private JTextField deadline;
	private JComboBox<String> menuoccasioni;
	private JComboBox<String> listapersone;

	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif, HomeIF homeif,
			JTextField deadline, JComboBox<String> menuoccasioni, JComboBox<String> listapersone,
			JComboBox<String> nPiani) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.homeif = homeif;
		this.deadline = deadline;
		this.menuoccasioni = menuoccasioni;
		this.listapersone = listapersone;
		this.nPiani = nPiani;
		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new VisualizzaOrdinePersonalizzato());
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPiani(nPiani));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPersone(listapersone));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetOccasioni(menuoccasioni));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetData(deadline));
	}

	class GetPiani implements ActionListener {
		private String valoreSelezionato;
		private JComboBox<String> nPiani;

		public GetPiani(JComboBox<String> nPiani) {
			this.nPiani = nPiani;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Ottieni il valore selezionato dalla JComboBox
			String valoreSelezionato = (String) ordinepersonalizzatoif.getPianiComboBox().getSelectedItem();
		}

		public String getPiani(JComboBox<String> nPiani) {

			return (String) nPiani.getSelectedItem();

		}

	}

	class GetPersone implements ActionListener {
		private JComboBox<String> listapersone;
		private String valoreSelezionato;

		public GetPersone(JComboBox<String> listapersone) {
			this.listapersone = listapersone;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String valoreSelezionato = (String) ordinepersonalizzatoif.getnPersoneComboBox().getSelectedItem();
		}

		public String getImportoPersone(JComboBox<String> listapersone) {
			return (String) listapersone.getSelectedItem();
		}

	}

	class GetOccasioni implements ActionListener {
		private JComboBox<String> menuoccasioni;
		private String valoreSelezionato;

		public GetOccasioni(JComboBox<String> menuoccasioni) {
			this.menuoccasioni = menuoccasioni;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			valoreSelezionato = (String) ordinepersonalizzatoif.getOccasioneComboBox().getSelectedItem();

		}

		public String getOccasione(JComboBox<String> menuoccasioni) {
			return (String) menuoccasioni.getSelectedItem();
		}

	}

	class GetData implements ActionListener {
		private JTextField data;

		public GetData(JTextField data) {
			this.data = data;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			data = ordinepersonalizzatoif.getDataConsegnaField();

		}

		public String getConsegna(JTextField data) {
			return data.getText();
		}
	}

	class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ordinepersonalizzatoif.setVisible(false);
			homeif.setVisible(true);
		}
	}

	class VisualizzaOrdinePersonalizzato implements ActionListener {
		private String dataConsegna;
		private String occasione;
		private String nPersone;
		private String piani;
		private int importoPersone;
		private int piano;

		@Override
		public void actionPerformed(ActionEvent e) {
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
					utente);
			VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
					visualizzaordinepersonalizzatoif);
			visualizzaordinepersonalizzatoif.setVisible(true);

			GetData getdeadline = new GetData(ordinepersonalizzatoif.getDataConsegnaField());
			dataConsegna = getdeadline.getConsegna(deadline);
			System.out.println(dataConsegna);

			GetOccasioni getoccasioni = new GetOccasioni(ordinepersonalizzatoif.getOccasioneComboBox());
			occasione = getoccasioni.getOccasione(menuoccasioni);
			System.out.println(occasione);

			GetPersone getpersone = new GetPersone(ordinepersonalizzatoif.getnPersoneComboBox());
			nPersone = getpersone.getImportoPersone(listapersone);
			int indicedx = nPersone.lastIndexOf(")");
			int indicesx = nPersone.lastIndexOf('(', indicedx);
			String valoreEffettivo = nPersone.substring(indicesx + 2, indicedx - 4).trim();
			importoPersone = Integer.parseInt(valoreEffettivo);
			System.out.println("COSTO IN BASE AL NUMERO DI PERSONE: " + importoPersone);

			GetPiani getpiani = new GetPiani(ordinepersonalizzatoif.getPianiComboBox());
			piani = getpiani.getPiani(nPiani);
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(piani);
			if (matcher.find()) {
				String valoreNumerico = matcher.group();
				try {
					piano = Integer.parseInt(valoreNumerico);
					System.out.println("Piani scelti: " + piano);
				} catch (NumberFormatException ex) {
					System.out.println("Impossibile convertire il valore in un numero.");
				}
			} else {
				System.out.println("Valore numerico non trovato nella stringa selezionata.");
			}

		}
	}
}
