
# Git Hooks

Little project to show our understanding of git's hook system.


## Installation

To initialise the project with git, run this command in the local repository :

```bash
  git config core.hooksPath .hooks
```

    
## Running Tests

To run tests, run the following command :

```bash
  npm run test
```


## Documentation

Class diagram of the solution.

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
        List~Client~ clients
        List~Client~ connected

        Bank(int id, List~Client~) Bank
        login(int accountId, String password) boolean
        logout(int clientId) boolean
        giveLoan(Account account, int amount) Loan
    }

    class Account{
        int id
        Client client
        double balance
        List~Loan~ loans
        List~Card~ cards

        Account(Client client) Account
        createCard(int pinNumber) boolean
        transfert(int accountId, int amount) boolean
        deposit(int amount) boolean
        takeout(int amount) boolean
    }

    class Card{
        int cardNumber
        int pinNumber
        Account cardAccount

        Card(Account account, int pinNumber) Card
        deposit(int amount, int pinNumber) boolean
        takeout(int amount, int pinNumber) boolean
    }

    class Loan{
        -int id
        -int amount
        -double outstanding

        ~Loan(int amount) Loan
        ~pay(int amount) boolean
    }
```

## Screenshots
Screenshot of the interface :

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


## Authors

- [@Anna TYLKOWSKA](https://www.github.com/annaty)
- [@Clément LO-CASCIO](https://www.github.com/ClemLcs)
- [@Eloise LE BLANC](https://www.github.com/eloiseLBC)
- [@Clément LAFON](https://www.github.com/L-Clem)

