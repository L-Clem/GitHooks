import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LoanTest {
	Account account;

	@BeforeEach
	void init() {
		Client client = new Client("Client", "pwd");
		account = new Account(client);
		account.balance = 100000;
	}

	@Test
	// Test réussi
	public void testCreateLoan() {
		Loan loan = new Loan(100000);
		Assertions.assertEquals(loan.amount,100000);
		Assertions.assertEquals(loan.outstanding, 100000);
	}
	
	@Test
	//Test échoué
	public void testCreateLoanPayBalanceOkay() {
		Loan loan = new Loan(100000);

		Assertions.assertTrue(loan.pay(account, 100000));

		Assertions.assertEquals(loan.outstanding,0);
		Assertions.assertEquals(account.balance, 0);
	}

	@Test
	//Test échoué
	public void testCreateLoanPayBalanceNotOkay() {
		account.balance = 0;
		Loan loan = new Loan(100000);

		Assertions.assertFalse(loan.pay(account, 100000));

		Assertions.assertEquals(loan.outstanding,100000);
	}
}

