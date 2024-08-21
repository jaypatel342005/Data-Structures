// Write a program to find factors of a given number. 

import java.util.Scanner;

public class Lab1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer to find its factors: ");
        int number = scanner.nextInt();

        System.out.println("Factors of " + number + " are:");
        for (int i = 1; i <= number; ++i) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}

