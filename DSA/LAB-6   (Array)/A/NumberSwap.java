//  However, since Java passes arguments by value,
// the changes made inside the method do not affect the original variables in the main method.
import java.util.Scanner;

public class NumberSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.println("Before swapping:");
        System.out.println("First number: " + number1);
        System.out.println("Second number: " + number2);

        swapNumbers(number1, number2);
    }

    public static void swapNumbers(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("Swapped numbers inside the method:");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
    }
}
