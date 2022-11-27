
# Git Hooks

Little project to show our understanding of git's hook system.

## Commits

Attention, your commits will have to follow this syntax:

```txt
<gitmoji1, gitmoji2...> (scope1, scope2...): Message
```
Exemple with [Gitmoji](https://gitmoji.dev/):
```txt
🎨, ⚡️ (dev, card): Add card to something
```

## Installation

To initialise the project with git, run this command in the local repository:

```bash
  git config core.hooksPath .hooks
```

    
## Running Tests

To run tests, run the following command:

```bash
  npm run test
```


## Documentation

### Git hooks list
- Commit: 
  - commit-msg: Run PreCommit.java and pass commit path to it.
  - PreCommit.java: Test the commit message against the defined schema (cf. Commits section).
- Pre-Push:
  - pre-push: Run PrePush.java.
  - PrePush.java: WIP.

### Class diagram

Class diagram of the solution:

```mermaid
classDiagram
    Bank ..> Client
    Account ..> Client
    Card ..> Account
    Loan ..> Account

    class Client{
        int id
        String name
        Strig password

        Client(String name, String password) Client
    }

    class Bank{
        int id
        String name
        List~Client~ clients
        List~Client~ connected

        Bank(int id, List~Client~) Bank
        login(int accountId, String password) bool
        logout(int clientId) bool
        giveLoan(Account account, int amount) Loan
    }

    class Account{
        int id
        Client client
        double balance
        List~Loan~ loans
        List~Card~ cards

        Account(Client client) Account
        createCard(int pinNumber) bool
        transfert(int accountId, int amount) bool
        deposit(int amount) bool
        takeout(int amount) bool
    }

    class Card{
        int cardNumber
        int pinNumber
        Account cardAccount

        Card(Account account, int pinNumber) Card
        deposit(int amount, int pinNumber) bool
        takeout(int amount, int pinNumber) bool
    }

    class Loan{
        int ID
        int AMOUNT
        double outstanding

        Loan(int amount) Loan
        pay(int amount) bool
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

