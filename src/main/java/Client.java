import java.util.UUID;

public class Client {

	final UUID uuid = UUID.randomUUID();
	String name;
	String password;

	Client(String name, String password) throws Exception {
		if (name != null && password != null) {
			this.name = name;
			this.password = password;
		} else {
			throw new Exception("The client name or password can not be null");
		}
	}

}
