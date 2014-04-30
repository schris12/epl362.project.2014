package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PutAppointment {
	public int put_appointment(String client_id, String lawyer_id, String date, String branch_id) throws ParseException {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root","");

			String insertTableSQL = "INSERT INTO appointments"
			+ "(client_id, lawyer_id, date, missed, branch_id) VALUES"
			+ "(?,?,?,?,?)";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, client_id);
			preparedStatement.setString(2, lawyer_id);
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setString(5, branch_id);
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
