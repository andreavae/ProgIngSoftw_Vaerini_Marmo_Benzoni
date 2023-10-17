package testingView;

import org.junit.Before;
import org.junit.Test;

import model.User;
import view.OrdineStandardIF;

public class OrdineStandardIFTest {

	private OrdineStandardIF ordineStandardIF;

	@Before
	public void setUp() {
		// Inizializza l'istanza di OrdineStandardIF con un oggetto User fittizio e uno
		// sconto
		User user = new User("admin", "admin");
		double sconto = 0.3; // Sostituisci con lo sconto desiderato
		ordineStandardIF = new OrdineStandardIF(user, sconto);
	}

	@Test
	public void testAggiungiProdottoCheesecake() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addCheesecakeButton.doClick();

	}

	@Test
	public void testAggiungiProdottoCubana() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addCubanaButton.doClick();

	}

	@Test
	public void testAggiungiProdottoCreamTart() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addCreamtartButton.doClick();

	}

	@Test
	public void testAggiungiProdottoIris() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addIrisButton.doClick();

	}

	@Test
	public void testAggiungiProdottoMimosa() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addMimosaButton.doClick();

	}

	@Test
	public void testAggiungiSainHonore() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addSaintButton.doClick();

	}

	@Test
	public void testAggiungiProdottoSacher() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addSacherButton.doClick();

	}

	@Test
	public void testAggiungiProdottoSetteveli() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addSetteveliButton.doClick();

	}

	@Test
	public void testAggiungiProdottoTiramisu() {
		// Simula il clic sul pulsante "Aggiungi Cheesecake"
		ordineStandardIF.addTiramisuButton.doClick();

	}

	@Test
	public void testPulsanteVisualizzaOrdine() {
		// Simula il clic sul pulsante "Visualizza Ordine"
		ordineStandardIF.VisualizzaOrdineButton.doClick();

		// Aggiungi le asserzioni per verificare il comportamento desiderato
		// Ad esempio, verifica se la schermata di visualizzazione dell'ordine è stata
		// aperta
	}

	@Test
	public void testPulsanteIndietro() {
		// Simula il clic sul pulsante "Indietro"
		ordineStandardIF.BackButton.doClick();

		// Aggiungi le asserzioni per verificare il comportamento desiderato
		// Ad esempio, verifica se l'applicazione è tornata alla schermata precedente
	}
}
