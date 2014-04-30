package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import webservices.SelectClientStub.Select_client;


public class editClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbClient;
	private JTextField txtClientID,txtClientName,txtClientSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new editClient();
	}

	public void fillClient(){
		webservices.SelectClientStub.Select_client request;
		request = new Select_client();
	     
	     //Invoking the service
	     try {
	    	webservices.SelectClientStub stub = new webservices.SelectClientStub();
			webservices.SelectClientStub.Select_clientResponse response = stub.select_client(request);
			String[] result = response.get_return();
			cmbClient = new JComboBox<String>(result);
			cmbClient.setBounds(60, 50, 180, 30);
			contentPane.add(cmbClient);
			cmbClient.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent arg0) {
		            String values = cmbClient.getSelectedItem().toString();
		            String splitted [] = values.split(", ");
		            txtClientID.setText(splitted[0]);
		            String splitted2[] = splitted[1].split(",");
		            txtClientName.setText(splitted2[0]);
		            txtClientSurname.setText(splitted2[1]);
		        }
		    });
		} catch (RemoteException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public editClient() {
		
		final JFrame recordScr = new JFrame();
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fillClient();
		
		JLabel lblClientID = new JLabel("ID:");
		lblClientID.setBounds(300, 40, 80, 30);
		contentPane.add(lblClientID);
		JLabel lblClientName = new JLabel("Name:");
		lblClientName.setBounds(300, 80, 80, 30);
		contentPane.add(lblClientName);
		JLabel lblClientSurname = new JLabel("Surname:");
		lblClientSurname.setBounds(300, 120, 200, 30);
		contentPane.add(lblClientSurname);
		
		txtClientID = new JTextField();
		txtClientID.setBounds(440, 40, 200, 30);
		contentPane.add(txtClientID);
		txtClientName = new JTextField();
		txtClientName.setBounds(440, 80, 200, 30);
		contentPane.add(txtClientName);
		txtClientSurname = new JTextField();
		txtClientSurname.setBounds(440, 120, 200, 30);
		contentPane.add(txtClientSurname);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(270, 300, 80, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(360, 300, 80, 30);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClientID.setText("");
				txtClientName.setText("");
				txtClientSurname.setText("");
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(450, 300, 80, 30);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(540, 300, 80, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordScr.dispose();
				new clientOptions();
				
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Edit/Remove Client");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		recordScr.add(contentPane);
		recordScr.setSize(700, 400);
		recordScr.setVisible(true);
	}
	
	
}
