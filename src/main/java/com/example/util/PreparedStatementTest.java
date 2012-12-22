package main.java.com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {

	public static void main(String[] aggs) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "root";
		String password = "123456";
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection .prepareStatement("SELECT * FROM account WHERE ?");
			preparedStatement.setString(0, "username='leon'");
			System.out.println(preparedStatement.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
