import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void deposit() {
        Client client = new Client("test-client", "test-password");
        Account account = new Account(client);
        account.deposit(80);

        assertEquals(80, account.balance);
    }
}