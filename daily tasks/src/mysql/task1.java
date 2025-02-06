package mysql;
import java.sql.*;
import java.util.Scanner;

public class task1 {
public static void main(String args[]) throws Exception,SQLException {
	Scanner scan = new Scanner(System.in);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","tiger");
	PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?)");
	System.out.print("Enter the number of employees to insert: ");
    int numRows = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numRows; i++) {
	System.out.println("Enter the Employee "+(i+1)+" Id:");
	int empId;
	empId=scan.nextInt();
	
	System.out.println("Enter the Employee Name");
	String empName;
	empName=scan.next();
	pstmt.setInt(1, empId);
	pstmt.setString(2, empName);
	pstmt.addBatch();
    }
	int[] value = pstmt.executeBatch();
	System.out.println(value.length + " Rows inserted into the table");
	
	pstmt.close();
	con.close();
  }
}
