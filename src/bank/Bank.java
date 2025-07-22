package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.Myconnection;

public class Bank {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your account number:");
		int account = sc.nextInt();

		System.out.println("Enter your PIN:");
		int pin = sc.nextInt();

		con = Myconnection.connect();

		String sql = "SELECT * FROM accounts WHERE accountN0 = ? AND pin = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setInt(2, pin);

		res = pstmt.executeQuery();

		if (res.next()) {
			String userName = res.getString("name");
			int balance = res.getInt("balance");

			System.out.println("Welcome " + userName);
			System.out.println("1. Check Balance\n2. Transfer Money");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Balance is: ₹" + balance);
				break;

			case 2:
				System.out.println("Enter receiver's account number:");
				int receiverAcc = sc.nextInt();

				if (receiverAcc == account) {
					System.out.println("Cannot transfer to the same account.");
					break;
				}

				// Fetch receiver name
				String receiverQuery = "SELECT name FROM accounts WHERE accountN0 = ?";
				PreparedStatement receiverStmt = con.prepareStatement(receiverQuery);
				receiverStmt.setInt(1, receiverAcc);
				ResultSet receiverRes = receiverStmt.executeQuery();

				if (!receiverRes.next()) {
					System.out.println("Receiver account not found.");
					break;
				}

				String receiverName = receiverRes.getString("name");
				System.out.println("Receiver Name: " + receiverName);

				System.out.println("Enter amount to transfer:");
				int amount = sc.nextInt();

				if (amount <= 0 || amount > balance) {
					System.out.println("Invalid or insufficient amount.");
					break;
				}

				try {
					con.setAutoCommit(false);

					// Deduct from sender
					String sql1 = "UPDATE accounts SET balance = balance - ? WHERE accountN0 = ?";
					PreparedStatement deduct = con.prepareStatement(sql1);
					deduct.setInt(1, amount);
					deduct.setInt(2, account);
					int x = deduct.executeUpdate();

					// Add to receiver
					String sql2 = "UPDATE accounts SET balance = balance + ? WHERE accountN0 = ?";
					PreparedStatement credit = con.prepareStatement(sql2);
					credit.setInt(1, amount);
					credit.setInt(2, receiverAcc);
					int y = credit.executeUpdate();

					if (x > 0 && y > 0) {
						con.commit();
						System.out.println(
								"₹" + amount + " transferred to " + receiverName + " (Acc No: " + receiverAcc + ")");
					} else {
						con.rollback();
						System.out.println("Transaction failed. Rolled back.");
					}

					deduct.close();
					credit.close();

				} catch (SQLException e) {
					con.rollback();
					System.out.println("Error during transfer. Transaction rolled back.");
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Invalid choice.");
			}
		} else {
			System.out.println("Invalid credentials.");
		}

		sc.close();
		Myconnection.close(res, pstmt, con);
	}
}