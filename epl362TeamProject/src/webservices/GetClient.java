package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetClient {
	public String put_client(String id, String name, String surname) {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String returnSQL = "SELECT * FROM client";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(returnSQL);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()){
//				set.get
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
