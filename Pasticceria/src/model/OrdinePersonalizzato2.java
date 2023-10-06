package model;

public class OrdinePersonalizzato2 extends Ordine {
	private int piani;
	private int numPersone;
	private int costoPiano = 0;
	private int costoPersone = 0;

	public OrdinePersonalizzato2(User utente, int piani, int numPersone) {
		super(utente);
		this.piani = piani;
		this.numPersone = numPersone;
	}

	public double getTotale(int piani, int numeroPersone) {
		if (piani == 1)
			costoPiano = 0;
		if (piani == 2)
			costoPiano = 30;
		if (piani == 3)
			costoPiano = 50;
		if (numeroPersone == 10)
			costoPersone = 10;
		if (numeroPersone == 30)
			costoPersone = 30;
		if (numeroPersone == 0)
			costoPersone = 0;
		return costoPiano + costoPersone;
	}

}
