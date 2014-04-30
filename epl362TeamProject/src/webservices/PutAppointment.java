package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PutAppointment {
	public int put_appointment(String client_id, String lawyer_id, String date,String branch_id) {
		int i=0;
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			boolean ret=con.prepareStatement("INSERT INTO `client`(`ID`) VALUES (1111)").execute();
//			String insertTableSQL = "INSERT INTO appointments"
//					+ "(client_id) VALUES"
//					+ "(?)";
//			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
//			preparedStatement.setString(1, "test");
//			int ret =preparedStatement .executeUpdate();
			
			con.close();
			return 1;		
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {			
			e.printStackTrace();
			return -1;
		}
		return 2;
	}
}
