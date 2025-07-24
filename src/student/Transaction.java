package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.Myconnection;

public class Transaction {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	private static PreparedStatement pstmt;
	static int n=0;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		con =Myconnection.connect();
		
		String sql="INSERT INTO STUDENT (SID,SNAME,AGE) VALUES(?,?,?)";
		pstmt= con.prepareStatement(sql);		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("How money students do u want to enter");
		int number = sc.nextInt();
		con.setAutoCommit(false);
		
		for(int i=0;i<number;i++) {
			System.out.println("Enter the student sid:");
			pstmt.setInt(1, sc.nextInt());     
			sc.nextLine();
			System.out.println("Enter the student sname:");
			pstmt.setString(2, sc.nextLine()); 
			
			System.out.println("Enter the student age:");
			pstmt.setInt(3, sc.nextInt()); 
			
		 n = n+pstmt.executeUpdate();                

			
		}
		con.commit();
	
		//Process the resultSet
			System.out.println("("+n+") rows affected");
		
		
		
		//Close the Connection
		Myconnection.close(res,pstmt,con);
		
	}

}
