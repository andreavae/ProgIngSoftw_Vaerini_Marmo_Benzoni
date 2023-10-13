package model;

public class Pagamento {
	private String numeroCarta;
	private String dataScadenza;
	private Ordine ordine;

	// costruttore
	public Pagamento(Ordine ordine, String numeroCarta, String dataScadenza) {
		this.ordine = ordine;
		this.numeroCarta = numeroCarta;
		this.dataScadenza = dataScadenza;
	}

	// controlli per il pagamento
	public boolean processoPagamento(String umeroCarta, String dataScadenza, double saldo) {
		return isValidCard(numeroCarta) && isValidData(dataScadenza) && saldo > 0; // i dati della carta devono essere
																					// validi e il saldo ovvimante deve
																					// essere positivo
	}

	// verfica la correttezza del numero della carta
	private boolean isValidCard(String numeroCarta) {
		return numeroCarta.length() == 16;
	}

	// verifica che la carta non sia scaduta
	private boolean isValidData(String dataScadenza) {
		return dataScadenza.matches("\\d{2}/\\d{2}");
	}

	// restituisce il numero della carta
	public String getNumeroCarta() {
		return numeroCarta;
	}

	// restituisce la scadenza
	public String getDataScadenza() {
		return dataScadenza;
	}
}
