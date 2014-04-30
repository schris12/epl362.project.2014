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
import javax.swing.border.EmptyBorder;

import main.constants;
import main.fillCombo;
import main.httpRequest;


import webservices.PutAppointmentParseExceptionException;
import webservices.PutAppointmentStub.*;

public class addAppointment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbClient;
	private JComboBox<String> cmbLawyer;
	private JComboBox<String> cmbBranch;
	private String[] values = { " ","1","2","3","4","5" };
	
	public static void main(String[] args) {
		new addAppointment();
	}

	public addAppointment() {
		
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
		
		cmbClient = new JComboBox<String>(values);
		cmbClient.setBounds(240, 60, 200, 30);
		contentPane.add(cmbClient);
		cmbLawyer = new JComboBox<String>(values);
		cmbLawyer.setBounds(240, 100, 200, 30);
		contentPane.add(cmbLawyer);
		cmbBranch = new JComboBox<String>(values);
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
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(220, 320, 80, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client_id = cmbClient.getSelectedItem().toString();
				String lawyer_id = cmbLawyer.getSelectedItem().toString();
				String branch_id = cmbBranch.getSelectedItem().toString();
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
		btnBack.setBounds(310, 320, 80, 30);
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
		
		JLabel lblNewLabel = new JLabel("Add New Appointment");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(700, 400);
		addScr.setVisible(true);
	}

}
