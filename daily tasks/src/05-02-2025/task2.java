package mysql;
import java.sql.*;
import java.util.Scanner;

public class task2 {
public static void main(String args[]) throws Exception,SQLException {
	Scanner scan = new Scanner(System.in);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","tiger");
	
	System.out.println("Enter the Employee Id to be updated");
	int eid;
	eid=scan.nextInt();
	
	System.out.println("Enter the Employee Name:");
	String ename;
	ename=scan.next();
	
	PreparedStatement pstmt = con.prepareStatement("update employee set ename=? where eid=?");
	pstmt.setString(1, ename);
	pstmt.setInt(2, eid);
	int value = pstmt.executeUpdate();
	if(value>0)
	System.out.println("employee details updated successfully");
	else
		 System.out.println("No employee found with ID: " + eid);
	pstmt.close();
	con.close();
  }
}
