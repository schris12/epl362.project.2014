package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SelectLawyer {
	public LinkedList<String> select_lawyer() {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {
			LinkedList<String> resultString = new LinkedList<String>();
			Connection connect = null;
			Statement statement = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager					.getConnection("jdbc:mysql://localhost/362?"
							+ "user=root&password=");

			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from 362.lawyer");

			while (resultSet.next()) {
				String lawyer_id = resultSet.getString("lawyer_id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				resultString.add(lawyer_id+", "+name+", "+surname);
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
