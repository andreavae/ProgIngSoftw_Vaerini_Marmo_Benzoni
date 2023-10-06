package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.OrdinePersonalizzato;
//import control.OrdinePersonalizzatoController.visualizzaOrdinePersonalizzato;
import model.User;
import view.HomeIF;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private HomeIF homeif;
	private JComboBox<String> nPiani;
	private JTextField deadline;
	private JComboBox<String> menuoccasioni;
	private JComboBox<String> listapersone;

	// costruttore
	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif, HomeIF homeif,
			JTextField deadline, JComboBox<String> menuoccasioni, JComboBox<String> listapersone,
			JComboBox<String> nPiani, OrdinePersonalizzato ordinepersonalizzato) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.homeif = homeif;
		this.deadline = deadline;
		this.menuoccasioni = menuoccasioni;
		this.listapersone = listapersone;
		this.nPiani = nPiani;
		this.ordinepersonalizzato = ordinepersonalizzato;
		// associazione gestori
		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new VisualizzaOrdinePersonalizzato());
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPiani(nPiani));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetPersone(listapersone));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetOccasioni(menuoccasioni));
		this.ordinepersonalizzatoif.visualizzaOrdine(new GetData(deadline));

	}

	// gestione dei piani del prodotto
	class GetPiani implements ActionListener {
		private String valoreSelezionato;
		private JComboBox<String> nPiani;

		public GetPiani(JComboBox<String> nPiani) {
			this.nPiani = nPiani;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// viene selezionato il valore del menu a tendina (jComboBox)
			String valoreSelezionato = (String) ordinepersonalizzatoif.getPianiComboBox().getSelectedItem();
		}

		// l'elemento selezionato viene restituito
		public String getPiani(JComboBox<String> nPiani) {

			return (String) nPiani.getSelectedItem();

		}

	}

	// gestione del numero di persone a cui si offre la torta
	class GetPersone implements ActionListener {
		private JComboBox<String> listapersone;
		private String valoreSelezionato;

		public GetPersone(JComboBox<String> listapersone) {
			this.listapersone = listapersone;
		}

		@Override // prelevato il valore selezionato
		public void actionPerformed(ActionEvent e) {
			String valoreSelezionato = (String) ordinepersonalizzatoif.getnPersoneComboBox().getSelectedItem();
		}

		// l'elemento selezionato viene restituito
		public String getImportoPersone(JComboBox<String> listapersone) {
			return (String) listapersone.getSelectedItem();
		}

	}

	// gestione del tipo di occasione
	class GetOccasioni implements ActionListener {
		private JComboBox<String> menuoccasioni;
		private String valoreSelezionato;

		public GetOccasioni(JComboBox<String> menuoccasioni) {
			this.menuoccasioni = menuoccasioni;
		}

		@Override // prelevato il valore selezionato
		public void actionPerformed(ActionEvent e) {
			valoreSelezionato = (String) ordinepersonalizzatoif.getOccasioneComboBox().getSelectedItem();

		}

		// l'elemento selezionato viene restituito
		public String getOccasione(JComboBox<String> menuoccasioni) {
			return (String) menuoccasioni.getSelectedItem();
		}

	}

	// gestione per l'ottenimento della data
	class GetData implements ActionListener {
		private JTextField data; // variabile per raccogliere l'input

		public GetData(JTextField data) {
			this.data = data;
		}

		@Override // associare alla variabile data il valore all'interno del campo di testo
		public void actionPerformed(ActionEvent e) {

			data = ordinepersonalizzatoif.getDataConsegnaField();

		}

		// valore restituito
		public String getConsegna(JTextField data) {
			return data.getText();
		}
	}

	// gestione bottone back
	class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// visibilità delle interfaccie
			ordinepersonalizzatoif.setVisible(false);
			homeif.setVisible(true);
		}
	}

	// gestione della visualizzazione di un ordine personalizzato
	class VisualizzaOrdinePersonalizzato implements ActionListener {
		private String dataConsegna;
		private String occasione;
		private String nPersone;
		private String piani;
		private int importoPersone;
		private int piano;
		private double totale;

		@Override
		public void actionPerformed(ActionEvent e) {
			// ottenere la data di consegna
			GetData getdeadline = new GetData(ordinepersonalizzatoif.getDataConsegnaField());
			dataConsegna = getdeadline.getConsegna(deadline);

			// ottenere l'occasione
			GetOccasioni getoccasioni = new GetOccasioni(ordinepersonalizzatoif.getOccasioneComboBox());
			occasione = getoccasioni.getOccasione(menuoccasioni);

			// estrae l'importo delle persone selezionate dalla stringa e rimuove eventuali
			// parentesi o spazi traformando la stringa in dato intero per ottenere il
			// numero di persone
			GetPersone getpersone = new GetPersone(ordinepersonalizzatoif.getnPersoneComboBox());
			nPersone = getpersone.getImportoPersone(listapersone);
			int indicedx = nPersone.lastIndexOf(")");
			int indicesx = nPersone.lastIndexOf('(', indicedx);
			String valoreEffettivo = nPersone.substring(indicesx + 2, indicedx - 4).trim();
			importoPersone = Integer.parseInt(valoreEffettivo);

			// cerca una sequenza di cifre all'interno della stringa e le converte in numeri
			// interi
			GetPiani getpiani = new GetPiani(ordinepersonalizzatoif.getPianiComboBox());
			piani = getpiani.getPiani(nPiani);
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(piani); // per cercare le corrispondenze
			if (matcher.find()) { // verifica se una corrispondenza è stata trovata
				String valoreNumerico = matcher.group(); // estrae la stringa corrispondente le cifre
				try {
					piano = Integer.parseInt(valoreNumerico); // conversione in interi
					System.out.println("Piani scelti: " + piano);
				} catch (NumberFormatException ex) {
					System.out.println("Impossibile convertire il valore in un numero.");
				}
			} else {
				System.out.println("Valore numerico non trovato nella stringa selezionata.");
			}

			// creazione ordine personalizzato
			ordinepersonalizzato = new OrdinePersonalizzato(piano, importoPersone);
			totale = ordinepersonalizzato.getTotale(piano, importoPersone); // calcolo totale dell'ordine
			if (utente.isVipUser(utente.getUsername())) {// veridica se l'utente è vip
				// viene applicato uno sconto sul totale
				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, nPersone, totale, 0.3);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						visualizzaordinepersonalizzatoif);
				visualizzaordinepersonalizzatoif.setVisible(true);
			} else {
				// lo sconto non viene applicato
				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, nPersone, totale, 0.0);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						visualizzaordinepersonalizzatoif);
				visualizzaordinepersonalizzatoif.setVisible(true);
			}

		}

	}
}
