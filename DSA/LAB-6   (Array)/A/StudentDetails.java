import java.util.Scanner;

class Student_Detail {
    int enrollmentNo;
    String name;
    int semester;
    double cpi;



    public void getDetail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enrollment No: ");
        enrollmentNo = scanner.nextInt();
        // Consume the newline character

        System.out.print("Name: ");
        name = scanner.nextLine();

        System.out.print("Semester: ");
        semester = scanner.nextInt();

        System.out.print("CPI: ");
        cpi = scanner.nextDouble();

    }

    public void printDetails() {
        System.out.println("Enrollment No: " + enrollmentNo);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
        System.out.println("CPI: " + cpi);
        System.out.println();
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student_Detail[] s = new Student_Detail[5];

        for (int i = 0; i < s.length; i++) {
            System.out.println("Enter information for Student " + (i + 1) + ":");
            s[i] = new Student_Detail();
            s[i].getDetail();
        }
        System.out.println("\nStudent Details:");
        for (int i = 0; i < s.length; i++) {
            s[i].printDetails();
        }
    }
}
