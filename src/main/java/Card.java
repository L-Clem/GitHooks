import java.util.UUID;

public class Card {
	final UUID uuid = UUID.randomUUID();
	String cardNumber;
	int pinNumber;


	Card(int pinNumber) {
		//TODO autogenerated cardNumber >16c
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
	}

	// Méthode de dépôt
	// faire valider le depot
	boolean deposit(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}

	// Méthode de retrait
	boolean takeout(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}
}
