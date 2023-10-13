package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Ordine;
import model.Pagamento;
import model.User;

public class PagamentoTest {
	private Pagamento pagamento;
	private Ordine ordine;

	@Test
	public void testOrdineValido() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		boolean flagOrdine = ordine.isOrderValid(ordine, utente, 12);
		assertEquals(true, flagOrdine);
	}

	@Test
	public void testProcessoPagamentoValido() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		String numeroCarta = "1234567890123456";
		String dataScadenza = "12/23";
		Pagamento pagamento = new Pagamento(ordine, numeroCarta, dataScadenza);
		boolean flagPagamento = pagamento.processoPagamento(numeroCarta, dataScadenza, 1000);
		assertEquals(true, flagPagamento);
	}

	@Test
	public void testProcessoPagamentoInvalido_NumeroCartaNonValido() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		String numeroCarta = "123456789012345";
		String dataScadenza = "12/23";
		Pagamento pagamento = new Pagamento(ordine, numeroCarta, dataScadenza);
		boolean flagPagamento = pagamento.processoPagamento(numeroCarta, dataScadenza, 1000);
		assertEquals(false, flagPagamento);
	}

	@Test
	public void testProcessoPagamentoInvalido_DataScadenzaNonValida() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		String numeroCarta = "123456789012346";
		String dataScadenza = "12-23";
		Pagamento pagamento = new Pagamento(ordine, numeroCarta, dataScadenza);
		boolean flagPagamento = pagamento.processoPagamento(numeroCarta, dataScadenza, 1000);
		assertEquals(false, flagPagamento);

	}

	@Test
	public void testGetNumeroCarta() {
		User utente = new User("admin", "admin");
		Ordine ordine = new Ordine(utente);
		String numeroCarta = "1234567890123456";
		String dataScadenza = "12/23";
		Pagamento pagamento = new Pagamento(ordine, numeroCarta, dataScadenza);
		assertEquals("1234567890123456", pagamento.getNumeroCarta());
	}

}
