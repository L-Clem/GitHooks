import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Création de 3 clients pour l'application
        Client client1 = new Client("Le Blanc", "Eloïse");
        Client client2 = new Client("Tromeur", "Chloé");
        Client client3 = new Client("Proust", "Lou");

        // Création des 3 comptes
        Account account1 = new Account(client1);
        Account account2 = new Account(client2);
        Account account3 = new Account(client3);

        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank("Cool bank"));
        banks.add(new Bank("Evil bank"));
        banks.add(new Bank("Normal bank"));
        Scanner scanner = new Scanner(System.in);

        banks.get(1).addAccount(account1);
        banks.get(2).addAccount(account2);
        banks.get(3).addAccount(account3);

        System.out.println("Welcome to your banking app");

        System.out.println("Choose bank: ");
        banks.forEach(bank -> System.out.println(bank.name));

        String bankNameInput = "";
        String finalBankNameInput = bankNameInput;
        while (banks.stream().noneMatch(bank -> finalBankNameInput.equals(bank.name))) {
            bankNameInput = scanner.nextLine();
            String finalBankNameInput1 = bankNameInput;
            if (banks.stream().filter(b -> Objects.equals(b.name, finalBankNameInput1)).toArray().length > 0) {
                System.out.println("You chose " + finalBankNameInput);
            } else {
                System.out.println("The bank you chose is not in our database");
            }
        }


        // login

        // show bank account balance and possible actions when logged in

        // takeout money
    }
}