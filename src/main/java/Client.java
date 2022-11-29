public class Client {
		
	// Variables 
	int idClient;
	String name;
	String password;
	
	//Constructeur
	Client(int idClient, String name, String password) throws Exception {
		if (name != null && password != null){
			this.idClient = idClient;
			this.name = name;
			this.password = password;
		}else{
			throw new Exception("The client name or password can not be null");
		}
	}
	
}
