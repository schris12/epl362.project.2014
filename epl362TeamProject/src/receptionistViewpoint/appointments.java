package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.legalStaffOptions;


public class appointments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new appointments();
	}

	public appointments() {
		
		final JFrame options = new JFrame();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddClient = new JButton("New Appointment");
		btnAddClient.setBounds(170, 50, 170, 30);
		contentPane.add(btnAddClient);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new addAppointment();
			}
		});
		
		JButton btnEditClient = new JButton("Missed Appointments");
		btnEditClient.setBounds(170, 90, 170, 30);
		contentPane.add(btnEditClient);
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(170, 130, 170, 30);
		contentPane.add(btnRecord);
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new receptionistOptions();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Appointments Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}
	
	
}
