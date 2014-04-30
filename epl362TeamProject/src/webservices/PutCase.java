package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PutCase {

	public int put_case(String client_id, String lawyer_id, String date_open,String date_close,String type,int risk) {
		int i=0;
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			boolean ret=con.prepareStatement("INSERT INTO `case`(`client_id`,`legal_id`,`date_open`,`date_close`,`type`,`risk`) VALUES (client_id,lawyer_id,date_open,date_close,type,risk)").execute();
			
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
