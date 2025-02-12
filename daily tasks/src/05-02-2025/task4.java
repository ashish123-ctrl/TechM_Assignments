package mysql;
import java.sql.*;
import java.util.Scanner;

public class task4 {
public static void main(String args[]) throws Exception,SQLException {
	Scanner scan = new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","tiger");
	boolean exit = false;
	PreparedStatement pstmt = null;
    while (!exit) {
        System.out.println("\nMenu:");
        System.out.println("1. Insert a new Row");
        System.out.println("2. Update a Row");
        System.out.println("3. Delete a Row");
        System.out.println("4. Select a Row");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        //scan.nextLine();  

        switch (choice) {
            case 1:  
                System.out.println("Enter Employee Details to Insert");
                System.out.print("Enter Employee ID: ");
                int id = scan.nextInt();
                scan.nextLine(); // Consume newline
                System.out.print("Enter Employee Name: ");
                String name = scan.nextLine();

                pstmt = con.prepareStatement("INSERT INTO employee (eid, ename) VALUES (?, ?)");
                pstmt.setInt(1, id);
                pstmt.setString(2, name);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Employee added successfully!");
                } else {
                    System.out.println("Failed to add employee.");
                }
                break;

            case 2: 
                System.out.print("Enter Employee ID to Update: ");
                id = scan.nextInt();
                
                System.out.print("Enter new Employee Name: ");
                name = scan.nextLine();
               
                pstmt = con.prepareStatement("UPDATE employee SET ename = ? WHERE eid = ?");
                pstmt.setString(1, name);
                pstmt.setInt(2, id);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Employee details updated successfully!");
                } else {
                    System.out.println("No employee found with ID " + id);
                }
                break;

            case 3:  
                System.out.print("Enter Employee ID to Delete: ");
                id = scan.nextInt();

                pstmt = con.prepareStatement("DELETE FROM employee WHERE eid = ?");
                pstmt.setInt(1, id);

                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Employee with ID " + id + " deleted successfully!");
                } else {
                    System.out.println("No employee found with ID " + id);
                }
                break;

            case 4: 
                System.out.print("Enter Employee ID to Select: ");
                id = scan.nextInt();

                pstmt = con.prepareStatement("SELECT * FROM employee WHERE eid = ?");
                pstmt.setInt(1, id);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Employee Details:");
                    System.out.println("ID: " + rs.getInt("eid"));
                    System.out.println("Name: " + rs.getString("name"));
                      } else {
                    System.out.println("No employee found with ID " + id);
                }
                break;

            case 5:  // Exit
                System.out.println("Exiting...");
                exit = true;
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    pstmt.close();
	con.close();
	
	
}
}