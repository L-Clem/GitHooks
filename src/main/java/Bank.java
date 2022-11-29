import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private final UUID uuid = UUID.randomUUID();
    public String name;
    private ArrayList<Account> accounts;
    private ArrayList<Client> connected;

    Bank(String name){
        this.name = name;
    }

    public boolean login(int accountId, String password){
        for(int i=0; i < this.connected.size(); i++){
            if (this.connected.contains(this.connected.get(i))){
                return true;
            }
        }

        for (Account account : this.accounts) {
            if (account.id == accountId && account.client.password.equals(password)) {
                this.connected.add(account.client);
                return true;
            }
        }
        return false;
    }

    public boolean logout(int clientId){
        for (int i =0; i < this.connected.size(); i++){
            if (this.connected.get(i).idClient == clientId){
                this.connected.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean giveLoan(Account account, int amount){
        return account.loans.add(new Loan(amount));
    }

    public void addClient(Client client) {
        this.accounts.add(new Account(client));
    }
}
