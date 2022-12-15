import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClientTest {
	
	@Test
	public void testNomValide() throws Exception {
		Client client = new Client("Eloïse Le Blanc");
		assertEquals(client.name,"Eloïse Le Blanc");
	}

	@Test
	public void testNameFalse() throws Exception {
		Client client = new Client("Gabin Loubin");
		assertNotEquals(client.name,"Gabin Larbin");
	}
}

