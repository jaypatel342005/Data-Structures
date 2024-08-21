// Write a program to find factorial of a number. 


import java.util.Scanner;

public class Lab1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        if (number >= 0) {
            int factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a non-negative integer.");
        }

        scanner.close();
    }

    public static int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
