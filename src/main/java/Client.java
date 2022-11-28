import java.util.concurrent.ThreadLocalRandom;

public class Client {
		
	// Variables 
	int idClient;
	String name;
	String password;
	
	//Constructeur
	Client(int idClient, String name, String password) {
		if (name != null || password != null){
			this.idClient = idClient;
			this.name = name;
			this.password = password;
		}
	}
	
}
