//Write a program to find power of a number using loop. 

import java.util.Scanner;

public class Lab1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        double base = scanner.nextDouble();
        System.out.print("Enter the exponent (positive integer): ");
        int exponent = scanner.nextInt();

        double result = 1;
        if (exponent >= 0) {
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            System.out.println(base + " raised to the power of " + exponent + " is " + result);
        } else {
            System.out.println("Please enter a non-negative integer for the exponent.");
        }

        scanner.close();
    }
}
