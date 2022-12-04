
# Git Hooks

Little project to show our understanding of git's hooks system.

The project isn't runing with a database in mind, so the classes tries to reflect what it's relational DB would have been.


## Documentation

### Installation

To initialise the git hooks of the project, run this command in the local repository's root:

```bash
  git config core.hooksPath .hooks
```

### Git hooks list
- Commit: 
  - `commit-msg`: Run PreCommit.java and pass commit path to it.
  - `PreCommit.java`: Test the commit message against the defined schema (cf. Commits section).
- Pre-Push:
  - `pre-push`: Build classes and then run `PrePush.java`.
  - `PrePush.java`: Verify JUnit5 tests.

### Commits

⚠️ Attention, your commits will have to follow this syntax:

```txt
<gitmoji1, gitmoji2...> (scope1, scope2...): Message
```
Exemple with [Gitmoji](https://gitmoji.dev/):
```txt
🎨, ⚡️ (dev, card): Add card to something
```

### Running Tests

To run tests, run the following commands:

```bash
  find [pathToProject]/src -name "*.java" > [pathToProject]/.hooks/sources.txt
  javac -d [pathToProject]/target -cp target:[pathToProject]/.hooks/junit-platform-console-standalone-1.9.1.jar @[pathToProject]/.hooks/sources.txt
  java -jar [pathToProject]/.hooks/junit-platform-console-standalone-1.9.1.jar --class-path [pathToProject]/target --scan-class-path
```

### Class diagram

Class diagram of the solution:

```mermaid
classDiagram
    Bank ..> Client
    Account ..> Client
    Card ..> Account
    Loan ..> Account

    class Client{
        ~UUID uuid
        ~String name
        ~String password

        ~Client(String name, String password) Client
    }

    class Bank{
        ~UUID uuid
        ~String name
        ~ArrayList~Account~ accounts
        ~ArrayList~Account~ connected
        ~ArrayList~Banks~ banks$

        ~Bank(String name) Bank
        ~login(UUID accountUUId, String password) account
        ~logout(UUIS clientUUID) boolean
        ~giveLoan(Account account, int amount)
        ~addAccount(Account account)
    }

    class Account{
        ~UUID uuid
        ~Client client
        ~double balance
        ~ArrayList~Loan~ loans
        ~ArrayList~Card~ cards

        ~Account(Client client) Account
        ~createCard(int pinNumber) boolean
        ~deposit(int amount) boolean
        ~takeout(int amount) boolean
        ~transfert(UUID accountUUID, int amount) boolean
        ~createCard(int pinNumber) Card
    }

    class Card{
        ~UUID uuid
        ~String cardNumber
        ~int pinNumber

        ~Card(int pinNumber) Card
        ~deposit(int amount, int pinNumberGiven) boolean
        ~takeout(int amount, int pinNumberGiven) boolean
    }

    class Loan{
        ~UUID uuid
        ~int amount
        ~double outstanding

        ~Loan(int amount) Loan
        ~pay(Account account, int amount) boolean
    }
```

## Screenshots
Screenshot of the interface:

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


## Authors

- [@Anna TYLKOWSKA](https://www.github.com/annaty)
- [@Clément LO-CASCIO](https://www.github.com/ClemLcs)
- [@Eloise LE BLANC](https://www.github.com/eloiseLBC)
- [@Clément LAFON](https://www.github.com/L-Clem)

