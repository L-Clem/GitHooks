import java.util.concurrent.ThreadLocalRandom;

public class Loan {
    private final int id;
    private final int amount;
    private double outstanding;

    Loan(int amount) {
        this.amount = amount;
        this.id = ThreadLocalRandom.current().nextInt();
        this.outstanding = amount;
    }

    boolean pay(Account account, int amount) {
        if (account.balance < amount) {
            return false;
        }

        account.balance -= amount;
        this.outstanding -= amount;

        return true;
    }
}
