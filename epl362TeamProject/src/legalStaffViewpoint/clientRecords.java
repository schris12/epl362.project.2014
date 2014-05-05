package legalStaffViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import receptionistViewpoint.clientOptions;


public class clientRecords extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch application
	 * @param args
	 */
	public static void main(String[] args) {
		new clientRecords();
	}

	/**
	 * Constructor of the form
	 */
	public clientRecords() {
		
		final JFrame recordScr = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<String> clientList = new JList<String>();
		clientList.setBounds(60, 40, 180,300);
		contentPane.add(clientList);
		
		JLabel lblTransactionName = new JLabel("ID:");
		lblTransactionName.setBounds(300, 40, 80, 30);
		contentPane.add(lblTransactionName);
		JLabel lblTransactionDescr = new JLabel("Description:");
		lblTransactionDescr.setBounds(300, 80, 80, 30);
		contentPane.add(lblTransactionDescr);
		JLabel lblRecommendation = new JLabel("Recommendation:");
		lblRecommendation.setBounds(300, 120, 200, 30);
		contentPane.add(lblRecommendation);
		JLabel lblLegalOpinion = new JLabel("Legal Opinion:");
		lblLegalOpinion.setBounds(300, 160, 80, 30);
		contentPane.add(lblLegalOpinion);
		
		JTextField txtTransactionName = new JTextField();
		txtTransactionName.setBounds(440, 40, 200, 30);
		contentPane.add(txtTransactionName);
		JTextField txtTransactionDescr = new JTextField();
		txtTransactionDescr.setBounds(440, 80, 200, 30);
		contentPane.add(txtTransactionDescr);
		JTextField txtRecommendation = new JTextField();
		txtRecommendation.setBounds(440, 120, 200, 30);
		contentPane.add(txtRecommendation);
		JTextField txtLegalOpinion = new JTextField();
		txtLegalOpinion.setBounds(440, 160, 200, 30);
		contentPane.add(txtLegalOpinion);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(270, 320, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save a record
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordScr.dispose();
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(370, 320, 80, 30);
		contentPane.add(btnBack);
		/**
		 * Button to go back
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordScr.dispose();
				new clientOptions();
				
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Client Records");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		recordScr.add(contentPane);
		recordScr.setSize(700, 400);
		recordScr.setVisible(true);
	}
	
	
}
