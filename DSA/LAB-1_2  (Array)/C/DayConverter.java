import java.util.Scanner;

public class DayConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int totalDays = scanner.nextInt();

        int years = totalDays / 365;
        int remainingDays = totalDays % 365;
        int weeks = remainingDays / 7;
        int days = remainingDays % 7;

        System.out.printf("%d days mean %d year(s), %d week(s), and %d day(s).\n", 
            totalDays, years, weeks, days);
        scanner.close();

    }
}
