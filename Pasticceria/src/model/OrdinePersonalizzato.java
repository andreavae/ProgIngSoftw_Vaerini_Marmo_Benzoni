package model;

public class OrdinePersonalizzato {
	private int piani;
	private int numeroPersone;
	private int costopiano = 0;
	private int costopersona = 0;

	public OrdinePersonalizzato(int piani, int numeroPersone) {
		this.piani = piani;
		this.numeroPersone = numeroPersone;
	}

	public double getTotale(int piani, int numeroPersone) {
		if (piani == 1)
			costopiano = 0;
		if (piani == 2)
			costopiano = 30;
		if (piani == 3)
			costopiano = 50;
		if (numeroPersone == 10)
			costopersona = 10;
		if (numeroPersone == 30)
			costopersona = 30;
		if (numeroPersone == 0)
			costopersona = 0;
		return costopiano + costopersona;
	}
}
