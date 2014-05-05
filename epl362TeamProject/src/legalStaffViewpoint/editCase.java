package legalStaffViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import main.logWriter;
import webservices.DeleteCaseStub.Delete_case;
import webservices.EditCaseStub.Edit_case;
import webservices.SelectCaseStub.Select_case;

public class editCase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbRisk, cmbCases;
	private JFormattedTextField dateOpen, dateClose;
	private JTextField txtID,cmbType, cmbClient,cmbLawyer;

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		new editCase();
	}

	
	/**
	 * Load cases from database
	 */
	public void fillcase(){
		webservices.SelectCaseStub.Select_case request;
		request = new Select_case();
	     
	     //Invoking the service
	     try {
	    	webservices.SelectCaseStub stub = new webservices.SelectCaseStub();
	    	webservices.SelectCaseStub.Select_caseResponse response = stub.select_case(request);
			String[] result = response.get_return();			
			cmbCases = new JComboBox<String>(result);
			cmbCases.setBounds(450, 60, 275, 30);
			contentPane.add(cmbCases);
		} catch (RemoteException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}
		
	}
	
	/**
	 * Constructor of the form
	 */
	public editCase() {
		
		final JFrame addScr = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 637);
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
		cmbClient = new JTextField();
		cmbClient.setBounds(240, 100, 200, 30);
		contentPane.add(cmbClient);
		
		fillcase();
		/**
		 * Dropdown list with the cases
		 */
		cmbCases.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtID.setText(cmbCases.getSelectedItem().toString().split(", ")[0]);
				cmbClient.setText(cmbCases.getSelectedItem().toString().split(", ")[1]);
				cmbLawyer.setText(cmbCases.getSelectedItem().toString().split(", ")[2]);
				cmbType.setText(cmbCases.getSelectedItem().toString().split(", ")[6]);
				dateOpen.setText(cmbCases.getSelectedItem().toString().split(", ")[3]);
				dateClose.setText(cmbCases.getSelectedItem().toString().split(", ")[4]);
				cmbRisk.setSelectedItem(cmbCases.getSelectedItem().toString().split(", ")[5]);
			}
		});
		
		cmbLawyer = new JTextField();
		cmbLawyer.setBounds(240, 140, 200, 30);
		contentPane.add(cmbLawyer);
		
		cmbType = new JTextField();
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
		//fillCombo.fillClient(cmbClient);
		//fillCombo.fillLawyer(cmbLawyer);
		//fillCombo.fillType(cmbType);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(100, 400, 80, 30);
		contentPane.add(btnClear);
		/**
		 * Button to clear form
		 */
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				cmbClient.setText("");
				cmbLawyer.setText("");
				cmbType.setText("");
				cmbRisk.setSelectedIndex(0);
				dateOpen.setText("");
				dateClose.setText("");
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(190, 400, 80, 30);
		contentPane.add(btnDelete);
		/**
		 * Button to delete a case
		 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new logWriter().logWriterOut("DeleteCase");
				int case_id =Integer.parseInt(txtID.getText().toString());
				
				//Creating the Request
				webservices.DeleteCaseStub.Delete_case request;
				request = new Delete_case();
				request.setId(case_id);

			     //Invoking the service
			     try {
			    	webservices.DeleteCaseStub stub = new webservices.DeleteCaseStub();
			    	webservices.DeleteCaseStub.Delete_caseResponse response = stub.delete_case(request);
					System.out.println("Response: " + response.get_return());					
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}	
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(280, 400, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save changes
		 */
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
				new logWriter().logWriterOut("EditCase");
				String case_id = txtID.getText().toString();
				String client_id = cmbClient.getText().toString();
				String lawyer_id = cmbLawyer.getText().toString();
				String type = cmbType.getText().toString();
				String date_open = dateOpen.getText();
				String date_close = dateClose.getText();
				int risk =Integer.parseInt(cmbRisk.getSelectedItem().toString());
				
				//Creating the Request
				webservices.EditCaseStub.Edit_case request;
				request = new Edit_case();
				request.setCase_id(case_id);
				request.setClient_id(client_id);
				request.setLawyer_id(lawyer_id);				
				request.setDate_open(date_open);
				request.setDate_close(date_close);
				request.setType(type);
				request.setRisk(risk);
				

			     
			     //Invoking the service
			     try {
			    	webservices.EditCaseStub stub = new webservices.EditCaseStub();
			    	webservices.EditCaseStub.Edit_caseResponse response = stub.edit_case(request);
					System.out.println("Response: " + response.get_return());					
				
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}	
			}

			
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(370, 400, 80, 30);
		contentPane.add(btnBack);
		/**
		 * Button to go back
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScr.dispose();
				new cases();
				
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Edit Case");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(775, 500);
		addScr.setVisible(true);
	}
	
}
