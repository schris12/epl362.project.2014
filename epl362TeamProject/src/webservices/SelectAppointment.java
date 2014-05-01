package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SelectAppointment {
	public LinkedList<String> select_appointment() {
		try {
			LinkedList<String> resultString = new LinkedList<String>();
			Connection connect = null;
			Statement statement = null;
			ResultSet resultSet = null;

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager					.getConnection("jdbc:mysql://localhost/362?"
							+ "user=root&password=");

			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from appointments");

			while (resultSet.next()) {
				String client_id = resultSet.getString("client_id");
				String lawyer_id = resultSet.getString("lawyer_id");
				String date = resultSet.getString("date");
				String appointment_id = resultSet.getString("appointment_id");
				String missed = resultSet.getString("missed");
				String branch_id = resultSet.getString("branch_id");
				resultString.add(client_id+", "+lawyer_id+", "+date+", "+appointment_id+", "+missed+", "+branch_id);
			}

			connect.close();

			return resultString;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
