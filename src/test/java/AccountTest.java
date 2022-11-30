import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Client client;
    Account account;

    @BeforeEach
    public void init() throws Exception {
        client = new Client("test-client", "test-password");
        account = new Account(client);
    }

    @Test
    void deposit() {
        account.deposit(80);
        assertEquals(80, account.balance);
    }

    @Test
    void takeout() throws Exception {
        Client client = new Client("test-client", "test-password");
        Account account = new Account(client);
        account.balance = 100;

        assertTrue(account.takeout(80));
        assertEquals(20, account.balance);

        assertTrue(account.takeout(20));
        assertEquals(0, account.balance);
    }

    @Test
    void takeoutMoreThanCurrentBalance() throws Exception {
        Client client = new Client("test-client", "test-password");
        Account account = new Account(client);
        account.balance = 70;

        assertFalse(account.takeout(80));
        assertEquals(70, account.balance);
    }

    @Test
    void createCard() throws Exception {
        Client client = new Client("test-client", "test-password");
        Account account = new Account(client);
        account.createCard(6812);
        assertEquals(6812, account.cards.get(0).pinNumber);
        assertEquals(account.uuid, account.cards.get(0).idAccount);
    }
}