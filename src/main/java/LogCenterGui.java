import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class LogCenterGui extends JFrame {
    private JPanel mainPanel;
    private JTextField userNameTextField;
    private JLabel usernameLabel;
    private JButton writeLogButton;
    private JLabel enterPasswortLabel;
    private JTextField ipAdressTextField;
    private JTextField portTextField;
    private JLabel enterIPLabel;
    private JLabel enterPortLabel;
    private JTextField passwordTextField;
    private JComboBox logChoserDropDown;
    private JTextArea informationTextField;
    private JButton connectionButton;

    //Class Variables
    static String savedirectory = "C:\\";
    private EngineClient client;


/*
    public LogCenterGui(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        client = new EngineClient(username, password, uri);


        String resurl = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/resourceService/logGateway";
        String url = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/yawl/logGateway";

        connectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = userNameTextField.getText();
                password = passwordTextField.getText();
                uri = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/yawl/logGateway";
                client = new EngineClient(username, password, uri);
            }
        });
        writeLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
*/
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //JFrame frame = new LogCenterGui("Log Center");
        //frame.setVisible(true);

        //creates urls
        String url = "http://localhost:8080/yawl/logGateway";
        String resurl = "http://localhost:8080/resourceService/logGateway";

        //Creates new Client
        EngineClient engClient = new EngineClient("admin", "YAWL", url);
        engClient.checkConnection();
        ResourceClient resClient = new ResourceClient("admin", "YAWL", resurl);
        resClient.checkConnection();

        //Test run for file writing
        //writeFile(engClient.allSpecification(),  "allSpecification", "xml");
        //writeFile(engClient.getCompleteCaseLog("1"),  "getCompleteCaseLog", "xml");
        //writeFile(engClient.getCompleteCaseLogsForSpecification("1", "0.4", ""),  "getCompleteCaseLogForSpecification", "xml");
        //writeFile(engClient.getSpecificationXESLog("UID_12135543-85dc-4a60-a5b4-b1aec185f609", "0.8", "ApplForLeave"),  "getSpecificationXESLog", "xml");
        //writeFile(engClient.getCaseEvents("1"),  "getCaseEvents", "xml");
        writeFile(resClient.getMergedXESLog("UID_12135543-85dc-4a60-a5b4-b1aec185f609", "0.8", "ApplForLeave"), "getMergedXESLog", "xml");


    }

    private static void writeFile(String toFile, String filename, String extention) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(savedirectory + filename + "." + extention, "UTF-8");
        writer.print(toFile);
        writer.close();
    }

}
