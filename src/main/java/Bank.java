import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    public String name;
    public ArrayList<Account> accounts;
    public ArrayList<Account> connected;

    Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.connected = new ArrayList<>();
    }

    public Account login(UUID accountId, String password) {
        for (int i = 0; i < this.connected.size(); i++) {
            if (this.connected.contains(this.connected.get(i))) {
                return this.connected.get(i);
            }
        }

        for (Account account : this.accounts) {
            if (account.uuid == accountId && account.client.password.equals(password)) {
                this.connected.add(account);
                return account;
            }
        }
        return null;
    }

    public boolean logout(UUID clientUUID) {
        for (int i = 0; i < this.connected.size(); i++) {
            if (this.connected.get(i).client.uuid.equals(clientUUID)) {
                this.connected.remove(i);
                return true;
            }
        }
        return false;
    }

    public void giveLoan(Account account, int amount) {
        for (int z = 0; z < this.accounts.size(); z++) {
            if (this.connected.get(z).uuid == account.uuid) {
                this.connected.get(z).balance = amount;
                this.connected.get(z).loans.add(new Loan(amount));
            }
        }
    }

    public void addAccount(Account account) throws Exception {
        this.accounts.add(account);
    }
}
