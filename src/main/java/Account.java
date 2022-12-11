import java.util.ArrayList;
import java.util.UUID;

public class Account {
    final UUID uuid = UUID.randomUUID();
    Client client;
    double balance;
    ArrayList<Loan> loans;
    ArrayList<Card> cards;

    Account(Client client) {
        this.client = client;
        this.balance = 0;
        this.loans = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    boolean deposit(int amount) {
        if (amount < 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    boolean takeout(int amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    boolean transfer(int accountId, int amount) {
        return !(amount > balance);
    }

    Card createCard(int pinNumber) {
        Card card = new Card(pinNumber);
        this.cards.add(card);
        return card;
    }
}
