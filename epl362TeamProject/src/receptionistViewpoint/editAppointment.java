package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.logWriter;
import webservices.DeleteAppointmentStub.Delete_appointment;
import webservices.EditAppointmentParseExceptionException;
import webservices.EditAppointmentStub.Edit_appointment;
import webservices.PutAppointmentParseExceptionException;
import webservices.SelectAppointmentStub.Select_appointment;

public class editAppointment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cmbClient;
	private JTextField cmbLawyer;
	private JTextField cmbBranch;
	private JComboBox<String> cmbAppoint;
	private JFormattedTextField dateTextField;
	private JLabel txtAppoint;
	private JCheckBox missed;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		new editAppointment();
	}

	/**
	 * Load the lawyers of the system
	 */
	public void fillLawyer() {
		webservices.SelectAppointmentStub.Select_appointment request;
		request = new Select_appointment();

		// Invoking the service
		try {
			webservices.SelectAppointmentStub stub = new webservices.SelectAppointmentStub();
			webservices.SelectAppointmentStub.Select_appointmentResponse response = stub
					.select_appointment(request);
			String[] result = response.get_return();
			cmbAppoint = new JComboBox<String>(result);
			cmbAppoint.setBounds(450, 60, 200, 30);
			contentPane.add(cmbAppoint);
		} catch (RemoteException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}

	}

	/**
	 * Form constructor
	 */
	public editAppointment() {
		
		final JFrame addScr = new JFrame();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setBounds(100, 60, 100, 30);
		contentPane.add(lblClient);
		JLabel lblLawyer = new JLabel("Lawyer:");
		lblLawyer.setBounds(100, 100, 100, 30);
		contentPane.add(lblLawyer);
		JLabel lblBranch = new JLabel("Branch:");
		lblBranch.setBounds(100, 140, 100, 30);
		contentPane.add(lblBranch);
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(100, 180, 100, 30);
		contentPane.add(lblDate);
		JLabel lblAppoint = new JLabel("Appointment No:");
		lblAppoint.setBounds(100, 220, 100, 30);
		contentPane.add(lblAppoint);
		JLabel lblMissed = new JLabel("Appoint. Missed:");
		lblMissed.setBounds(100, 260, 100, 30);
		contentPane.add(lblMissed);
		
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
		dateTextField = new JFormattedTextField(format);
		dateTextField.setBounds(240, 180, 200, 30);
		contentPane.add(dateTextField);	
		
		txtAppoint = new JLabel();
		txtAppoint.setBounds(240, 220, 200, 30);
		contentPane.add(txtAppoint);
		
		missed = new JCheckBox();
		missed.setBounds(240, 260, 200, 30);
		contentPane.add(missed);
		
		fillLawyer();
		/**
		 * Dropdown list with the appointments
		 */
		cmbAppoint.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent arg0) {
	            String values = cmbAppoint.getSelectedItem().toString();
	            String splitted [] = values.split(", ");
	            cmbClient.setText(splitted[0]);
	            cmbLawyer.setText(splitted[1]);
	            dateTextField.setText(splitted[2]);
	            txtAppoint.setText(splitted[3]);
	            cmbBranch.setText(splitted[5]);
	            
	        }
	    });
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(130, 320, 80, 30);
		contentPane.add(btnClear);
		/**
		 * Button to clear form
		 */
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cmbClient.setText("");
		         cmbLawyer.setText("");
		         dateTextField.setText("");
		         txtAppoint.setText("");
		         cmbBranch.setText("");
		         missed.setSelected(false);
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(220, 320, 80, 30);
		contentPane.add(btnDelete);
		/**
		 * Button to delete selection
		 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new logWriter().logWriterOut("DeleteAppointment");
				int appointment = Integer.parseInt(txtAppoint.getText()); 
				
				//Creating the Request
				webservices.DeleteAppointmentStub.Delete_appointment request;
				request = new Delete_appointment();
				request.setId(appointment);
							     
			     //Invoking the service
			     try {
			    	webservices.DeleteAppointmentStub stub = new webservices.DeleteAppointmentStub();
			    	webservices.DeleteAppointmentStub.Delete_appointmentResponse response = stub.delete_appointment(request);
					System.out.println("Response: " + response.get_return());	
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}	
			     
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(310, 320, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save changes 
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new logWriter().logWriterOut("EditAppointment");
				String client_id = cmbClient.getText().toString().split(", ")[0];
				String lawyer_id = cmbLawyer.getText().toString().split(", ")[0];
				String branch_id = cmbBranch.getText();
				String ap_id = txtAppoint.getText();
				String date = dateTextField.getText();
				int missedValue= (missed.isSelected())? 1:0;
				
				//Creating the Request
				webservices.EditAppointmentStub.Edit_appointment request;
				request = new Edit_appointment();
				request.setAppointment_id(ap_id);
				request.setClient_id(client_id);
				request.setLawyer_id(lawyer_id);				
				request.setDate(date);
				request.setMissed(missedValue);
				request.setBranch_id(branch_id);

			     
			     //Invoking the service
			     try {
			    	 webservices.EditAppointmentStub stub = new webservices.EditAppointmentStub();
			    	webservices.EditAppointmentStub.Edit_appointmentResponse response = stub.edit_appointment(request);
					System.out.println("Response: " + response.get_return());	
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				} catch (EditAppointmentParseExceptionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(400, 320, 80, 30);
		contentPane.add(btnBack);
		/**
		 * Button to go back
		 */
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
