package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SelectRecom {
	public LinkedList<String> select_recom(int case_id) {
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

			String s="SELECT * FROM `recommendation` WHERE (`case_id`="+case_id+")";
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery(s);
			while (resultSet.next()) {
				String recommendation = resultSet.getString("recommendation");
				String opinion = resultSet.getString("opinion");
				Date date = resultSet.getDate("date");
				resultString.add("Case id: "+case_id+"\n++++++++++++\nRecommendation: "+recommendation+"\nOpinion: "+opinion+"\nDate: "+date+"\n");
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
