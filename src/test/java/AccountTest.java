import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Client client;
    Account account;

    @BeforeEach
    public void init() throws Exception {
        Bank bank = new Bank("test-bank");
        client = new Client("test-client");
        account = new Account(client, "test-password");
        bank.register(account);
    }

    @Test
    void accountWithNullPassword() {
        assertThrows(Exception.class, () -> new Account(client, null));
    }

    @Test
    void deposit() {
        account.deposit(80);
        assertEquals(80, account.balance);
    }

    @Test
    void takeout() {
        account.balance = 100;

        assertTrue(account.takeout(80));
        assertEquals(20, account.balance);

        assertTrue(account.takeout(20));
        assertEquals(0, account.balance);
    }

    @Test
    void takeoutMoreThanCurrentBalance() throws Exception {
        account.balance = 70;

        assertFalse(account.takeout(80));
        assertEquals(70, account.balance);
    }

    @Test
    void transfer() throws Exception {
        Client client2 = new Client("test-client");
        Account account2 = new Account(client2, "test-password");
        Bank bank2 = new Bank("test-bank-2");
        bank2.register(account2);
        account.balance = 1000;
        account2.balance = 200;

        assertTrue(account.transfer(account2.uuid, 333));

        assertEquals(667, account.balance);
        assertEquals(533, account2.balance);
    }

    @Test
    void transferMoreThanCurrentBalance() throws Exception {
        Client client2 = new Client("test-client");
        Account account2 = new Account(client2, "test-password");
        Bank bank2 = new Bank("test-bank-2");
        bank2.register(account2);
        account.balance = 2;
        account2.balance = 200;

        assertFalse(account.transfer(account2.uuid, 20));

        assertEquals(2, account.balance);
        assertEquals(200, account2.balance);
    }

    @Test
    void transferToNonExistentAccount() throws Exception {
        account.balance = 20;
        account.transfer(UUID.randomUUID(), 20);

        assertEquals(20, account.balance);
    }

    @Test
    void createCard() {
        account.createCard(6812);
        assertEquals(6812, account.cards.get(0).pinNumber);
    }
}