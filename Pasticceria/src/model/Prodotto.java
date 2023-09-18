
package model;

public class Prodotto {

	public String IDprodotto;
	public String Nome;
	public float Prezzo;

	public Prodotto(String ID, String nome, float prezzo) {
		this.IDprodotto = ID;
		this.Nome = nome;
		this.Prezzo = prezzo;
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

	public void setIDprodotto(String IDprodotto) {
		this.IDprodotto = IDprodotto;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public void setPrezzo(float prezzo) {
		this.Prezzo = prezzo;
	}

}