package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.legalStaffOptions;
import main.legalRecords;

public class receptionistOptions {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new receptionistOptions();
	}

	public receptionistOptions() {
		
		final JFrame options = new JFrame();
				
		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		options.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//options.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDairy = new JButton("Diary System");
		btnDairy.setBounds(150, 50, 200, 30);
		contentPane.add(btnDairy);
		btnDairy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new appointments();
			}
		});
		
		JButton btnSearch = new JButton("Search Case");
		btnSearch.setBounds(150, 90, 200, 30);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnGen = new JButton("Generate Reccomendations");
		btnGen.setBounds(150, 130, 200, 30);
		contentPane.add(btnGen);
		btnGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnClients = new JButton("Clients");
		btnClients.setBounds(150, 170, 200, 30);
		contentPane.add(btnClients);
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new clientOptions();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(150, 210, 200, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new legalRecords();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Receptionist Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}

}
