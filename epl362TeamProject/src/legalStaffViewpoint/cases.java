package legalStaffViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import webservices.PutCaseParseExceptionException;
import webservices.PutRecomStub.Put_recom;


public class cases extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		new cases();
	}

	public cases() {
		
		final JFrame options = new JFrame();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddCase = new JButton("New Case");
		btnAddCase.setBounds(160, 50, 170, 30);
		contentPane.add(btnAddCase);
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new addCase();
			}
		});
		
		JButton btnEditCase = new JButton("View Cases");
		btnEditCase.setBounds(160, 90, 170, 30);
		contentPane.add(btnEditCase);
		btnEditCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new editCase();
			}
		});
		
		JButton btnAddrec = new JButton("Add Recommendation");
		btnAddrec.setBounds(160, 130, 170, 30);
		contentPane.add(btnAddrec);
		btnAddrec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new addRecommendation();
			}
		});
		
		
		
		
		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(160, 170, 170, 30);
		contentPane.add(btnRecord);
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new legalStaffOptions();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Case Options");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		options.add(contentPane);
		options.setSize(500, 300);
		options.setVisible(true);
	}
	
	
}
