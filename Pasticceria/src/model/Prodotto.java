
package model;

import javax.swing.ImageIcon;

public class Prodotto {

	private String IDprodotto;
	private String Nome;
	private float Prezzo;
	private String pathImmagine;
	private ImageIcon imageicon;

	public Prodotto(String nome, String pathImmagine) {
		this.Nome = nome;
		this.pathImmagine = pathImmagine;
	}

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

}