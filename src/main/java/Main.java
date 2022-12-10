import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws Exception {
        Client client1 = new Client("Eloïse Le Blanc");
        Client client2 = new Client("Chloé Tromeur");
        Client client3 = new Client("Lou Proust");

        Account account1 = new Account(client1, "pw123");
        Account account2 = new Account(client2, "very safe");
        Account account3 = new Account(client3, "very mucho safe");

        new Bank("Cool bank");
        new Bank("Evil bank");
        new Bank("Normal bank");
        Scanner scanner = new Scanner(System.in);

        Bank.banks.get(0).register(account1);
        Bank.banks.get(1).register(account2);
        Bank.banks.get(2).register(account3);

        System.out.println("Welcome to your banking app");

        String answer = "";
        Bank chosenBank = null;

        while (true) {
            System.out.println("Choose bank: ");
            Bank.banks.forEach(bank -> System.out.println('\t' + bank.name));
            answer = scanner.nextLine();
            for (int i = 0; i < Bank.banks.size(); i++) {
                if (Objects.equals(Bank.banks.get(i).name, answer)) {
                    chosenBank = Bank.banks.get(i);
                    break;
                }
            }
            if (chosenBank != null) {
                System.out.println("You chose the " + chosenBank.name);
                break;
            }
            System.out.println("The bank you chose is not in our database");
        }

        Account account = loginOrRegister(scanner, chosenBank);


//        String[] menu = {
//                "1. Deposit money",
//                "2. Take out money",
//                "3. Transfer money",
//                "4. List cards",
//                "5. Get a new card",
//                "6. Take a loan",
//                "7. Log out and quit"
//        };

    }

    static Account loginOrRegister(Scanner scanner, Bank chosenBank) throws Exception {
        String answer;
        Account account = null;

        System.out.println("What would you like to do? (use menu item numbers for quick select)");
        System.out.println("\t 1. Log in to your account at the " + chosenBank.name);
        System.out.println("\t 2. Open an account at the " + chosenBank.name);
        System.out.println("\t 3. Quit");
        answer = scanner.nextLine();

        switch(answer) {
            case "1":
                System.out.println("Login");
                System.out.print("\tClient number: ");
                String uuid = scanner.next();
                System.out.print("\tPassword: ");
                String password = scanner.next();

                if (chosenBank.login(UUID.fromString(uuid), password)) {
                    System.out.println("Login successful");
                    account = chosenBank.getAccount(chosenBank.getCLient(UUID.fromString(uuid)));
                    return account;
                } else {
                    System.out.println("Incorrect username or password");
                    answer = null;
                    loginOrRegister(scanner, chosenBank);
                }
            case "2":
                System.out.println("Register");
                System.out.println("\tWhat is your full name?");
                String name = scanner.nextLine();
                System.out.println("\tWhat would you like your password to be?");
                String newPassword = scanner.nextLine();
                Client client = new Client(name);
                try {
                    account = new Account(client, newPassword);
                    chosenBank.register(account);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Registration successful! Your account number is: " + account.uuid);
                System.out.println("Use it along with your password to login");
                loginOrRegister(scanner, chosenBank);
            case "3":
                System.exit(0);
            default:
                System.out.println(answer + " is not an option");
                loginOrRegister(scanner, chosenBank);
        }
        return null;
    }
}