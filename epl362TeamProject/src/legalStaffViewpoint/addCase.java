package legalStaffViewpoint;

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

import webservices.PutAppointmentStub.Put_appointment;
import webservices.PutCaseStub.Put_case;
import main.constants;
import main.fillCombo;
import main.httpRequest;

public class addCase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbClient,cmbLawyer,cmbType,cmbRisk;
	private JFormattedTextField dateOpen, dateClose;
	private JTextField txtID;

	public static void main(String[] args) {
		new addCase();
	}

	public addCase() {
		
		final JFrame addScr = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("Case ID:");
		lblID.setBounds(100,60,100,30);
		contentPane.add(lblID);
		JLabel lblClient = new JLabel("Select Client:");
		lblClient.setBounds(100, 100, 100, 30);
		contentPane.add(lblClient);
		JLabel lblLawyer = new JLabel("Select Lawyer:");
		lblLawyer.setBounds(100, 140, 100, 30);
		contentPane.add(lblLawyer);
		JLabel lblType = new JLabel("Case Type:");
		lblType.setBounds(100, 180, 100, 30);
		contentPane.add(lblType);
		JLabel lblDateOpen = new JLabel("Date Open:");
		lblDateOpen.setBounds(100, 220, 100, 30);
		contentPane.add(lblDateOpen);
		JLabel lblDateClose = new JLabel("Date Close:");
		lblDateClose.setBounds(100, 260, 100, 30);
		contentPane.add(lblDateClose);
		JLabel lblRisk = new JLabel("Risk Level:");
		lblRisk.setBounds(100, 300, 100, 30);
		contentPane.add(lblRisk);
		
		txtID = new JTextField();
		txtID.setBounds(240, 60, 200, 30);
		contentPane.add(txtID);
		cmbClient = new JComboBox<String>();
		cmbClient.setBounds(240, 100, 200, 30);
		contentPane.add(cmbClient);
		cmbLawyer = new JComboBox<String>();
		cmbLawyer.setBounds(240, 140, 200, 30);
		contentPane.add(cmbLawyer);
		cmbType = new JComboBox<String>();
		cmbType.setBounds(240, 180, 200, 30);
		contentPane.add(cmbType);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dateOpen = new JFormattedTextField(format);
		dateOpen.setBounds(240, 220, 200, 30);
		contentPane.add(dateOpen);
		dateClose = new JFormattedTextField(format);
		dateClose.setBounds(240, 260, 200, 30);
		contentPane.add(dateClose);
		
		String[] values = { " ","1","2","3","4","5" };
		cmbRisk = new JComboBox<String>(values);
		cmbRisk.setBounds(240,300,200,30);
		contentPane.add(cmbRisk);
		
		//fill combo boxes
		fillCombo.fillClient(cmbClient);
		fillCombo.fillLawyer(cmbLawyer);
		fillCombo.fillType(cmbType);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(130, 350, 80, 30);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
//				cmbClient.setSelectedIndex(0);
//				cmbLawyer.setSelectedIndex(0);
//				cmbType.setSelectedIndex(0);
				cmbRisk.setSelectedIndex(0);
				dateOpen.setText("");
				dateClose.setText("");
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(220, 350, 80, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				StringBuilder param = new StringBuilder();
//				param.append("case_id=" + txtID.getText() + "&");
//				param.append("client_id=" + cmbClient.getSelectedItem().toString() + "&");
//				param.append("legal_id=" + cmbLawyer.getSelectedItem().toString() + "&"); // legal_id = lawyer_id ??
//				param.append("date_open=" + dateOpen.getText() + "&");
//				param.append("date_close=" + dateClose.getText() + "&");
//				param.append("risk=" + cmbRisk.getSelectedItem().toString() + "&");
//				param.append("type=" + cmbType.getSelectedItem().toString());				
//				String url = constants.getUrl();
//				url += "AddCase";
//				httpRequest http = new httpRequest();
//				try {
//					http.sendPost(url,param.toString());
////						JOptionPane.showMessageDialog(null,"Client Input Successfull","Success!",JOptionPane.WARNING_MESSAGE);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
				
				/*Here*/
				String client_id = cmbClient.getSelectedItem().toString();
				String lawyer_id = cmbLawyer.getSelectedItem().toString();
				String type = cmbType.getSelectedItem().toString();
				String date_open = dateOpen.getText();
				String date_close = dateClose.getText();
				int risk =Integer.parseInt(cmbRisk.getSelectedItem().toString());
				
				//Creating the Request
				webservices.PutCaseStub.Put_case request;
				request = new Put_case();
				request.setClient_id(client_id);
				request.setLawyer_id(lawyer_id);				
				request.setDate_open(date_open);
				request.setDate_close(date_close);
				request.setRisk(risk);
				

			     
			     //Invoking the service
			     try {
			    	webservices.PutCaseStub stub = new webservices.PutCaseStub();
					webservices.PutCaseStub.Put_caseResponse response = stub.put_case(request);
					System.out.println("Response: " + response.get_return());					
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}	
			}

			
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(310, 350, 80, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScr.dispose();
				new cases();
				
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Add New Case");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(700, 500);
		addScr.setVisible(true);
	}
	
}
