import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TestClient {
	
	@Test
	// Test réussi
	public void testNomValide() {
		Client client = new Client("Le Blanc", "Eloïse");
		assertEquals(client.name,"Le Blanc");
	}
	
	@Test
	//Test échoué
	public void testNameFalse() {
		Client client = new Client("Loubin", "Gabin");
		assertEquals(client.name,"Larbin");
	}
}

