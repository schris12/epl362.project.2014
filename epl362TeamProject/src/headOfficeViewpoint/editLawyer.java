package headOfficeViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.logWriter;
import webservices.DeleteLawyerStub.Delete_lawyer;
import webservices.EditLawyerStub.Edit_lawyer;
import webservices.SelectLawyerStub.Select_lawyer;

public class editLawyer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbLawyer;
	private JTextField txtLawyerID, txtLawyerName, txtLawyerSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new editLawyer();
	}

	/**
	 * Load lawyers
	 */
	public void fillLawyer() {
		webservices.SelectLawyerStub.Select_lawyer request;
		request = new Select_lawyer();

		// Invoking the service
		try {
			webservices.SelectLawyerStub stub = new webservices.SelectLawyerStub();
			webservices.SelectLawyerStub.Select_lawyerResponse response = stub
					.select_lawyer(request);
			String[] result = response.get_return();
			cmbLawyer = new JComboBox<String>(result);
			cmbLawyer.setBounds(60, 50, 180, 30);
			contentPane.add(cmbLawyer);
		} catch (RemoteException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public editLawyer() {

		final JFrame recordScr = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		fillLawyer();
		/**
		 * Dropdown list with lawyers
		 */
		cmbLawyer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String values = cmbLawyer.getSelectedItem().toString();
				String splitted[] = values.split(", ");
				txtLawyerID.setText(splitted[0]);
				txtLawyerName.setText(splitted[1]);
				txtLawyerSurname.setText(splitted[2]);
			}
		});

		JLabel lblLawyerID = new JLabel("ID:");
		lblLawyerID.setBounds(300, 40, 80, 30);
		contentPane.add(lblLawyerID);
		JLabel lblLawyerName = new JLabel("Name:");
		lblLawyerName.setBounds(300, 80, 80, 30);
		contentPane.add(lblLawyerName);
		JLabel lblLawyerSurname = new JLabel("Surname:");
		lblLawyerSurname.setBounds(300, 120, 200, 30);
		contentPane.add(lblLawyerSurname);

		txtLawyerID = new JTextField();
		txtLawyerID.setBounds(440, 40, 200, 30);
		contentPane.add(txtLawyerID);
		txtLawyerName = new JTextField();
		txtLawyerName.setBounds(440, 80, 200, 30);
		contentPane.add(txtLawyerName);
		txtLawyerSurname = new JTextField();
		txtLawyerSurname.setBounds(440, 120, 200, 30);
		contentPane.add(txtLawyerSurname);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(270, 300, 80, 30);
		contentPane.add(btnSave);
		/**
		 * Button to save changes
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new logWriter().logWriterOut("EditLawyer");
				String id = txtLawyerID.getText();
				String name = txtLawyerName.getText();
				String surname = txtLawyerSurname.getText();

				// Creating the Request
				webservices.EditLawyerStub.Edit_lawyer request;
				request = new Edit_lawyer();
				request.setId(id);
				request.setName(name);
				request.setSurname(surname);

				// Invoking the service
				try {
					webservices.EditLawyerStub stub = new webservices.EditLawyerStub();
					webservices.EditLawyerStub.Edit_lawyerResponse response = stub
							.edit_lawyer(request);
					System.out.println("Response: " + response.get_return());

				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}

				recordScr.dispose();
				new editLawyer();
			}
		});

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(360, 300, 80, 30);
		contentPane.add(btnClear);
		/**
		 * Button to clear form
		 */
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLawyerID.setText("");
				txtLawyerName.setText("");
				txtLawyerSurname.setText("");
				cmbLawyer.setSelectedIndex(0);
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(450, 300, 80, 30);
		contentPane.add(btnDelete);
		/**
		 * Button to delete selection
		 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtLawyerID.getText();

				// Creating the Request
				webservices.DeleteLawyerStub.Delete_lawyer request;
				request = new Delete_lawyer();
				request.setId(id);

				// Invoking the service
				try {
					webservices.DeleteLawyerStub stub = new webservices.DeleteLawyerStub();
					webservices.DeleteLawyerStub.Delete_lawyerResponse response = stub
							.delete_lawyer(request);
					System.out.println("Response: " + response.get_return());

				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}

				recordScr.dispose();
				new editLawyer();
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(540, 300, 80, 30);
		contentPane.add(btnBack);
		/**
		 * Button to go back
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordScr.dispose();
				new headOfficeLawyers();

			}

		});

		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Edit/Remove Lawyer");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);

		recordScr.add(contentPane);
		recordScr.setSize(700, 400);
		recordScr.setVisible(true);
	}

}
