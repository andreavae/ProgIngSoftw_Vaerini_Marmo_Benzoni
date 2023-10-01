package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Pagamento;
import view.PagamentoIF;

public class PagamentoController {
	private PagamentoIF pagamentoif;
	private Pagamento pagamento;

	public PagamentoController(PagamentoIF pagamentoif) { // costruttore
		this.pagamentoif = pagamentoif;

		this.pagamentoif.pagamento(new pagamento()); // associazione evento per pagamento
	}

	class pagamento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // per gestire l'evento pagamento
			String numerocarta = pagamentoif.getNumeroCartaField().getText(); // recupera dati inseriti dall'utente
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(numerocarta, datascadenza);
			if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) { // notifica di successo o insuccesso
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
				pagamentoif.dispose();
			} else {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
			}

		}

	}
}
