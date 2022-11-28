import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestClient {
	
	@Test
	// Test réussi
	public void testNomValide() throws Exception {
		Client client = new Client(1, "Le Blanc", "Eloïse");
		assertEquals(client.name,"Le Blanc");
	}

	@Test
	//Test échoué
	public void testNameFalse() throws Exception {
		Client client = new Client(1, "Loubin", "Gabin");
		assertNotEquals(client.name,"Larbin");
	}
}

