package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Calendar;
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
import webservices.SelectRecomStub.Select_recom;
import webservices.SelectTypeStub.Select_type;
import webservices.WeeklyReportStub.Weekly_report;
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
				request.setType(Integer.parseInt(JOptionPane.showInputDialog(null, "Money Laundring=1\nOther=2\n\nPlease Give Case Type: ","")));
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
		
		JButton btnCaseRecom = new JButton("Recommendations By Case");
		btnCaseRecom.setBounds(155, 90, 200, 30);
		contentPane.add(btnCaseRecom);
		btnCaseRecom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				webservices.SelectRecomStub.Select_recom request;
				request = new Select_recom();
				request.setCase_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Please Give Case No: ","")));
			     //Invoking the service
			     try {
			    	webservices.SelectRecomStub stub = new webservices.SelectRecomStub();
			    	webservices.SelectRecomStub.Select_recomResponse response = stub.select_recom(request);
					String[] result = response.get_return();	
					String s="";
					for(String ss : result){
						s+=ss+"\n";
					}
					JOptionPane.showMessageDialog(null, s, "Recommendations By Case",JOptionPane.PLAIN_MESSAGE);
				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}		
			}
		});
		
		JButton btnReports = new JButton("Generate Weekly Report");
		btnReports.setBounds(155, 130, 200, 30);
		contentPane.add(btnReports);
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				webservices.WeeklyReportStub.Weekly_report request;
				request = new Weekly_report();
				
				//Get current date
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				java.util.Date currentdate = c.getTime();//get currentdate
				c.add(Calendar.DAY_OF_YEAR, 7);  // advances day by 2
				java.util.Date lastdate =c.getTime();//get the last date of week
				
				String mon = currentdate.toString();
				String sun = lastdate.toString();
				request.setDate_s(mon);
				request.setDate_e(sun);;
				//Invoking the service
				try {
					webservices.WeeklyReportStub stub = new webservices.WeeklyReportStub();
					webservices.WeeklyReportStub.Weekly_reportResponse response = stub.weekly_report(request);
					String[] result = response.get_return();	
					String s="Client Sum  |          Date          |  Branch  \n";
					for(String ss : result){
						s+=ss+"\n";
					}
					//s+=result;
					JOptionPane.showMessageDialog(null, s, "Weekly Report",JOptionPane.PLAIN_MESSAGE);
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
