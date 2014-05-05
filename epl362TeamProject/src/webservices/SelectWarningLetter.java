package webservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;

public class SelectWarningLetter {
	public LinkedList<String> select_warning_letter(int client_idd) {
		try {
			LinkedList<String> resultString = new LinkedList<String>();
			Connection connect = null;
			Statement statement = null;
			ResultSet resultSet = null;

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager					.getConnection("jdbc:mysql://localhost/362?"
							+ "user=root&password=");
			HashSet<String> select_warning=new HashSet<String>();
			LinkedList<String> tmp=new LinkedList<String>();
			String s="select * from `case` WHERE (`client_id`="+client_idd+")";
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery(s);
			while (resultSet.next()) {
				String lawyer_id = resultSet.getString("legal_id");
				select_warning.add("Lawyer: "+lawyer_id);
				tmp.add(lawyer_id);
			}
			for(String str : tmp){
				s="select * from `case` WHERE (`legal_id`="+str+")";
				statement = connect.createStatement();
				resultSet = statement
						.executeQuery(s);
				while (resultSet.next()) {
					String client_id = resultSet.getString("client_id");
					resultString.add("Client: "+client_id);
				}
			}
			
			connect.close();			
			LinkedList<String> toReturn=new LinkedList<String>();
			for(String str : select_warning){
				toReturn.add(str);
			}			
			return toReturn;			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
