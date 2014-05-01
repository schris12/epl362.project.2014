package receptionistViewpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import webservices.PutClientStub.Put_client;

public class addClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtClientID, txtClientName, txtClientSurname;

	public static void main(String[] args) {
		new addClient();
	}

	public addClient() {

		final JFrame addScr = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClientID = new JLabel("ID:");
		lblClientID.setBounds(100, 60, 80, 30);
		contentPane.add(lblClientID);
		JLabel lblClientName = new JLabel("Name:");
		lblClientName.setBounds(100, 100, 80, 30);
		contentPane.add(lblClientName);
		JLabel lblClientSurname = new JLabel("Surname:");
		lblClientSurname.setBounds(100, 140, 200, 30);
		contentPane.add(lblClientSurname);

		txtClientID = new JTextField();
		txtClientID.setBounds(240, 60, 200, 30);
		contentPane.add(txtClientID);
		txtClientName = new JTextField();
		txtClientName.setBounds(240, 100, 200, 30);
		contentPane.add(txtClientName);
		txtClientSurname = new JTextField();
		txtClientSurname.setBounds(240, 140, 200, 30);
		contentPane.add(txtClientSurname);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(130, 320, 80, 30);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClientID.setText("");
				txtClientName.setText("");
				txtClientSurname.setText("");
			}
		});

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(220, 320, 80, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtClientID.getText();
				String name = txtClientName.getText();
				String surname = txtClientSurname.getText();

				// Creating the Request
				webservices.PutClientStub.Put_client request;
				request = new Put_client();
				request.setId(id);
				request.setName(name);
				request.setSurname(surname);

				// Invoking the service
				try {
					webservices.PutClientStub stub = new webservices.PutClientStub();
					webservices.PutClientStub.Put_clientResponse response = stub
							.put_client(request);
					System.out.println("Response: " + response.get_return());

				} catch (RemoteException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}

				txtClientID.setText("");
				txtClientName.setText("");
				txtClientSurname.setText("");
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(310, 320, 80, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScr.dispose();
				new clientOptions();
			}

		});
		JPanel panel = new JPanel();
		panel.setBounds(64, 75, 508, 172);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Add Client");
		lblNewLabel.setBounds(200, 11, 155, 32);
		contentPane.add(lblNewLabel);

		addScr.add(contentPane);
		addScr.setSize(700, 400);
		addScr.setVisible(true);
	}

}
