import java.util.ArrayList;

public class Account {
    public int id;
    Client client;
    private double balance;
    ArrayList<Loan> loans;
    ArrayList<Card> cards;

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
        Card card = new Card(pinNumber);
        this.cards.add(card);
        return card;

    }
}
