package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import receptionistViewpoint.addAppointment;
import receptionistViewpoint.appointments;
import legalStaffViewpoint.legalStaffOptions;
import main.constants;
import main.httpRequest;
import main.MainScreen;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

public class headOfficeOptions {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new headOfficeOptions();
	}

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
		btnCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
			}
		});

		JButton btnReports = new JButton("Generate Weekly Report");
		btnReports.setBounds(155, 90, 200, 30);
		contentPane.add(btnReports);
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnLawyers = new JButton("Lawyers");
		btnLawyers.setBounds(155, 130, 200, 30);
		contentPane.add(btnLawyers);
		btnLawyers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeLawyers();
			}
		});

		JButton btnRec = new JButton("Receptionists");
		btnRec.setBounds(155, 170, 200, 30);
		contentPane.add(btnRec);
		btnRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeReceptionist();
			}
		});

		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(155, 210, 200, 30);
		contentPane.add(btnRecord);
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
