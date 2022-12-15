import java.util.Random;
import java.util.UUID;

public class Card {
	final UUID uuid = UUID.randomUUID();
	Long cardNumber;
	int pinNumber;


	Card(int pinNumber) {
		this.cardNumber = 1000000000000000L + new Random().nextLong(9000000000000000L);
		this.pinNumber = pinNumber;
	}

	boolean deposit(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}

	boolean takeout(int amount, int pinNumberGiven) {
		return pinNumberGiven == pinNumber;
	}
}
