package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import legalStaffViewpoint.clientRecords;
import legalStaffViewpoint.legalStaffOptions;


public class clientOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		new clientOptions();
	}

	public clientOptions() {
		
		final JFrame options = new JFrame();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.setBounds(160, 50, 170, 30);
		contentPane.add(btnAddClient);
		/**
		 * Button to load form to add client
		 */
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new addClient();
			}
		});
		
		JButton btnEditClient = new JButton("Edit/Remove Client");
		btnEditClient.setBounds(160, 90, 170, 30);
		contentPane.add(btnEditClient);
		/**
		 * Button to load form to edit/remove existing client
		 */
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new editClient();
			}
		});
		
//		JButton btnRecord = new JButton("View Client Record");
//		btnRecord.setBounds(160, 130, 170, 30);
//		contentPane.add(btnRecord);
//		/**
//		 * Button to load form to view client records
//		 */
//		btnRecord.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				options.dispose();
//				new clientRecords();
//			}
//		});
		
		JButton btnLogOut = new JButton("Back");
		btnLogOut.setBounds(160, 170, 170, 30);
		contentPane.add(btnLogOut);
		/**
		 * Buttno to go back
		 */
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new receptionistOptions();
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Client Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}
	
	
}
