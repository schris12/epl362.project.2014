package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.editCase;
import main.MainScreen;
import webservices.WeeklyReportStub.Weekly_report;

public class headOfficeOptions {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch application
	 * @param args
	 */
	public static void main(String[] args) {
		new headOfficeOptions();
	}

	/**
	 * Constructor of the form
	 */
	public headOfficeOptions() {

		final JFrame options = new JFrame();

		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		options.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// options.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCases = new JButton("Client Cases");
		btnCases.setBounds(155, 50, 200, 30);
		contentPane.add(btnCases);
		/**
		 * Button to manage client cases
		 */
		btnCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewCases();
				options.dispose();
			}
		});

		JButton btnReports = new JButton("Reports");
		btnReports.setBounds(155, 90, 200, 30);
		contentPane.add(btnReports);
		/**
		 * Button to reports form
		 */
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeReports();		
			}
		});


		JButton btnLawyers = new JButton("Lawyers");
		btnLawyers.setBounds(155, 130, 200, 30);
		contentPane.add(btnLawyers);
		/**
		 * Button to manage lawyers
		 */
		btnLawyers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeLawyers();
			}
		});

		JButton btnRec = new JButton("Receptionists");
		btnRec.setBounds(155, 170, 200, 30);
		contentPane.add(btnRec);
		/**
		 * Button to manage Receptionists
		 */
		btnRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeReceptionist();
			}
		});

		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(155, 210, 200, 30);
		contentPane.add(btnRecord);
		/**
		 * Button to go back
		 */
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new MainScreen();
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Head Office Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);

		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}

}
