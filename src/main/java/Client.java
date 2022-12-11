import java.util.UUID;

public class Client {

    final UUID uuid = UUID.randomUUID();
    String name;

    Client(String name) throws Exception {
        if (name != null) {
            this.name = name;
        } else {
            throw new Exception("The client name cannot be null");
        }
    }

}
