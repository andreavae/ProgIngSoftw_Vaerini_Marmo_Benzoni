package testingModel;

import static org.junit.Assert.assertEquals;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import model.OrdinePersonalizzato;
import model.Prodotto;

public class OrdinePersonalizzatoTest {

	private OrdinePersonalizzato ordinePersonalizzato;

	@Before
	public void setUp() {
		// Inizializza l'oggetto OrdinePersonalizzato per il test
		ordinePersonalizzato = new OrdinePersonalizzato(null, 0.0, 0.0);
	}

	@Test
	public void testNumerodeipiani() {
		JComboBox<String> nPiani = new JComboBox<>();
		nPiani.addItem("2 (+30.00€)");
		double costoPiani = ordinePersonalizzato.numerodeipiani(nPiani);
		assertEquals(30.00, costoPiani, 0.01); // Assicurati che il costo sia uguale a 3.0
	}

	@Test
	public void testPianiStringa() {
		JComboBox<String> nPiani = new JComboBox<>();
		nPiani.addItem("Piani (4)");
		String pianistringa = ordinePersonalizzato.pianiStringa(nPiani);
		assertEquals("Piani (4)", pianistringa);
	}

	@Test
	public void testNumerodipersone() {
		JComboBox<String> nPersone = new JComboBox<>();
		nPersone.addItem("Da 10 a 15 persone (+10.00€)");
		double costoPersone = ordinePersonalizzato.numerodipersone(nPersone);
		assertEquals(10.0, costoPersone, 0.01); // Assicurati che il costo sia uguale a 10.0
	}

	@Test
	public void testOccasione() {
		JComboBox<String> occasioni = new JComboBox<>();
		occasioni.addItem("Compleanno");
		String occasione = ordinePersonalizzato.occasione(occasioni);
		assertEquals("Compleanno", occasione);
	}

	@Test
	public void testDataConsegna() {
		JTextField date = new JTextField("12/12/2023");
		String data = ordinePersonalizzato.dataConsegna(date);
		assertEquals("12/12/2023", data);
	}

	@Test
	public void testTipoTorta() {
		JComboBox<Prodotto> catalogo = new JComboBox<>();
		Prodotto tortaSelezionata = new Prodotto("Cheesecake", 15.0);
		catalogo.setModel(new DefaultComboBoxModel<>(new Prodotto[] { tortaSelezionata }));

		Prodotto tipoTorta = ordinePersonalizzato.tipoTorta(catalogo);

		assertEquals(tortaSelezionata, tipoTorta);
	}

	@Test
	public void testPersoneStringa() {
		JComboBox<String> nPersone = new JComboBox<>();
		String personeSelezionate = "Da 10 a 15 persone (+10.00€)";
		nPersone.addItem(personeSelezionate);

		String persone = ordinePersonalizzato.personeStringa(nPersone);

		assertEquals(personeSelezionate, persone);
	}

}
