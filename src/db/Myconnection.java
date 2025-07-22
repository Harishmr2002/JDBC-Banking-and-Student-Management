package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Myconnection {
	// create connection function
	public static Connection connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/skyllx", "root", "system");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// create close function
	public static void close(ResultSet res, Statement stmt, Connection con) {
		try {
			if (res != null) {
//					System.out.println("Connection is established");
			} else {
				System.out.println("Not need to close");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		try {
			if (stmt != null) {
//					System.out.println("Connection is ehtablished");
			} else {
				System.out.println("Not need to close");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			if (con != null) {
//					System.out.println("Connection is established");
			} else {
				System.out.println("Not need to close");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
