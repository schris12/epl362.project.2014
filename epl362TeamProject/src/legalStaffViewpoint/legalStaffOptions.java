package legalStaffViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import receptionistViewpoint.appointments;
import receptionistViewpoint.clientOptions;
import main.legalRecords;


public class legalStaffOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new legalStaffOptions();
	}

	public legalStaffOptions() {
		
		final JFrame options = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClients = new JButton("Clients");
		btnClients.setBounds(170, 50, 170, 30);
		contentPane.add(btnClients);
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new clientOptions();
			}
		});
		
		JButton btnCases = new JButton("Cases");
		btnCases.setBounds(170, 90, 170, 30);
		contentPane.add(btnCases);
		btnCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new cases();
			}
		});
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(170, 130, 170, 30);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new legalRecords();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Legal Staff Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}
	
	
}
