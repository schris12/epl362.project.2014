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

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;


public class headOfficeLawyers {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch application
	 * @param args
	 */
	public static void main(String[] args) {
		new headOfficeLawyers();
	}

	/**
	 * Constructor of the form
	 */
	public headOfficeLawyers() {
		
		final JFrame options = new JFrame();
				
		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		options.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//options.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(155, 50, 200, 30);
		contentPane.add(btnAdd);
		/**
		 * Button to add a new lawyer
		 */
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new addLawyer();
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(155, 90, 200, 30);
		contentPane.add(btnEdit);
		/**
		 * Button to edit an existing lawyer
		 */
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new editLawyer();
			}
		});
						
		JButton btnRecord = new JButton("Back");
		btnRecord.setBounds(155, 130, 200, 30);
		contentPane.add(btnRecord);
		/**
		 * Button to go back
		 */
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.dispose();
				new headOfficeOptions();
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
