package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EditCase {

	public int edit_case(String case_id,String client_id, String lawyer_id, String date_open,String date_close,String type,int risk) {
		int i=0;
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String insertTableSQL = "UPDATE `case` SET `client_id`=?,`legal_id`=?,"
					+ "`date_open`=?,`date_close`=?,`risk`=?,`type`=? WHERE case_id=?";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, client_id);
			preparedStatement.setString(2, lawyer_id);
			preparedStatement.setString(3, date_open);
			preparedStatement.setString(4, date_close);
			preparedStatement.setString(5, type);
			preparedStatement.setInt(6, risk);
			preparedStatement.setString(7, case_id);
			int ret = preparedStatement.executeUpdate();
			
//			boolean ret=con.prepareStatement("UPDATE `case` SET `client_id`=?,`legal_id`=?,`date_open`=?,`date_close`=?,`risk`=?,`type`=? WHERE case_id=?").execute();
			
			con.close();
			return ret;		
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
