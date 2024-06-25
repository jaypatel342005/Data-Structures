import java.util.Scanner;

class Student_Detail {
    private int enrollmentNo;
    private String name;
    private int semester;
    private double cpi;

    
    public Student_Detail(int enrollmentNo, String name, int semester, double cpi) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.semester = semester;
        this.cpi = cpi;
    }

    
    public void displayDetails() {
        System.out.println("Enrollment No: " + enrollmentNo);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
        System.out.println("CPI: " + cpi);
        System.out.println(); 
    }
}



public class Lab6_35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Student_Detail[] students = new Student_Detail[5];

        
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Enrollment No: ");
            int enrollmentNo = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Semester: ");
            int semester = scanner.nextInt();

            System.out.print("CPI: ");
            double cpi = scanner.nextDouble();

            
            students[i] = new Student_Detail(enrollmentNo, name, semester, cpi);
        }

        
        System.out.println("\nStudent Details:");
        for (Student_Detail student : students) {
            student.displayDetails();
        }

        scanner.close();
    }
}
