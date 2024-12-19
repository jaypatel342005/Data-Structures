import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int smallest = numbers[0];
        int position = 0;

        for (int i = 1; i < n; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
                position = i;
            }
        }

        System.out.println("The position of the smallest number is: " + position);

    }
}
