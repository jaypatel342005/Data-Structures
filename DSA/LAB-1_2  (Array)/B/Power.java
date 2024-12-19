import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the exponent: ");
        int exponent = scanner.nextInt();

        double result = 1;

        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }


        if (exponent < 0) {
            result = 1 / result;
        }

        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
        scanner.close();
    }
}
