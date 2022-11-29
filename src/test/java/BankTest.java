import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAddingClientoBankWhenHeIsNull() {
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> {
            Client client = new Client(1, null, null);
            bank.addClient(client);
        });
    }

    @Test
    void testAddingClientoBankWhenHeIsPasswordIsNull(){
        Bank bank = new Bank("Test");
        assertThrows(Exception.class, () -> new Client(1, "client1", null));
    }

    @Test
    void testBankLogin() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client(1, "Mon nom", "client1");
        Account account = new Account(client);

        bank.addClient(client);

        Account userInfo = bank.login(account.id, "client1");

        assertNotEquals(userInfo, null);
    }

    @Test
    void testBanklogout() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client(1, "Mon nom", "client1");
        Account account = new Account(client);

        bank.addClient(client);
        bank.login(account.id, "client1");

        assertTrue(bank.logout(client.idClient));
    }

    @Test
    void testGiveLoan() throws Exception {
        Bank bank = new Bank("Test");
        Client client = new Client(1, "Mon nom", "client1");
        Account account = new Account(client);

        bank.addClient(client);
        Account userInfo = bank.login(account.id, "client1");

        bank.giveLoan(userInfo, 150);
        assertEquals(bank.connected.get(0).balance, 150);
    }
}