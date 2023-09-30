package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private VisualizzaOrdineIF visualizzaordineif;

	public VisualizzaOrdineController(VisualizzaOrdineIF visualizzaordineif) {
		this.visualizzaordineif = visualizzaordineif;

		this.visualizzaordineif.back(new back());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.setVisible(false);

		}

	}
}
