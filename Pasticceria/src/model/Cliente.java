
package model;

public class Cliente {

	public String IDcliente;
	public String Password;
	public String Nome;
	public String Cognome;
	public int NumOrdine;
	public boolean Premium;

	public Cliente(String ID, String nome, String cognome) {
		this.IDcliente = ID;
		this.Nome = nome;
		this.Cognome = cognome;

	}

	public String getIDcliente() {
		return IDcliente;
	}

	public String getPassword() {
		return Password;
	}

	public String getNome() {
		return Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public int getNumOrdine() {
		return NumOrdine;
	}

	public Boolean getPremium() {
		return Premium;
	}

	public void setIDcliente(String IDcliente) {
		this.IDcliente = IDcliente;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}

	public void setNumOrdine(int NumOrdine) {
		this.NumOrdine = NumOrdine;
	}

	public void setPremium(Boolean Premium) {
		this.Premium = Premium;
	}

	public void NuovoOrdine() {

		NumOrdine++;
		if (NumOrdine == 10) {
			ClientePremium cp = new ClientePremium(IDcliente, Nome, Cognome);
		}
	}

	public void VisualizzaOrdine() {

	}

	public void VisualizzaCatalogo() {

	}

	public void DefinisciScadenza() {
	}

	public void Login() {

	}

}