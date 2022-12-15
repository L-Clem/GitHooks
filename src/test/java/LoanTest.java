import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanTest {
	Account account;

	@BeforeEach
	void init() throws Exception {
		Client client = new Client("Client");
		account = new Account(client, "password");
		account.balance = 100000;
	}

	@Test
	public void testCreateLoan() {
		Loan loan = new Loan(100000);
		Assertions.assertEquals(loan.amount, 100000);
		Assertions.assertEquals(loan.outstanding, 100000);
	}

	@Test
	public void testCreateLoanPayBalanceOkay() {
		Loan loan = new Loan(100000);

		Assertions.assertTrue(loan.pay(account, 100000));
		Assertions.assertEquals(loan.outstanding, 0);
		Assertions.assertEquals(account.balance, 0);
	}

	@Test
	public void testCreateLoanPayBalanceNotOkay() {
		account.balance = 0;
		Loan loan = new Loan(100000);

		Assertions.assertFalse(loan.pay(account, 100000));
		Assertions.assertEquals(loan.outstanding, 100000);
	}
}

