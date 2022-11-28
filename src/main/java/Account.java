import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
    public int id;
    Client client;
    double balance;
    ArrayList<Loan> loans;
    ArrayList<Card> cards;

    public Account(Client client) {
        this.id = 1;
        this.client = client;
        this.balance = 0;
        this.loans = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public boolean deposit( int amount) {
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
        return true;
    }

    public Card createCard(int pinNumber) {
        Card card = new Card(this, pinNumber);
        this.cards.add(card);
        return card;

    }
}
