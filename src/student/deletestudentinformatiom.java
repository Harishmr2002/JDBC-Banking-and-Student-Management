package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.Myconnection;

public class deletestudentinformatiom {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	private static PreparedStatement pstmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		con =Myconnection.connect();
		
		String sql="DELETE FROM STUDENT WHERE SID=?";
		pstmt= con.prepareStatement(sql);		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student sid:");
		pstmt.setInt(1, sc.nextInt());     
		sc.nextLine();
		
		int n = pstmt.executeUpdate();                

		
		//Process the resultSet
			System.out.println("("+n+") rows affected");
		
		
		
		//Close the Connection
		Myconnection.close(res,pstmt,con);
		
	}

}
