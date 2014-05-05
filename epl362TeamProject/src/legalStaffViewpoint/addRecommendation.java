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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.logWriter;
import webservices.EditCaseStub.Edit_case;
import webservices.PutRecomParseExceptionException;
import webservices.PutRecomStub.Put_recom;
import webservices.SelectCaseStub.Select_case;

public class addRecommendation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbRisk, cmbCases;
	private JFormattedTextField dateOpen, dateClose;
	private JTextField txtID,cmbType, cmbClient,cmbLawyer;
	private JTextArea txtRec, txtOpin;

	/**
	 * Launch application
	 * @param args
	 */
	public static void main(String[] args) {
		new addRecommendation();
	}

	
	/**
	 * Load cases
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
	public addRecommendation() {
		
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
		
		JLabel lblRec = new JLabel();
		lblRec.setText("Recommendation:");
		lblRec.setBounds(450, 100, 275, 30);
		contentPane.add(lblRec);
		txtRec = new JTextArea();
		txtRec.setBounds(450, 140, 275, 190);
		contentPane.add(txtRec);
		txtRec.setCaretPosition(0);
		
		JLabel lblOpin = new JLabel();
		lblOpin.setText("Opinion:");
		lblOpin.setBounds(735, 100, 275, 30);
		contentPane.add(lblOpin);
		txtOpin = new JTextArea();
		txtOpin.setBounds(735, 140, 275, 190);
		contentPane.add(txtOpin);
		txtOpin.setCaretPosition(0);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(190, 400, 80, 30);
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
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(280, 400, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save recommendation
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*Here*/
				new logWriter().logWriterOut("EditCase");
				String case_id = txtID.getText().toString();
				String date_open = dateOpen.getText();
				String recommendation = txtRec.getText();
				String opinion = txtOpin.getText();
				
				//Creating the Request
				webservices.PutRecomStub.Put_recom request;
				request = new Put_recom();
				request.setDate(date_open);
				request.setId(case_id);
				request.setOpinion(opinion);
				request.setRecom(recommendation);
			     
			     //Invoking the service
			     try {
			    	webservices.PutRecomStub stub = new webservices.PutRecomStub();
			    	webservices.PutRecomStub.Put_recomResponse response = stub.put_recom(request);
					System.out.println("Response: " + response.get_return());					
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				} catch (PutRecomParseExceptionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		JLabel lblNewLabel = new JLabel("Add Recommendation");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		addScr.add(contentPane);
		addScr.setSize(1050, 500);
		addScr.setVisible(true);
	}
	
}
