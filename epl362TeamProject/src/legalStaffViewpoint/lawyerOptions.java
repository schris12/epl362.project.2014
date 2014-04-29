package legalStaffViewpoint;

import headOfficeViewpoint.addLawyer;
import headOfficeViewpoint.editLawyer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class lawyerOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new lawyerOptions();
	}

	public lawyerOptions() {
		
		final JFrame options = new JFrame();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLawyer = new JButton("Add Lawyer");
		btnAddLawyer.setBounds(160, 50, 170, 30);
		contentPane.add(btnAddLawyer);
		btnAddLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addLawyer();
				options.dispose();
			}
		});
		
		JButton btnEditLawyer = new JButton("Edit/Remove Lawyer");
		btnEditLawyer.setBounds(160, 90, 170, 30);
		contentPane.add(btnEditLawyer);
		btnEditLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new editLawyer();
				options.dispose();
			}
		});
		
//		JButton btnRecord = new JButton("View Lawyers");
//		btnRecord.setBounds(160, 170, 170, 30);
//		contentPane.add(btnRecord);
//		btnRecord.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new LawyerRecords();
//				options.dispose();
//			}
//		});
		
		JButton btnLogOut = new JButton("Back");
		btnLogOut.setBounds(160, 210, 170, 30);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new legalStaffOptions();
			}

		});
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Lawyer Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}
	
	
}
