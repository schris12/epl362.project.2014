package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import receptionistViewpoint.addAppointment;
import receptionistViewpoint.appointments;
import webservices.PutLawyerStub.Put_lawyer;
import webservices.SelectCaseStub.Select_case;
import webservices.SelectTypeStub.Select_type;
import legalStaffViewpoint.legalStaffOptions;
import main.constants;
import main.httpRequest;
import main.MainScreen;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

public class headOfficeReports {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new headOfficeReports();
	}

	public headOfficeReports() {

		final JFrame reportFrame = new JFrame();

		reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reportFrame.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// reportFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCaseType = new JButton("Cases By Type");
		btnCaseType.setBounds(155, 50, 200, 30);
		contentPane.add(btnCaseType);
		btnCaseType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				webservices.SelectTypeStub.Select_type request;
				request = new Select_type();
				request.setType(Integer.parseInt(JOptionPane.showInputDialog(null, "Please Give Case Type: ","")));
			     //Invoking the service
			     try {
			    	webservices.SelectTypeStub stub = new webservices.SelectTypeStub();
			    	webservices.SelectTypeStub.Select_typeResponse response = stub.select_type(request);
					String[] result = response.get_return();	
					String s="";
					for(String ss : result){
						s+=ss+"\n";
					}
					JOptionPane.showMessageDialog(null, s, "Cases By Type",JOptionPane.PLAIN_MESSAGE);
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}		
			}
		});

		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(155, 210, 200, 30);
		contentPane.add(btnRecord);
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportFrame.dispose();
				new headOfficeOptions();
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Head Office Reports");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);

		reportFrame.add(contentPane);
		reportFrame.setSize(500, 300);
		reportFrame.setVisible(true);
	}

}
