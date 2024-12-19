import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        
        if (number % 2 == 0) { // Check if the number is even or odd
            System.out.println("The number " + number + " is even.");
        } else {
            System.out.println("The number " + number + " is odd.");
        }
        scanner.close();

    }
}
