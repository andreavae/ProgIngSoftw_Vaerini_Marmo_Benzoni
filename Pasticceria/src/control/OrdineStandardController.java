package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Catalogo;
import model.Cliente;
import model.ClientePremium;
import model.Ordine;
import model.OrdineStandard;
import model.Prodotto;
import model.User;
import view.HomeIF;
import view.IngredientiIF;
import view.LoginIF;
import view.OrdineStandardIF;
import view.VisualizzaOrdineIF;

public class OrdineStandardController {
	private User utente;
	private OrdineStandardIF ordinestandardif;
	private OrdineStandard carrello;
	private HomeIF homeif;
	private Ordine ordine;
	private LoginIF loginif;

	public OrdineStandardController(User utente, OrdineStandardIF ordinestandardif, OrdineStandard carrello,
			HomeIF homeif, Ordine ordine, LoginIF loginif) {
		this.utente = utente;
		this.ordinestandardif = ordinestandardif;
		this.homeif = homeif;
		this.ordine = ordine;
		this.loginif = loginif;
		this.carrello = new OrdineStandard(utente, 0);
		this.ordinestandardif.addCheesecake(new addCheesecake());
		this.ordinestandardif.addCubana(new addCubana());
		this.ordinestandardif.addCreamtart(new addCreamtart());
		this.ordinestandardif.addIris(new addIris());
		this.ordinestandardif.addMimosa(new addMimosa());
		this.ordinestandardif.addSaintHonore(new addSaintHonore());
		this.ordinestandardif.addSacher(new addSacher());
		this.ordinestandardif.addSetteveli(new addSetteveli());
		this.ordinestandardif.addTiramisu(new addTiramisu());
		this.ordinestandardif.visualizzaOrdine(new visualizzaOrdine());
		this.ordinestandardif.back(new back());
		this.ordinestandardif.ingredienti(new ingredienti());

		System.out.println("CATALOGO - ORDINE STANDARD"); // creazione oggetto catalogo
		Catalogo catalogo = Catalogo.getIstance();
		List<Prodotto> listaprodotti = catalogo.getCatalogo();
		System.out.println(listaprodotti);
	}

	// gestione carrello dei prodotti

	public class addCheesecake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cheesecake = new Prodotto("Cheesecake", 15); // oggetto prodotto con nome e prezzo
			carrello.addProdotto(Cheesecake); // aggiunta al carrello
		}
	}

	class addCubana implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cubana = new Prodotto("Cubana", 12);
			carrello.addProdotto(Cubana); // aggiunta al carrello
		}

	}

	class addCreamtart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Creamtart = new Prodotto("Cream Tart", 20);
			carrello.addProdotto(Creamtart); // aggiunta al carrello
		}

	}

	class addIris implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Iris = new Prodotto("Iris", 23);
			carrello.addProdotto(Iris); // aggiunta al carrello
		}

	}

	class addMimosa implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Mimosa = new Prodotto("Mimosa", 20);
			carrello.addProdotto(Mimosa); // aggiunta al carrello
		}

	}

	class addSaintHonore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Saint = new Prodotto("Saint Honorè", 25);
			carrello.addProdotto(Saint); // aggiunta al carrello
		}

	}

	class addSacher implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Sacher = new Prodotto("Sacher", 18);
			carrello.addProdotto(Sacher); // aggiunta al carrello
		}

	}

	class addSetteveli implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Setteveli = new Prodotto("Setteveli", 15);
			carrello.addProdotto(Setteveli); // aggiunta al carrello
		}

	}

	class addTiramisu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Tiramisu = new Prodotto("Tiramisu", 16);
			carrello.addProdotto(Tiramisu); // aggiunta al carrello
		}

	}

	// gestione visualizzazione ordine
	public class visualizzaOrdine implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(carrello.getCarrello()); // stampa contenuto carrello
			System.out.println(utente.isVipUser(utente.getUsername()));
			if (!loginif.getClientePremiumRadioButton().isSelected()) { // se utente non � vip
				// visualizzazione carrello senza sconto sul totale
				utente = new Cliente(utente.getUsername(), utente.getPassword());
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(loginif, utente, carrello, 0);
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello, ordine, loginif);
			} else {
				// visualizzazione carrello con sconto giornaliero sul totale
				utente = new ClientePremium(utente.getUsername(), utente.getPassword());
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(loginif, utente, carrello, 0.3);
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello, ordine, loginif);
			}

		}

	}

	// gestione pulsante back
	public class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// visibilit� interfacce
			homeif.setVisible(true);
			ordinestandardif.dispose();
		}

	}

	// gestione pulsante ingredienti
	public class ingredienti implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			IngredientiIF ingredientiif = new IngredientiIF();
			// visibilit� interfacce
			ingredientiif.setVisible(true);
			ordinestandardif.dispose();
			IngredientiController ingredienticontroller = new IngredientiController(ingredientiif, ordinestandardif);
		}

	}
}