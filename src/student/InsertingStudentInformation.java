package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.Myconnection;

public class InsertingStudentInformation {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;

	public static void main(String[] args) {
		try {
			// Establish database connection
			con = Myconnection.connect();

			// Prepare SQL insert query
			String sql = "INSERT INTO STUDENT (SID, SNAME, AGE) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			// Take input from user
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter the student SID: ");
			int sid = sc.nextInt();
			sc.nextLine(); // consume newline

			System.out.print("Enter the student name: ");
			String sname = sc.nextLine();

			System.out.print("Enter the student age: ");
			int age = sc.nextInt();

			// Set the input into the query
			pstmt.setInt(1, sid);
			pstmt.setString(2, sname);
			pstmt.setInt(3, age);

			// Execute query
			int n = pstmt.executeUpdate();

			System.out.println("(" + n + ") row(s) inserted successfully.");

			// Close Scanner
			sc.close();
		} catch (SQLException e) {
			System.out.println("❌ Error while inserting student information.");
			e.printStackTrace();
		} finally {
			// Close DB resources
			Myconnection.close(res, pstmt, con);
		}
	}
}
