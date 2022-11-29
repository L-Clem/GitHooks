import java.util.ArrayList;
import java.util.UUID;

public class Account {
    final UUID uuid = UUID.randomUUID();
    Client client;
    double balance;
    ArrayList<Loan> loans;
    ArrayList<Card> cards;

    public Account(Client client) {
        this.client = client;
        this.balance = 0;
        this.loans = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public boolean deposit(int amount) {
        if (amount < 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean takeout(int amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(int accountId, int amount) {
        return !(amount > balance);
    }

    public Card createCard(int pinNumber) {
        Card card = new Card(this.uuid, pinNumber);
        this.cards.add(card);
        return card;
    }
}
