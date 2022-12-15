import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAddingClientoBankWhenHeIsNull() {
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> new Client(null));
    }

    @Test
    void testAddingClientoBankWhenHeIsPasswordIsNull(){
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> new Client("client1"));
    }

    @Test
    void testBankLogin() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom");
        Account account = new Account(client, "password");

        bank.register(account);
        boolean login = bank.login(account.uuid, "client1");
        assertTrue(login);
    }

    @Test
    void testBanklogout() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom");
        Account account = new Account(client, "password");

        bank.register(account);
        bank.login(account.uuid, "client1");

        assertTrue(bank.logout(account.uuid));
    }

    @Test
    void testGiveLoan() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom");
        Account account = new Account(client, "password");

        bank.register(account);
        bank.giveLoan(account, 150);

        assertEquals(account.balance, 150);
    }
}