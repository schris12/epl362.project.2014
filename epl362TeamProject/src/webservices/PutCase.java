package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PutCase {
	public int put_case(String client_id, String lawyer_id, String date_open, String date_close, int type, int risk) throws ParseException {
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root", "");

			String insertTableSQL = "INSERT INTO `case` "
					+ "(`client_id`, `legal_id`, `date_open`, `date_close`, `type`, `risk`) VALUES "
					+ "(?,?,?,?,?,?)";
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, client_id);
			preparedStatement.setString(2, lawyer_id);
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date_open);
			System.out.println(utilDate);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			System.out.println(sqlDate);
			preparedStatement.setDate(3, sqlDate);
			java.util.Date utilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(date_close);
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			preparedStatement.setDate(4, sqlDate1);
			preparedStatement.setInt(5, type);
			preparedStatement.setInt(6, risk);

			int ret = preparedStatement.executeUpdate();

			con.close();
			return ret;
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
