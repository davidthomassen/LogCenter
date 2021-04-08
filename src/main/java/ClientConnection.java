import org.yawlfoundation.yawl.engine.interfce.interfaceE.YLogGatewayClient;

import java.io.IOException;

public class ClientConnection {
    private YLogGatewayClient client;
    private String handle;


    public ClientConnection(String username, String password, String uri) {
        this.client = new YLogGatewayClient(uri);

        try {
            this.handle = this.client.connect(username, password);
            System.out.println("Client creation successful");
        } catch (IOException e) {
            System.out.println("No client created");
        }
    }


    public boolean checkConnection() {
        try {
            this.client.checkConnection(this.handle);
            System.out.println("Connection successful");
            return true;
        } catch (IOException e) {
            System.out.println("Check Connection Error");
            return false;
        }
    }

    public String allSpecification() {
        try {
            return this.client.getAllSpecifications(this.handle);
        } catch (IOException e) {
            System.out.println("Error catch all Specifications");
            return null;
        }
    }
}
