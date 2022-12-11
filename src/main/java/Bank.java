import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    UUID uuid;
    String name;
    public ArrayList<Account> accounts;
    public ArrayList<Account> connected;
    public static ArrayList<Bank> banks = new ArrayList<>();;

    Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.connected = new ArrayList<>();
        Bank.banks.add(this);
    }

    boolean login(UUID accountUUID, String password) {
        for (int i = 0; i < this.connected.size(); i++) {
            if (this.connected.contains(this.connected.get(i))) {
                return true;
            }
        }

        for (Account account : this.accounts) {
            if (account.uuid.equals(accountUUID) && account.password.equals(password)) {
                System.out.println();
                this.connected.add(account);
                return true;
            }
        }
        return false;
    }

    boolean logout(UUID clientUUID) {
        for (int i = 0; i < this.connected.size(); i++) {
            if (this.connected.get(i).client.uuid.equals(clientUUID)) {
                this.connected.remove(i);
                return true;
            }
        }
        return false;
    }

    void giveLoan(Account account, int amount) {
        for (int z = 0; z < this.accounts.size(); z++) {
            if (this.accounts.get(z).uuid == account.uuid) {
                this.accounts.get(z).balance += amount;
                this.accounts.get(z).loans.add(new Loan(amount));
            }
        }
    }

    Client getCLient(UUID uuid) {
        for (Account account : this.accounts) {
            if (account.uuid.equals(uuid)) {
                return account.client;
            }
        }
        return null;
    }

    Account getAccount(Client client) {
        for (Account account : this.accounts) {
            if (account.client.uuid.equals(client.uuid)) {
                return account;
            }
        }
        return null;
    }

    void register(Account account) throws Exception {
        this.accounts.add(account);
    }
}
