package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SelectType {
	public LinkedList<String> select_type(int type) {
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

			String s="select * from `case` WHERE (`type`="+type+")";
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery(s);
			while (resultSet.next()) {
				int case_id = resultSet.getInt("case_id");
				String client_id = resultSet.getString("client_id");
				String lawyer_id = resultSet.getString("legal_id");
				Date date_open = resultSet.getDate("date_open");
				Date date_close = resultSet.getDate("date_close");
				int risk = resultSet.getInt("risk");
				resultString.add("Case id: "+case_id+"\n++++++++++++\n Client id: "+client_id+"\n Lawyer id: "+lawyer_id+
						"\n Date Opened: "+date_open+"\n Date Closed: "+date_close+"\n Risk: "+risk+"\n Type: "+type+"\n");
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
