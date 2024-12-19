import java.util.Scanner;

public class DuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        boolean hasDuplicate = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] == numbers[j]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                break;
            }
        }

        if (hasDuplicate) {
            System.out.println("The array contains a duplicate number.");
        } else {
            System.out.println("The array does not contain a duplicate number.");
        }

    }
}
