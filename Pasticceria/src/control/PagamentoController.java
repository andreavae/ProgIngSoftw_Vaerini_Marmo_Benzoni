package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Ordine;
import model.OrdineStandard;
import model.Pagamento;
import model.User;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class PagamentoController {
	private User utente;
	private PagamentoIF pagamentoif;
	private Pagamento pagamento;
	private VisualizzaOrdineIF visualizzaordineif;
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;
	private OrdineStandard carrello;
	private Ordine ordine;

	public PagamentoController(User utente, PagamentoIF pagamentoif, VisualizzaOrdineIF visualizzaordineif,
			OrdineStandard carrello, Ordine ordine) { // costruttore
		this.utente = utente;
		this.ordine = ordine;
		this.pagamentoif = pagamentoif;
		this.visualizzaordineif = visualizzaordineif;
		this.carrello = carrello;
		this.pagamentoif.pagamento(new pagamento()); // associazione evento per pagamento
	}

	public PagamentoController(PagamentoIF pagamentoif,
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzaoif) {
		this.pagamentoif = pagamentoif;
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;
		this.pagamentoif.pagamento(new pagamentoOrdinePersonalizzato());
	}

	class pagamento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // per gestire l'evento pagamento
			String numerocarta = pagamentoif.getNumeroCartaField().getText(); // recupera dati inseriti dall'utente
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(ordine, numerocarta, datascadenza);
			if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) { // notifica di successo o insuccesso
				visualizzaordineif.dispose();
				pagamentoif.dispose();
				carrello.svuotaCarrello();
				ordine.isOrderValid(ordine, utente, ordine.prezzoOrdine, ordine.getTipoOrdine());
				// System.out.println(ordine.getTipoOrdine());
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
				pagamentoif.dispose();

			} else {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
			}

		}

	}

	class pagamentoOrdinePersonalizzato implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String numerocarta = pagamentoif.getNumeroCartaField().getText(); // recupera dati inseriti dall'utente
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(ordine, numerocarta, datascadenza);
			if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) { // notifica di successo o insuccesso
				pagamentoif.dispose();
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");

			} else {
				JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
			}

		}

	}
}
