// Write a program to determine whether the entered character is vowel or not. 

import java.util.Scanner;

public class Lab1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String input = scanner.next().toLowerCase();
        char ch = input.charAt(0);

        switch(ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch + " is a vowel.");
                break;
            default:
                System.out.println(ch + " is not a vowel.");
        }

        scanner.close();
    }
}
