package day2;
public class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    public Employee(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getEmployeeDetails() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Salary: " + sal + ", Years Worked: " + yearsWorked);
    }

    public void getLoanEligibility() {
        if (yearsWorked > 5) {
            if (sal >= 1500000) System.out.println(empName + " is eligible for a loan of 7 lakhs.");
            else if (sal >= 1000000) System.out.println(empName + " is eligible for a loan of 5 lakhs.");
            else if (sal >= 600000) System.out.println(empName + " is eligible for a loan of 2 lakhs.");
            else System.out.println(empName + " is not eligible for a loan.");
        } else {
            System.out.println(empName + " is not eligible for a loan due to insufficient years of service.");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Abhishek", 1200000, 6);
        emp1.getEmployeeDetails();
        emp1.getLoanEligibility();

        Employee emp2 = new Employee(102, "Sandeep", 800000, 7);
        emp2.getEmployeeDetails();
        emp2.getLoanEligibility();
    }
}
