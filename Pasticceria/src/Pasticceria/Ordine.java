
package Pasticceria;

import java.util.ArrayList;

public class Ordine {

	public int NOrdine;
	public String Note;
	public String CodiceCliente;
	public ArrayList<Prodotto> ListaProd;
	public StatoOrdine Stato;
	public int Totqta;

	public Ordine(int numeroOrdine, String CodiceCliente, ArrayList<Prodotto> listaProd, String Note) { // devo inserire
																										// la data??
		this.NOrdine = numeroOrdine;
		this.CodiceCliente = CodiceCliente;
		this.ListaProd = listaProd;
		this.Note = Note;
		this.Stato = StatoOrdine.ATTESA; // all'inizio lo stato è in attesa

	/*	
	 * QUANTITà DA GESTIRE TRAMITE JAVASWING
	 * 
	 * int tot = 0;                     
		for (Prodotto prod : listaProd) {
			tot = tot++;
		}
		this.Totqta = tot;
   */
	}

	public int getNOrdine() {
		return NOrdine;
	}

	public String getNote() {
		return Note;
	}

	public String getCodiceCliente() {
		return CodiceCliente;
	}

	public ArrayList<Prodotto> getListaProd() {
		return ListaProd;
	}

	public int getTotaleqta() {
		return Totqta;
	}

	public StatoOrdine getStato() {
		return Stato;
	}

	public void setStato(StatoOrdine Stato) {
		this.Stato = Stato;
	}

}
