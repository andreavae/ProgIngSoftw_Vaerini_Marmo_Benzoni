
package model;

import javax.swing.ImageIcon;

public class Prodotto {

	private String IDprodotto;
	private String Nome;
	private String pathImmagine;
	private ImageIcon imageicon;
	private double prezzo;

	// costruttore 1
	public Prodotto(String nome, String pathImmagine, double prezzo) {
		this.Nome = nome;
		this.pathImmagine = pathImmagine;
		this.prezzo = prezzo;
	}

	// costruttore 2
	public Prodotto(String nome, double prezzo) {
		this.Nome = nome;
		this.prezzo = prezzo;
	}

	// ritorno delle variabili
	public String getIDprodotto() {
		return IDprodotto;
	}

	public String getNome() {
		return Nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getPathImmagine() {
		return pathImmagine;
	}

	public ImageIcon getImageicon() {
		return imageicon;
	}

	@Override // visualizzazione
	public String toString() {
		return Nome + " Prezzo: " + prezzo + " \u20AC\n";
	}

}