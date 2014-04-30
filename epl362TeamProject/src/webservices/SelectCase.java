package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SelectCase {
	public LinkedList<String> select_case() {
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
					.executeQuery("select * from 362.case");

			while (resultSet.next()) {
				int case_id = resultSet.getInt("case_id");
				String client_id = resultSet.getString("client_id");
				String lawyer_id = resultSet.getString("legal_id");
				Date date_open = resultSet.getDate("date_open");
				Date date_close = resultSet.getDate("date_close");
				int risk = resultSet.getInt("risk");
				int type = resultSet.getInt("type");
				resultString.add(case_id+", "+client_id+", "+lawyer_id+
						", "+date_open+", "+date_close+", "+risk+", "+", "+type);
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
