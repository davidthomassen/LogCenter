import org.yawlfoundation.yawl.resourcing.rsInterface.ResourceLogGatewayClient;

import java.io.IOException;

public class ResourceClient {

    //Class variables
    private ResourceLogGatewayClient client;
    private String handle;
    //Constructor
    public ResourceClient(String userId, String password, String url){
        this.client = new ResourceLogGatewayClient(url);

        try{
            this.handle = client.connect(userId, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //checks connection
    public boolean checkConnection(){
        try{
            this.client.checkConnection(this.handle);
            System.out.println("Resource Client connection successful");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Gets all events for all cases of the specification passed, from both the resource service and the engine, merged together, optionally including the data value changes from the engine's log
    public String getMergedXESLog(String identifier, String version, String uri){
        try{
           return this.client.getMergedXESLog(identifier, version, uri, true, this.handle);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
