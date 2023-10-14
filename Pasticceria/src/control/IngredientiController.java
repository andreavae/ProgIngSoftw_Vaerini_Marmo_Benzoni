package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.IngredientiIF;
import view.OrdineStandardIF;

public class IngredientiController {

	private IngredientiIF ingredientiif;
	private OrdineStandardIF ordinestandardif;

	// costruttore
	public IngredientiController(IngredientiIF ingredientiif, OrdineStandardIF ordinestandardif) {
		this.ingredientiif = ingredientiif;
		this.ordinestandardif = ordinestandardif;
		this.ingredientiif.back(new back());

	}

	// gestione pulsante back
	public class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { // torna ad ordine standard
			// visibilit� interfacce
			ordinestandardif.setVisible(true);
			ingredientiif.dispose();
		}
	}

}
