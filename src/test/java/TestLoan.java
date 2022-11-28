import org.junit.jupiter.api.Test;

public class TestLoan {
	
	@Test
	// Test réussi
	public void testCreateLoan() {
		Loan loan = new Loan(100000);
		assertEquals(loan.AMOUNT,100000);
	}
	
	@Test
	//Test échoué
	public void testCreateLoanPay() {
		Client client = new Client("Loubin", "Gabin");
		assertEquals(client.name,"Larbin");
	}
}

