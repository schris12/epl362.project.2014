package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PutCase {

	public int put_case(String client_id, String lawyer_id, String date_open,
			String date_close, String type, int risk) throws ParseException {
		int i = 0;
		String dbUrl = "jdbc:mysql://localhost/362";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, "root", "");

			String insertTableSQL = "INSERT INTO case"
					+ ""
					+ "(client_id,legal_id,date_open,date_close,type,risk) VALUES"
					+ "(?,?,?,?,?,?)";
			java.sql.PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, client_id);
			preparedStatement.setString(2, lawyer_id);
			preparedStatement.setString(5, type);
			preparedStatement.setInt(6, risk);
			java.util.Date utilDate_o;
			utilDate_o = new SimpleDateFormat("yyyy-MM-dd").parse(date_open);
			java.sql.Date sqlDate_o = new java.sql.Date(utilDate_o.getTime());
			preparedStatement.setDate(3, sqlDate_o);
			java.util.Date utilDate_c;
			utilDate_c = new SimpleDateFormat("yyyy-MM-dd").parse(date_close);
			java.sql.Date sqlDate = new java.sql.Date(utilDate_c.getTime());
			preparedStatement.setDate(4, sqlDate);

			int ret = preparedStatement.executeUpdate();

			con.close();
			return 1;
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 2;
	}

}
