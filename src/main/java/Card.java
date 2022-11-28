
public class Card {
	// Variables
	int idCard;
	int cardNumber;
	int pinNumber;
	Account accountId;
	
	// Constructeur
	Card(Account account, int pinNumber){
		this.accountId = account;
		this.pinNumber = pinNumber;
	}
	
	// Méthode de dépôt
	// faire valider le depot
	public boolean deposit(int amount, int pinNumberGiven) {
		boolean validateDeposit = true ;
		if (pinNumberGiven != pinNumber) {
			validateDeposit = false;
		}
		return validateDeposit;
	}
	
	// Méthode de retrait
	public boolean takeout(int amount, int pinNumberGiven) {
		boolean validateTakeOut = true ;
		if (pinNumberGiven != pinNumber) {
			validateTakeOut = false;
		}
		return validateTakeOut;
	}
}
