package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteCase {
	public int delete_case(int id) {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String deleteSQL = "DELETE FROM `case` WHERE case_id=?";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
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
