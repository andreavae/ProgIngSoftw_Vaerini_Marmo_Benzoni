package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Pagamento;
import view.PagamentoIF;

public class PagamentoController {
	private PagamentoIF pagamentoif;
	private Pagamento pagamento;

	public PagamentoController(PagamentoIF pagamentoif) {
		this.pagamentoif = pagamentoif;

		this.pagamentoif.pagamento(new pagamento());
	}

	class pagamento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String numerocarta = pagamentoif.getNumeroCartaField().getText();
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(numerocarta, datascadenza);
			if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
			} else {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
			}

		}

	}
}
