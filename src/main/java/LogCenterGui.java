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

    static String username;
    static String password;
    static String uri;
    static String savedirectory = "C:\\";
    private ClientConnection client;


/*
    public LogCenterGui(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        client = new ClientConnection(username, password, uri);


        String resurl = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/resourceService/logGateway";
        String url = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/yawl/logGateway";

        connectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = userNameTextField.getText();
                password = passwordTextField.getText();
                uri = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/yawl/logGateway";
                client = new ClientConnection(username, password, uri);
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

        /*String resurl = "http://" + ipAdressTextField.getText() + ":" + portTextField.getText() + "/resourceService/logGateway";*/
        String uri = "http://localhost:8080/yawl/logGateway";

        ClientConnection client = new ClientConnection("admin", "YAWL", uri);
        client.checkConnection();
        System.out.println(client.allSpecification());
        writeFile(client.allSpecification(),  "TestAllSpecs", "XES");

    }

    private static void writeFile(String toFile, String filename, String extention) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(savedirectory + filename + "." + extention, "UTF-8");
        writer.print(toFile);
        writer.close();
    }

}

//Das ist ein Commit Test