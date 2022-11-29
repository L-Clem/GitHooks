import java.util.concurrent.ThreadLocalRandom;

public class Loan {
    private final int ID;
    private final int AMOUNT;
    private double outstanding;

    Loan(int amount) {
        this.AMOUNT = amount;
        this.ID = ThreadLocalRandom.current().nextInt();
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
