import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAddingClientoBankWhenHeIsNull() {
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> new Client(null, null));
    }

    @Test
    void testAddingClientoBankWhenHeIsPasswordIsNull(){
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> new Client("client1", null));
    }

    @Test
    void testBankLogin() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom", "client1");
        Account account = new Account(client);

        bank.addAccount(account);

        Account userInfo = bank.login(account.uuid, "client1");

        assertNotEquals(userInfo, null);
    }

    @Test
    void testBanklogout() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom", "client1");
        Account account = new Account(client);

        bank.addAccount(account);
        bank.login(account.uuid, "client1");

        assertTrue(bank.logout(client.uuid));
    }

    @Test
    void testGiveLoan() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client("Mon nom", "client1");
        Account account = new Account(client);

        bank.addAccount(account);
        Account userInfo = bank.login(account.uuid, "client1");

        bank.giveLoan(userInfo, 150);
        assertEquals(userInfo.balance, 150);
    }
}