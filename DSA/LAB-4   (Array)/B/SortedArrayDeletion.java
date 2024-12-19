import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to delete: ");
        int num = scanner.nextInt();

        System.out.println("Original Array: " + Arrays.toString(arr));

        /* Find the position of the number to delete */
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Number not found in the array.");
        } else {
            /* Execute a loop to shift all elements left by 1 position
               starting from the position of the number to delete */
            for (int i = pos; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--; // Decrease the size of the array

            System.out.println("Array after deletion: " + Arrays.toString(Arrays.copyOf(arr, n)));
        }
    }
}
