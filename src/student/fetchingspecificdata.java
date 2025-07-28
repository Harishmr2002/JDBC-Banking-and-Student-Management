package student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.Myconnection;

public class fetchingspecificdata {

	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	private static PreparedStatement pstmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		con =Myconnection.connect();
		
		String sql="select *from student where sid=?";
		pstmt= con.prepareStatement(sql);		
		
		System.out.println("Enter the student sid:");
		pstmt.setInt(1, new Scanner(System.in).nextInt());                      
		res = pstmt.executeQuery();                

		if(res.next()) {
		//Process the resultSet
			System.out.println(res.getInt("sid")+"  "+res.getString("sname")+" "+res.getString("age"));
		}
		else {
			System.out.println("No data found");
		}
		//Close the Connection
		Myconnection.close(res,pstmt,con);
		
	}

}
