package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import model.OrdinePersonalizzato;
import model.User;

public class OrdinePersonalizzatoTest {
	private OrdinePersonalizzato ordinePersonalizzato;

	@Before
	public void setUp() {
		User utente = new User("user", "user");
		ordinePersonalizzato = new OrdinePersonalizzato(utente);
	}

	@Test
	public void testNumerodeipiani() {
		JComboBox<String> nPiani = new JComboBox<>();
		nPiani.addItem("2 (+30.00€)");
		double costoPiani = ordinePersonalizzato.numerodeipiani(nPiani);
		assertEquals(30.0, costoPiani, 0.01); // Verifica che il costo dei piani sia corretto
	}

	@Test
	public void testPianiStringa() {
		JComboBox<String> nPiani = new JComboBox<>();
		nPiani.addItem("(2) Piani: 80");
		String pianistringa = ordinePersonalizzato.pianiStringa(nPiani);
		assertNotNull(pianistringa); // Verifica che la stringa non sia nulla
	}

	@Test
	public void testNumerodipersone() {
		JComboBox<String> nPersone = new JComboBox<>();
		nPersone.addItem("Da 10 a 15 persone (+10.00€)");
		double costoPersone = ordinePersonalizzato.numerodipersone(nPersone);
		assertEquals(10.0, costoPersone, 0.01); // Verifica che il costo delle persone sia corretto
	}

	@Test
	public void testPersoneStringa() {
		JComboBox<String> nPersone = new JComboBox<>();
		nPersone.addItem("(4) Persone: 120");
		String personestringa = ordinePersonalizzato.personeStringa(nPersone);
		assertNotNull(personestringa); // Verifica che la stringa non sia nulla
	}

	@Test
	public void testOccasione() {
		JComboBox<String> occasioni = new JComboBox<>();
		occasioni.addItem("Compleanno");
		String occasione = ordinePersonalizzato.occasione(occasioni);
		assertNotNull(occasione); // Verifica che l'occasione non sia nulla
	}

	@Test
	public void testDataConsegna() {
		JTextField date = new JTextField("2023-10-15");
		String data = ordinePersonalizzato.dataConsegna(date);
		assertNotNull(data); // Verifica che la data non sia nulla
	}

	@Test
	public void testGetTotale() {
		double piani = 50.0;
		double persone = 100.0;
		double totale = ordinePersonalizzato.getTotale(piani, persone);
		assertEquals(150.0, totale, 0.01); // Verifica che il totale sia corretto
	}
}
