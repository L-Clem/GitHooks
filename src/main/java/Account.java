import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
    private final UUID uuid = UUID.randomUUID();
    Client client;
    public double balance;
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

    public boolean takeout( int amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(int accountId, int amount) {
        if (amount > balance) {
            return false;
        }

        return true;
    }

    public Card createCard(int pinNumber) {
        Card card = new Card(this.id, pinNumber);
        this.cards.add(card);
        return card;
    }
}
