package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Ordine;
import model.OrdinePersonalizzato;
import model.OrdineStandard;
import model.Pagamento;
import model.User;
import view.LoginIF;
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
	private OrdinePersonalizzato ordinepersonalizzato;
	private LoginIF loginif;

	// costruttore per il pagamento Standard
	public PagamentoController(User utente, PagamentoIF pagamentoif, VisualizzaOrdineIF visualizzaordineif,
			OrdineStandard carrello, Ordine ordine, LoginIF loginif) { // costruttore
		this.utente = utente;
		this.ordine = ordine;
		this.loginif = loginif;
		this.pagamentoif = pagamentoif;
		this.visualizzaordineif = visualizzaordineif;
		this.carrello = carrello;
		this.pagamentoif.pagamento(new pagamentostandard()); // associazione evento per pagamento
	}

	// costruttore per il pagamento personalizzato
	public PagamentoController(User utente, PagamentoIF pagamentoif, OrdinePersonalizzato ordinepersonalizzato,
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzaoif, LoginIF loginif, Ordine ordine) {
		this.utente = utente;
		this.ordine = ordine;
		this.loginif = loginif;
		this.pagamentoif = pagamentoif;
		this.ordinepersonalizzato = ordinepersonalizzato;
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;
		this.pagamentoif.pagamento(new pagamentoOrdinePersonalizzato());
	}

	class pagamentostandard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // per gestire l'evento pagamento
			String numerocarta = pagamentoif.getNumeroCartaField().getText(); // recupera dati inseriti dall'utente
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(ordine, numerocarta, datascadenza);

			if (!loginif.getClientePremiumRadioButton().isSelected()) {
				if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) { // notifica di successo o insuccesso
					visualizzaordineif.dispose();
					pagamentoif.dispose();
					ordine.isOrderValid(ordine, utente, carrello.getTotale(0));
					carrello.svuotaCarrello();
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
					pagamentoif.dispose();
				} else {
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
				}
			} else {
				if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) {
					visualizzaordineif.dispose();
					pagamentoif.dispose();
					ordine.isOrderValid(ordine, utente, carrello.getTotale(0.3));
					carrello.svuotaCarrello();
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
					pagamentoif.dispose();
				} else {
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
				}
			}
		}

	}

	class pagamentoOrdinePersonalizzato implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String numerocarta = pagamentoif.getNumeroCartaField().getText();
			String datascadenza = pagamentoif.getDataScadenzaField().getText();
			Pagamento pagamento = new Pagamento(ordinepersonalizzato, numerocarta, datascadenza);
			if (!loginif.getClientePremiumRadioButton().isSelected()) {
				if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) {

					// qyeryupdate
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
					pagamentoif.dispose();
				} else {
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
				}
			} else {
				if (pagamento.processoPagamento(numerocarta, datascadenza, 1000)) {

					// queryupdate
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento confermato!");
					pagamentoif.dispose();
				} else {
					JOptionPane.showMessageDialog(pagamentoif, "Pagamento non riuscito!");
				}

			}

		}

	}
}
