package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class weeklyReport {
	public LinkedList<String> weekly_report(String date_s,String date_e) {
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

			
			String s="SELECT SUM(`client_id`) AS sum, `date` ,  `branch_id`"+
			" FROM  `appointments` WHERE  `date` BETWEEN  '2014-04-27' AND  '2014-05-03' GROUP BY  `date`"+ 
			"ORDER BY `branch_id` AND `date` ";
			statement = connect.createStatement();
			resultSet = statement.executeQuery(s);
			while (resultSet.next()) {
				int sum_clients = resultSet.getInt("sum");
				Date date = resultSet.getDate("date");
				String branch_id = resultSet.getString("branch_id");
				//"Client_Sum\tDate\tBranch\n+++++++++++++++++++++++++++\n"+
				resultString.add("        "+sum_clients+"               "+date+"           "+branch_id);
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
