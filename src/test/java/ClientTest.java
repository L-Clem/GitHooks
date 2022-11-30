import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClientTest {
	
	@Test
	// Test réussi
	public void testNomValide() throws Exception {
		Client client = new Client("Le Blanc", "Eloïse");
		assertEquals(client.name,"Le Blanc");
	}

	@Test
	//Test échoué
	public void testNameFalse() throws Exception {
		Client client = new Client("Loubin", "Gabin");
		assertNotEquals(client.name,"Larbin");
	}
}

