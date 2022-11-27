import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank(1, "Cool bank", new ArrayList<Client>()));
        banks.add(new Bank(2, "Evil bank", new ArrayList<Client>()));
        banks.add(new Bank(3, "Normal bank", new ArrayList<Client>()));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your banking app");

        System.out.println("Choose bank: ");
        banks.forEach(bank -> System.out.println(bank.name));

        String bankNameInput = "";
        while(banks.stream().noneMatch(bank -> bankNameInput.equals(bank.name))) {
            bankNameInput = scanner.nextLine();
            if (banks.stream().filter(b -> Objects.equals(b.name, bankNameInput)).toArray().length > 0) {
                System.out.println("You chose " + bankNameInput);
            } else {
                System.out.println("The bank you chose is not in our database");
            }
        }

        // login

        // show bank account balance and possible actions when logged in
    }
}