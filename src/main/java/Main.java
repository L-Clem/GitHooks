import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Création de 3 clients pour l'application
        Client client1 = new Client("Le Blanc", "Eloïse");
		Client client2 = new Client("Tromeur", "Chloé");
		Client client3 = new Client("Proust", "Lou");


        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank(1,"Cool bank"));
        banks.add(new Bank(2,"Evil bank"));
        banks.add(new Bank(3,"Normal bank"));
        Scanner scanner = new Scanner(System.in);

        banks.get(1).addClient(client1);
        banks.get(2).addClient(client2);
        banks.get(3).addClient(client3);

        System.out.println("Welcome to your banking app");

        System.out.println("Choose bank: ");
        banks.forEach(bank -> System.out.println(bank.name));

        String bankNameInput = "";
        String finalBankNameInput = bankNameInput;
        while(banks.stream().noneMatch(bank -> finalBankNameInput.equals(bank.name))) {
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