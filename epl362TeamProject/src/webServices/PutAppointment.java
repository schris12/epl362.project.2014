package webServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PutAppointment {
	public int put_appointment(int client_id, int lawyer_id, String date, int branch_id) {

		String dbtime;
		String dbUrl = "jdbc:mysql://localhost:3306/362";
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root",
					"");
			
			String insertTableSQL = "INSERT INTO appointments"
					+ "(client_id, lawyer_id, date, branch_id) VALUES"
					+ "(?,?,?,?)";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, client_id);
			preparedStatement.setInt(2, lawyer_id);
			preparedStatement.setString(3, date);
			preparedStatement.setInt(4, branch_id);
			int ret = preparedStatement.executeUpdate();
			
			con.close();
			return ret;	

			
		} // end try

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
