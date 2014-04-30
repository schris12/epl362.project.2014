package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PutClient {
	public int put_client(String id, String name, String surname) {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String insertTableSQL = "INSERT INTO client"
			+ "(client_id, name, surname) VALUES"
			+ "(?,?,?)";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			int ret = preparedStatement.executeUpdate();
			
			con.close();
			return ret;		
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {			
			e.printStackTrace();
		}
		return -1;
	}
}
