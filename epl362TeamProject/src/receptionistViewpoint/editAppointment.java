package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import webservices.PutAppointmentParseExceptionException;
import webservices.DeleteLawyerStub.Delete_lawyer;
import webservices.PutAppointmentStub.Put_appointment;
import webservices.SelectAppointmentStub.Select_appointment;

public class editAppointment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cmbClient;
	private JTextField cmbLawyer;
	private JTextField cmbBranch;
	private JComboBox<String> cmbAppoint;
	
	public static void main(String[] args) {
		new editAppointment();
	}
	

	public void fillLawyer(){
		webservices.SelectAppointmentStub.Select_appointment request;
		request = new Select_appointment();
	     
	     //Invoking the service
	     try {
	    	webservices.SelectAppointmentStub stub = new webservices.SelectAppointmentStub();
	    	webservices.SelectAppointmentStub.Select_appointmentResponse response = stub.select_appointment(request);
			String[] result = response.get_return();			
			cmbAppoint = new JComboBox<String>(result);
			cmbAppoint.setBounds(310, 60, 200, 30);
			contentPane.add(cmbAppoint);
		} catch (RemoteException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}
		
	}
	
	public editAppointment() {
		
		final JFrame addScr = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClient = new JLabel("Select Client:");
		lblClient.setBounds(100, 60, 100, 30);
		contentPane.add(lblClient);
		JLabel lblLawyer = new JLabel("Select Lawyer:");
		lblLawyer.setBounds(100, 100, 100, 30);
		contentPane.add(lblLawyer);
		JLabel lblBranch = new JLabel("Select Branch:");
		lblBranch.setBounds(100, 140, 100, 30);
		contentPane.add(lblBranch);
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(100, 180, 100, 30);
		contentPane.add(lblDate);
		
		cmbClient = new JTextField();
		cmbClient.setBounds(240, 60, 200, 30);
		contentPane.add(cmbClient);
		
		cmbLawyer = new JTextField();
		cmbLawyer.setBounds(240, 100, 200, 30);
		contentPane.add(cmbLawyer);
		
		cmbBranch = new JTextField();
		cmbBranch.setBounds(240, 140, 200, 30);
		contentPane.add(cmbBranch);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		final JFormattedTextField dateTextField = new JFormattedTextField(format);
		dateTextField.setBounds(240, 180, 200, 30);
		contentPane.add(dateTextField);	
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(130, 320, 80, 30);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(220, 320, 80, 30);
		contentPane.add(btnDelete);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(310, 320, 80, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client_id = cmbClient.getText().toString().split(", ")[0];
				String lawyer_id = cmbLawyer.getText().toString().split(", ")[0];
				String branch_id = cmbBranch.getText();
				String date = dateTextField.getText();		
				
				//Creating the Request
				webservices.PutAppointmentStub.Put_appointment  request;
				request = new Put_appointment();
				request.setClient_id(client_id);
				request.setLawyer_id(lawyer_id);				
				request.setDate(date);
				request.setBranch_id(branch_id);

			     
			     //Invoking the service
			     try {
			    	webservices.PutAppointmentStub stub = new webservices.PutAppointmentStub();
					webservices.PutAppointmentStub.Put_appointmentResponse response = stub.put_appointment(request);
					System.out.println("Response: " + response.get_return());	
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				} catch (PutAppointmentParseExceptionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(400, 320, 80, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScr.dispose();
				new appointments();	
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Edit Appointment");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(700, 400);
		addScr.setVisible(true);
	}

}
