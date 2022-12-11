import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Bank.banks.get(0).register(account1);
        Bank.banks.get(1).register(account2);
        Bank.banks.get(2).register(account3);

        System.out.println("Welcome to your banking app");

        String answer = "";
        Bank chosenBank = null;

        while (true) {
            System.out.println("Choose bank: ");
            Bank.banks.forEach(bank -> System.out.println('\t' + bank.name));
            answer = input.readLine();
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

        Account account = null;
        while (account == null) {
             account = loginOrRegister(input, chosenBank);
        }

        while (true) {
            afterLogin(input, chosenBank, account);
        }
    }

    static Account loginOrRegister(BufferedReader reader, Bank chosenBank) throws Exception {
        String answer;
        Account account = null;

        System.out.println("What would you like to do? (use menu item numbers for quick select)");
        System.out.println("\t 1. Log in to your account at the " + chosenBank.name);
        System.out.println("\t 2. Open an account at the " + chosenBank.name);
        System.out.println("\t 3. Quit");
        answer = reader.readLine();

        switch (answer) {
            case "1" -> {
                System.out.println("Login");
                System.out.print("\tClient number: ");
                String uuid = reader.readLine();
                System.out.print("\tPassword: ");
                String password = reader.readLine();
                if (chosenBank.login(UUID.fromString(uuid), password)) {
                    System.out.println("\tLogin successful");
                    account = chosenBank.getAccount(chosenBank.getCLient(UUID.fromString(uuid)));
                    return account;
                } else {
                    System.out.println("\tIncorrect username or password");
                }
            }
            case "2" -> {
                System.out.println("Register");
                System.out.println("\tWhat is your full name?");
                String name = reader.readLine();
                System.out.println("\tWhat would you like your password to be?");
                String newPassword = reader.readLine();
                Client client = new Client(name);
                try {
                    account = new Account(client, newPassword);
                    chosenBank.register(account);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\tRegistration successful! Your account number is: " + account.uuid);
                System.out.println("\tUse it along with your password to login");
            }
            case "3" -> System.exit(3);
            default -> System.out.println(answer + " is not an option");
        }
        return null;
    }

    static void afterLogin(BufferedReader reader, Bank chosenBank, Account account) throws IOException {
        String[] menu = {
            "1. Check balance",
            "2. Deposit money",
            "3. Take out money",
            "4. Transfer money",
            "5. List cards",
            "6. Get a new card",
            "7. Take a loan",
            "8. Log out and quit"
        };
        System.out.println("What would you like to do, " + account.client.name + "?");
        for (String s : menu) {
            System.out.println("\t" + s);
        }
        System.out.println("Use menu item numbers for quick select.");
        String answer = reader.readLine();
        switch (answer) {
            case "1":
                System.out.println(menu[0]);
                System.out.println("Your current balance is: " + account.balance + " euro.");
                break;
            case "2":
                System.out.println(menu[1]);
                System.out.println("Input the amount you want to deposit");
                String amount = reader.readLine();
                if (account.deposit(Integer.parseInt(amount))) {
                    System.out.println(amount + " euro deposited successfully.");
                } else {
                    System.out.println("Could not deposit " + amount + ". Please try again");
                }
                break;
            case "3":
                System.out.println(menu[2]);
                System.out.println("Input the amount you want to take out");
                String takeout = reader.readLine();
                if (account.deposit(Integer.parseInt(takeout))) {
                    System.out.println("You've taken out " + takeout + " euro" );
                } else {
                    System.out.println("Not enough funds. Could not take out" + takeout + " euro" );
                }
                break;
            case "4":
                System.out.println(menu[3]);
                System.out.println("Input the amount you want to transfer");
                String transfer = reader.readLine();
                System.out.println("Input the number of the destination account");
                String destination = reader.readLine();

                if (account.transfer(UUID.fromString(destination), Integer.parseInt(transfer))) {
                    System.out.println("Transfer successful.");
                    System.out.println("Current balance: " + account.balance);
                } else {
                    System.out.println("Transfer unsuccessful");
                }
                break;
            case "5":
                System.out.println(menu[4]);
                for (int i = 0; i < account.cards.size(); i++) {
                    System.out.println(account.cards.get(i).cardNumber);
                }
                break;
            case "6":
                System.out.println(menu[5]);
                System.out.println("Input a pin number you wish to use for your new card");
                String pin = reader.readLine();
                Card newCard = account.createCard(Integer.parseInt(pin));
                System.out.println("\tNew card with number " + newCard.cardNumber + " created successfully.");
                break;
            case "7":
                System.out.println(menu[6]);
                System.out.println("Input the amount of money you'd like to borrow:");
                String loan = reader.readLine();
                chosenBank.giveLoan(account, Integer.parseInt(loan));
                System.out.println("Loan taken successfully. New account balance: " + account.balance);
                System.out.println("By taking this loan you agree to repay it fully within a reasonable amount of time!");
                break;
            case "8":
                System.out.println("Thank you for using our app! See you next time");
                System.exit(0);
        }
    }
}