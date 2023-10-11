
package model;

public class ClienteStandard extends User {
	private boolean flagPremium;

	public ClienteStandard(String username, String password) {
		super(username, password);
		this.flagPremium = false;
	}

	public boolean isFlagPremium() {
		return flagPremium;
	}

	public void setFlagPremium(boolean flagPremium) {
		this.flagPremium = flagPremium;
	}

}