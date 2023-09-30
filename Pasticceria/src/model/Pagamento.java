package model;

public class Pagamento {
	private String numeroCarta;
	private String dataScadenza;

	public Pagamento(String numeroCarta, String dataScadenza) {
		this.numeroCarta = numeroCarta;
		this.dataScadenza = dataScadenza;
	}

	public boolean processoPagamento(String umeroCarta, String dataScadenza, double saldo) {
		return isValidCard(numeroCarta) && isValidData(dataScadenza) && saldo > 0;
	}

	private boolean isValidCard(String numeroCarta) {
		return numeroCarta.length() == 16;
	}

	private boolean isValidData(String dataScadenza) {
		return dataScadenza.matches("\\d{2}/\\d{2}");
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}
}
