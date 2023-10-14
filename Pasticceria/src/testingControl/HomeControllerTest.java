package testingControl;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import control.HomeController;
import model.User;
import view.HomeIF;
import view.LoginIF;

public class HomeControllerTest {
	private HomeIF homeif;
	private User utente;
	private LoginIF loginif;

	@Before
	public void setUp() {
		// Inizializzazione dei componenti necessari per i test
		utente = new User("cliente", "cliente");
		loginif = new LoginIF();
		homeif = new HomeIF(utente, loginif, 0);
	}

	@Test
	public void testConstructor1() {
		// Test del costruttore 1
		HomeController controller = new HomeController(homeif, utente, loginif);
		assertNotNull(controller);
		// Verifica che il costruttore abbia inizializzato correttamente il controller
	}

	@Test
	public void testConstructor2() {
		// Test del costruttore 2
		HomeController controller = new HomeController(homeif, utente, loginif, 0.3);
		assertNotNull(controller);
		// Verifica che il costruttore abbia inizializzato correttamente il controller
	}

	// Puoi aggiungere altri test per i vari ActionListener all'interno della classe
	// HomeController

	@Test
	public void testOpenNuovoOrdineIF() {
		HomeController controller = new HomeController(homeif, utente, loginif);
		HomeController.openNuovoOrdineIF listener = controller.new openNuovoOrdineIF();
		// Simula un evento e verifica che il listener funzioni correttamente
		// ad esempio, verifica che venga creata una nuova OrdineStandardIF
	}

	@Test
	public void testOpenOrdinePersonalizzatoIF() {
		HomeController controller = new HomeController(homeif, utente, loginif);
		HomeController.openOrdinePersonalizzatoIF listener = controller.new openOrdinePersonalizzatoIF();
		// Simula un evento e verifica che il listener funzioni correttamente
		// ad esempio, verifica che venga creata una nuova OrdinePersonalizzatoIF
	}

	// Aggiungi altri test per gli altri ActionListener se necessario

}
