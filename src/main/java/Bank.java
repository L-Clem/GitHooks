import java.util.ArrayList;

public class Bank {
    private int id;
    public String name;
    public ArrayList<Account> accounts;
    public ArrayList<Account> connected;

    Bank(int id, String name){
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<Account>();
        this.connected = new ArrayList<Account>();
    }

    public Account login(int accountId, String password){
        for(int i=0; i < this.connected.size(); i++){
            if (this.connected.contains(this.connected.get(i))){
                return this.connected.get(i);
            }
        }

        for (Account account : this.accounts) {
            if (account.id == accountId && account.client.password.equals(password)) {
                this.connected.add(account);
                return account;
            }
        }
        return null;
    }

    public boolean logout(int clientId){
        for (int i =0; i < this.connected.size(); i++){
            if (this.connected.get(i).client.idClient == clientId){
                this.connected.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean giveLoan(Account account, int amount){
        for (int z = 0; z < this.accounts.size(); z++){
            if (this.connected.get(z).client.idClient == account.client.idClient){
                this.connected.get(z).balance = amount;
                return this.connected.get(z).loans.add(new Loan(amount));
            }
        }
        return false;
    }

    public void addClient(Client client) throws Exception {
        Account account = new Account(client);
        if (account.client.name != null || account.client.password != null) {
            this.accounts.add(account);
        }else{
            throw new Exception("The client name or password is null !");
        }
    }
}
