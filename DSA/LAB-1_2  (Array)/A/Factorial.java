import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        
        long factorial = 1; // Initialize the factorial result to 1

        for (int i = 1; i <= number; i++) { // Calculate the factorial using a for loop
            factorial *= i;
        }

        System.out.println("The factorial of " + number + " is: " + factorial);
        scanner.close();
    }
}
