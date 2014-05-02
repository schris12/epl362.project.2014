package main;

import headOfficeViewpoint.headOfficeOptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.legalStaffOptions;
import receptionistViewpoint.receptionistOptions;
import webservices.SelectUserStub.Select_user;

public class MainScreen {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername, txtPassword;

	public static void main(String[] args) {
		new MainScreen();
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		File file = new File("logs/"+timeStamp);
		if(!file.exists()) {
		    try {
		    	file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	public MainScreen() {

		final JFrame mainLoginScreen = new JFrame();

		mainLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainLoginScreen.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		String[] role = { "Manager", "Legal Staff", "Receptionist" };
		final JComboBox<String> roleSelect = new JComboBox<String>(role);
		roleSelect.setBounds(160, 50, 200, 20);
		contentPane.add(roleSelect);
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(160, 80, 80, 20);
		contentPane.add(lblUsername);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(160, 110, 80, 20);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(240, 80, 120, 20);
		contentPane.add(txtUsername);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(240, 110, 120, 20);
		contentPane.add(txtPassword);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(160, 150, 80, 30);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals("")||txtPassword.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Insert Something!","Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				boolean flag = false;
				webservices.SelectUserStub.Select_user request;
				request = new Select_user();
				// Invoking the service
				try {
					webservices.SelectUserStub stub = new webservices.SelectUserStub();
					webservices.SelectUserStub.Select_userResponse response = stub
							.select_user(request);
					String[] result = response.get_return();
					for (int i = 0; i < result.length && !flag; i++){
						String resultCmp [] = result[i].split(",");
						if (resultCmp[0].equals(txtUsername.getText()))
							if (resultCmp[1].equals(txtPassword.getText()))
								if (Integer.parseInt(resultCmp[2]) == (roleSelect.getSelectedIndex()+1))
									flag = true;	
					}
					
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}

				if (flag){
					mainLoginScreen.dispose();
					int i = roleSelect.getSelectedIndex();
					switch (i) {
						case 0: {
							String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
							File file = new File("logs/"+timeStamp);					
							FileWriter fw = null;
							try {
								fw = new FileWriter(file.getAbsoluteFile());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							BufferedWriter bw = new BufferedWriter(fw);
							try {
								bw.write("Manager: "+txtUsername.getText()+" Logged In\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							new headOfficeOptions();break;
						}
						case 1: {
							String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
							File file = new File("logs/"+timeStamp);					
							FileWriter fw = null;
							try {
								fw = new FileWriter(file.getAbsoluteFile());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							BufferedWriter bw = new BufferedWriter(fw);
							try {
								bw.write("Lawyer: "+txtUsername.getText()+" Logged In\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							new legalStaffOptions();break;
						}
						case 2: {
							String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
							File file = new File("logs/"+timeStamp);					
							FileWriter fw = null;
							try {
								fw = new FileWriter(file.getAbsoluteFile());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							BufferedWriter bw = new BufferedWriter(fw);
							try {
								bw.write("Receptionist: "+txtUsername.getText()+" Logged In\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							new receptionistOptions();break;
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Credentials!","Error", JOptionPane.WARNING_MESSAGE);
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

}
