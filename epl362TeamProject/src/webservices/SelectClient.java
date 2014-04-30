package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectClient {
	public String select_client() {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String returnSQL = "SELECT * FROM client";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(returnSQL);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()){
				String client_id = set.getString("client_id");
				String name = set.getString("name");
				String surname = set.getString("surname");
//				String retu = 
			}
			con.close();
			return "";		
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {			
			e.printStackTrace();
		}
		return "NULL";
	}
}
