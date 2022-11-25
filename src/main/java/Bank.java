public class Bank {
    int id;
    List<Client> clients;
    List<Client> connected;

    Bank(int id, List<Client> clients){
        this.id = id;
        this.clients = clients;
    }

    public boolean login(int accountId, String password){
        for (int i =0; i < this.clients.size(); i++){
            if (this.clients.get(i).id == clientId){
                this.clients.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean logout(int clientId){
        for (int i =0; i < this.connected.size(); i++){
            if (this.connected.get(i).id == clientId){
                this.connected.remove(i);
                return true;
            }
        }
        return false;
    }

    public Loan giveLoan(Account account, int amount){
        return account.loans.add(Loan(amount));
    }
}
