import java.util.UUID;

public class Client {
		
	// Variables 
	private final UUID uuid = UUID.randomUUID();
	String name;
	String password;
	
	//Constructeur
	Client(String name, String password){
		this.name = name;
		this.password = password;
	}
	
}
