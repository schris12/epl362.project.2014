package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import webservices.PutClientStub.Put_client;
import webservices.PutLawyerStub.Put_lawyer;
import legalStaffViewpoint.lawyerOptions;
import main.logWriter;


public class addLawyer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLawyerID,txtLawyerName,txtLawyerSurname;

	/**
	 * Launch application
	 * @param args
	 */
	public static void main(String[] args) {
		new addLawyer();
	}

	/**
	 * Constructor of the form
	 */
	public addLawyer() {
		
		final JFrame addScr = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLawyerID = new JLabel("ID:");
		lblLawyerID.setBounds(100, 60, 80, 30);
		contentPane.add(lblLawyerID);
		JLabel lblLawyerName = new JLabel("Name:");
		lblLawyerName.setBounds(100, 100, 80, 30);
		contentPane.add(lblLawyerName);
		JLabel lblLawyerSurname = new JLabel("Surname:");
		lblLawyerSurname.setBounds(100, 140, 200, 30);
		contentPane.add(lblLawyerSurname);
		
		txtLawyerID = new JTextField();
		txtLawyerID.setBounds(240, 60, 200, 30);
		contentPane.add(txtLawyerID);
		txtLawyerName = new JTextField();
		txtLawyerName.setBounds(240, 100, 200, 30);
		contentPane.add(txtLawyerName);
		txtLawyerSurname = new JTextField();
		txtLawyerSurname.setBounds(240, 140, 200, 30);
		contentPane.add(txtLawyerSurname);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(130, 320, 80, 30);
		contentPane.add(btnClear);
		/**
		 * Button to clear form
		 */
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLawyerID.setText("");
				txtLawyerName.setText("");
				txtLawyerSurname.setText("");
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(220, 320, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save insertion
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new logWriter().logWriterOut("AddLawyer");
				String id = txtLawyerID.getText();
				String name = txtLawyerName.getText();
				String surname = txtLawyerSurname.getText();	

				//Creating the Request
				webservices.PutLawyerStub.Put_lawyer  request;
				request = new Put_lawyer();
				request.setId(id);
				request.setName(name);				
				request.setSurname(surname);

				//Invoking the service
				try {
					webservices.PutLawyerStub stub = new webservices.PutLawyerStub();
					webservices.PutLawyerStub.Put_lawyerResponse response = stub.put_lawyer(request);
					System.out.println("Response: " + response.get_return());					

				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}	
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(310, 320, 80, 30);
		contentPane.add(btnBack);
		/**
		 * Button to go back
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScr.dispose();
				new headOfficeLawyers();
				
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Add Lawyer");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(700, 400);
		addScr.setVisible(true);
	}
	
	
}
