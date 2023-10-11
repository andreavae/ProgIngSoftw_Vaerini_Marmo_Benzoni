
package model;

import javax.swing.ImageIcon;

public class Prodotto {

	private String IDprodotto;
	private String Nome;
	private float Prezzo;
	private String pathImmagine;
	private ImageIcon imageicon;

	// costruttore 1
	public Prodotto(String nome, String pathImmagine) {
		this.Nome = nome;
		this.pathImmagine = pathImmagine;
	}

	// costruttore 2
	public Prodotto(String nome, float prezzo) {
		this.Nome = nome;
		this.Prezzo = prezzo;
	}

	// ritorno delle variabili
	public String getIDprodotto() {
		return IDprodotto;
	}

	public String getNome() {
		return Nome;
	}

	public float getPrezzo() {
		return Prezzo;
	}

	public String getPathImmagine() {
		return pathImmagine;
	}

	public ImageIcon getImageicon() {
		return imageicon;
	}

	@Override // visualizzazione
	public String toString() {
		return Nome + " Prezzo: " + Prezzo + " €";
	}

}