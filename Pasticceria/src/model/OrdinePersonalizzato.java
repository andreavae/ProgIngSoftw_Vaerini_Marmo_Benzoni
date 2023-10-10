package model;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class OrdinePersonalizzato extends Ordine {

	private double costoPiani;
	private String pianistringa; // per la view
	private double costoPersone;
	private String personestringa; // per la view
	private String occasione;
	private String data;
	private double totale;
	private double costo;

	public OrdinePersonalizzato(User utente, double costo) {
		super(utente);
		this.costo = costo;

	}

	public double numerodeipiani(JComboBox<String> nPiani) {
		String valoreSelezionato = (String) nPiani.getSelectedItem();
		int indicedx = valoreSelezionato.lastIndexOf(")");
		int indicesx = valoreSelezionato.lastIndexOf('(', indicedx);
		String pianistringa = valoreSelezionato.substring(indicesx + 2, indicedx - 1);
		costoPiani = Double.parseDouble(pianistringa);
		return costoPiani;
	}

	public String pianiStringa(JComboBox<String> nPiani) {
		pianistringa = (String) nPiani.getSelectedItem();
		System.out.println("NUMERO DI PIANI " + pianistringa);
		return pianistringa;
	}

	public double numerodipersone(JComboBox<String> nPersone) {
		String valoreSelezionato = (String) nPersone.getSelectedItem();
		int indicedx = valoreSelezionato.lastIndexOf(")");
		int indicesx = valoreSelezionato.lastIndexOf('(', indicedx);
		String personestringa = valoreSelezionato.substring(indicesx + 2, indicedx - 1);
		costoPersone = Double.parseDouble(personestringa);
		return costoPersone;
	}

	public String personeStringa(JComboBox<String> nPersone) {
		personestringa = (String) nPersone.getSelectedItem();
		System.out.println("NUMERO DI PERSONE: " + personestringa);
		return personestringa;
	}

	public String occasione(JComboBox<String> occasioni) {
		occasione = (String) occasioni.getSelectedItem();
		System.out.println("OCCASIONE: " + occasione);
		return occasione;
	}

	public String dataConsegna(JTextField date) {
		data = date.getText();
		System.out.println("DATA CONSEGNA: " + data);
		return data;
	}

	public double getTotale(double piani, double persone) {
		totale = piani + persone;
		System.out.println("TOTALE: " + totale);
		return totale;
	}
}
