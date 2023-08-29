
package Pasticceria;

import java.util.ArrayList;

public class Prodotto {

	public String IDprodotto;
	public String Nome;
	public float Prezzo;
	public ArrayList<String> Ingredienti; // da controllare ( sbagliato)

	public Prodotto(String ID, String nome, float prezzo, ArrayList<String> Ingr) {
		this.IDprodotto = ID;
		this.Nome = nome;
		this.Prezzo = prezzo;
		this.Ingredienti = Ingr;
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

	public ArrayList<String> getIngredienti() {
		return Ingredienti;
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


	public ArrayList<String> setIngredienti(String Ing) { // non posso usarlo per creare il prodotto
		Ingredienti.add(Ing);
		return Ingredienti;
	}

}