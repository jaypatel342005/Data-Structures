import java.util.Scanner;

public class SumSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int sum = 0;
        int currentTerm = 0;

        for (int i = 1; i <= n; i++) {
            // Calculate the current term (1+2+3+...+i)
            currentTerm += i;

            // Add the current term to the sum
            sum += currentTerm;
        }

        System.out.println("The sum of the series is: " + sum);
        scanner.close();
    }
}
