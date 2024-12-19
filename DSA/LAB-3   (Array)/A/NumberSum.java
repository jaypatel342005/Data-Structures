import java.util.Scanner;

public class NumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting number (m): ");
        int m = sc.nextInt();

        System.out.print("Enter the ending number (n): ");
        int n = sc.nextInt();

        int sum = 0;

        for (int i = m; i <= n; i++) {
            sum += i;
        }

        System.out.println("The sum of numbers from " + m + " to " + n + " is: " + sum);
    
        sc.close();

    }
}
