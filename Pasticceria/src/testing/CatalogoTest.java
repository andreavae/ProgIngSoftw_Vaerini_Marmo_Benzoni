package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Catalogo;
import model.Prodotto;

public class CatalogoTest {
	private Catalogo catalogo;

	@Before
	public void setUp() {
		catalogo = Catalogo.getIstance(); // Ottieni l'istanza unica del catalogo
	}

	@Test
	public void testCatalogoNotNull() {
		// Verifica che l'istanza del catalogo non sia nulla
		assertNotNull(catalogo);
	}

	@Test
	public void testCatalogoSize() {
		List<Prodotto> prodotti = catalogo.getCatalogo();
		// Verifica che il catalogo contenga almeno un prodotto
		assertEquals(9, prodotti.size());
	}

	@Test
	public void testCatalogoContenuto() {
		List<Prodotto> prodotti = catalogo.getCatalogo();
		// Verifica il contenuto di alcuni prodotti nel catalogo
		assertEquals("Cheesecake", prodotti.get(0).getNome());
		assertEquals("Cubana", prodotti.get(1).getNome());
		assertEquals("Cream Tart", prodotti.get(2).getNome());
		assertEquals("Iris", prodotti.get(3).getNome());
		assertEquals("Mimosa", prodotti.get(4).getNome());
		assertEquals("Saint Honorè", prodotti.get(5).getNome());
		assertEquals("Sacher", prodotti.get(6).getNome());
		assertEquals("Setteveli", prodotti.get(7).getNome());
		assertEquals("Tiramisè", prodotti.get(8).getNome());
	}
}
