package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteLawyer {
	public int delete_lawyer(String id) {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String deleteSQL = "DELETE FROM lawyer WHERE lawyer_id=?";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(deleteSQL);
			preparedStatement.setString(1, id);
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
