import java.util.ArrayList;

public class Bank {
    public String name;
    public ArrayList<Account> accounts;
    public ArrayList<Account> connected;

    Bank(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
        this.connected = new ArrayList<>();
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

    public void giveLoan(Account account, int amount){
        for (int z = 0; z < this.accounts.size(); z++){
            if (this.connected.get(z).client.idClient == account.client.idClient){
                this.connected.get(z).balance = amount;
                this.connected.get(z).loans.add(new Loan(amount));
            }
        }
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
