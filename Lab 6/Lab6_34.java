import java.util.Scanner;

class Employee_Detail {
    private int employeeID;
    private String name;
    private String designation;
    private double salary;

    // Constructor to initialize attributes
    public Employee_Detail(int employeeID, String name, String designation, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: $" + salary);
    }
}

public class Lab6_34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int empID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String empDesignation = scanner.nextLine();

        System.out.print("Enter Salary: $");
        double empSalary = scanner.nextDouble();

        // Create an Employee_Detail object
        Employee_Detail employee = new Employee_Detail(empID, empName, empDesignation, empSalary);

        // Display employee details
        System.out.println("\nEmployee Details:");
        employee.displayDetails();

        scanner.close();
    }
}
