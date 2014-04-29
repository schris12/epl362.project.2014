package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.legalStaffOptions;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;


public class mainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername, txtPassword;

	public static void main(String[] args) {
		new mainScreen();
	}

	public mainScreen() {
		
		final JFrame mainLoginScreen = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(140, 70, 80, 20);
		contentPane.add(lblUsername);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(140, 100, 80, 20);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(220, 70, 120, 20);
		contentPane.add(txtUsername);
		txtPassword = new JTextField();
		txtPassword.setBounds(220, 100, 120, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(160, 150, 80, 30);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkPassword()){
					new legalStaffOptions();
					mainLoginScreen.dispose();
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(280, 150, 80, 30);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLoginScreen.dispose();
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Legal Staff Login Screen");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		mainLoginScreen.add(contentPane);
		mainLoginScreen.setSize(500, 300);
		mainLoginScreen.setVisible(true);
	}
	
	public boolean checkPassword(){
		httpRequest http = new httpRequest();
		String url = constants.getUrl() + "GetDetails/" + txtUsername.getText();
		System.out.println(url);
		String result = "";
		//String result = "{\"id\": 10,\"pass\": \"1234\",\"type\": \"legal\"}";
		try {
			result = http.sendGet(url);
			if (result.equals("")){
				JOptionPane.showMessageDialog(null,"Wrong Username","Username Error",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.print("gitTest");
//		System.out.print(result);
		JsonParserFactory fct = JsonParserFactory.getInstance();
		JSONParser parser = fct.newJsonParser();
		Map<String, String> jsonData = parser.parseJson(result);
		String val = jsonData.get("pass");
//		System.out.println("Type="+jsonData.get("type"));
		if (val.equals(txtPassword.getText()))
			return true;
		else{
			JOptionPane.showMessageDialog(null,"Wrong Password","Password Error",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
	}
	
}
