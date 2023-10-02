package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Carrello;
import model.Pagamento;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class PagamentoController {
	private PagamentoIF pagamentoif;
	private Pagamento pagamento;
	private VisualizzaOrdineIF visualizzaordineif;
	private Carrello carrello;

	public PagamentoController(PagamentoIF pagamentoif, VisualizzaOrdineIF visualizzaordineif, Carrello carrello) { // costruttore
		this.pagamentoif = pagamentoif;
		this.visualizzaordineif = visualizzaordineif;
		this.carrello = carrello;
		this.pagamentoif.pagamento(new pagamento()); // associazione evento per pagamento
	}

	class pagamento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // per gestire l'evento pagamento
			String numerocarta = pagamentoif.getNumeroCartaField().getText(); // recupera dati inseriti dall'utente
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(numerocarta, datascadenza);
			if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) { // notifica di successo o insuccesso
				visualizzaordineif.dispose();
				pagamentoif.dispose();
				carrello.svuotaCarrello();
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
				pagamentoif.dispose();
			} else {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
			}

		}

	}
}
