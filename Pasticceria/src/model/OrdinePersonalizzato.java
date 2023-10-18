package model;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class OrdinePersonalizzato extends Ordine {

	private double costoPiani;
	private String pianistringa;
	private double costoPersone;
	private String personestringa;
	private String occasione;
	private String data;
	private double totale;
	private double costo;
	private Double[] prezzi;

	public OrdinePersonalizzato(User utente, double sconto, double costo) { // costruttore
		super(utente);
		prezzi = new Double[2];

	}

	// estrazione del prezzo in base al numero dei piani indicati dall'utente
	public double numerodeipiani(JComboBox<String> nPiani) {
		String valoreSelezionato = (String) nPiani.getSelectedItem();
		int indicedx = valoreSelezionato.lastIndexOf(")");
		int indicesx = valoreSelezionato.lastIndexOf('(', indicedx);
		String pianistringa = valoreSelezionato.substring(indicesx + 2, indicedx - 1);
		costoPiani = Double.parseDouble(pianistringa);
		return costoPiani;
	}

	// estrazione numero dei piani
	public String pianiStringa(JComboBox<String> nPiani) {
		pianistringa = (String) nPiani.getSelectedItem();
		System.out.println("NUMERO DI PIANI " + pianistringa);
		return pianistringa;
	}

	// estrazione costo rispetto al numero delle persone
	public double numerodipersone(JComboBox<String> nPersone) {
		String valoreSelezionato = (String) nPersone.getSelectedItem();
		int indicedx = valoreSelezionato.lastIndexOf(")");
		int indicesx = valoreSelezionato.lastIndexOf('(', indicedx);
		String personestringa = valoreSelezionato.substring(indicesx + 2, indicedx - 1);
		costoPersone = Double.parseDouble(personestringa);
		return costoPersone;
	}

	// estrazione della torta
	public Prodotto tipoTorta(JComboBox<Prodotto> catalogo) {
		Prodotto valoreSelezionato = (Prodotto) catalogo.getSelectedItem();
		System.out.println("TORTA: " + valoreSelezionato);
		return valoreSelezionato;
	}

	// estrazione numero delle persone
	public String personeStringa(JComboBox<String> nPersone) {
		personestringa = (String) nPersone.getSelectedItem();
		System.out.println("NUMERO DI PERSONE: " + personestringa);
		return personestringa;
	}

	// estrazione occasione
	public String occasione(JComboBox<String> occasioni) {
		occasione = (String) occasioni.getSelectedItem();
		System.out.println("OCCASIONE: " + occasione);
		return occasione;
	}

	// estrazione data consegna
	public String dataConsegna(JTextField date) {
		data = date.getText();
		System.out.println("DATA CONSEGNA: " + data);
		return data;
	}

	// ottenimento del costo totale
	public double getTotale(double piani, double persone) {
		totale = piani + persone;
		System.out.println("TOTALE: " + totale);
		return totale;
	}

}
