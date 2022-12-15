import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    final UUID uuid = UUID.randomUUID();
    @NotNull
    String password;
    Client client;
    double balance;
    ArrayList<Loan> loans;
    ArrayList<Card> cards;

    Account(Client client, @NotNull String password) {
        this.client = client;
        this.password = password;
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

    boolean transfer(UUID uuid, int amount) {
        boolean transferred = false;
        if (amount <= balance) {
            for (int i = 0; i < Bank.banks.size(); i++) {
                for (int j = 0; j < Bank.banks.get(i).accounts.size(); j++) {
                    if(Bank.banks.get(i).accounts.get(j).uuid.equals(uuid)) {
                        this.balance -= amount;
                        Bank.banks.get(i).accounts.get(j).balance += amount;
                        transferred = true;
                    } else {
                        System.out.println("Account with given account number doesn't exist");
                    }
                }
            }
        } else {
            System.out.println("Not enough funds");
        }
        return transferred;
    }

    Card createCard(int pinNumber) {
        Card card = new Card(pinNumber);
        this.cards.add(card);
        return card;
    }
}
