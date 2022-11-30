import java.util.UUID;

public class Card {
	// Variables
	int pinNumber;
	UUID idAccount;

	// Constructeur
	Card(UUID idAccount, int pinNumber) {
		this.idAccount = idAccount;
		this.pinNumber = pinNumber;
	}

	// Méthode de dépôt
	// faire valider le depot
	public boolean deposit(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}

	// Méthode de retrait
	public boolean takeout(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}
}
