import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element: ");
            arr[i] = sc.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        // Count duplicates
        int duplicate_count = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i - 1] == arr[i]) {
                duplicate_count++;
            }
        }

        //  Create new array for distinct elements
        int distinct_count = size - duplicate_count;
        int[] distinct_array = new int[distinct_count];

        // Populate the new array with distinct elements
        
        for (int i = 0,j=0; i < size; i++) {
            // Check if this is the last element or the next element is different
            if (i == size - 1 || arr[i] != arr[i + 1]) {
                distinct_array[j++] = arr[i];
            }
        }

        //  Print the distinct elements
        System.out.println("Array after removing duplicates: ");
        for (int i = 0; i < distinct_array.length; i++) {
            System.out.println("Element is: " + distinct_array[i]);
        }
    }
}
