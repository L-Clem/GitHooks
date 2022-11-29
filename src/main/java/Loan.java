import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Loan {
    final UUID uuid = UUID.randomUUID();
    final int amount;
    double outstanding;

    Loan(int amount) {
        this.amount = amount;
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
