package mysql;
import java.sql.*;
import java.util.Scanner;

public class task3 {
public static void main(String args[]) throws Exception,SQLException {
	Scanner scan = new Scanner(System.in);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","tiger");
	
	System.out.println("Enter the Employee Id to be deleted");
	int eid;
	eid=scan.nextInt();
	
	
	PreparedStatement pstmt = con.prepareStatement("delete from employee where eid=?");
	pstmt.setInt(1, eid);
	int value = pstmt.executeUpdate();
	if(value>0)
	System.out.println("employee with id:"+eid+" details deleted successfully");
	else
		 System.out.println("No employee found with ID: " + eid);
	pstmt.close();
	con.close();
  }
}
