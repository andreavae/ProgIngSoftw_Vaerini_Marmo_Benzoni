
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

	public String getNome() {
		return Nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getPathImmagine() {
		return pathImmagine;
	}

	@Override // visualizzazione
	public String toString() {
		return Nome + " Prezzo: " + prezzo + " €";
	}

}