
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
        -UUID uuid
        String name
        Strig password

        Client(String name, String password) Client
    }

    class Bank{
        -UUID uuid
        ArrayList~Client~ clients
        ArrayqList~Client~ connected

        Bank(int id, List~Client~) Bank
        login(int accountId, String password) boolean
        logout(int clientId) boolean
        giveLoan(Account account, int amount) Loan
    }

    class Account{
        -UUID uuid
        Client client
        double balance
        ArrayList~Loan~ loans
        ArrayList~Card~ cards

        Account(Client client) Account
        createCard(int pinNumber) boolean
        transfert(int accountId, int amount) boolean
        deposit(int amount) boolean
        takeout(int amount) boolean
    }

    class Card{
        -UUID uuid
        int cardNumber
        int pinNumber
        Account account

        Card(Account account, int pinNumber) Card
        deposit(int amount, int pinNumber) boolean
        takeout(int amount, int pinNumber) boolean
    }

    class Loan{
        -UUID uuid
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

