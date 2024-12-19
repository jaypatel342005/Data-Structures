import java.util.Scanner;

public class ShellSort {

    // Function to sort an array using Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Add array[i] to the elements that have been gap sorted
                // save array[i] in temp and make a hole at position i
                int temp = array[i];

                // shift earlier gap-sorted elements up until the correct location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }
    }

    // A utility function to print an array
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original Array:");
        printArray(array);

        // Sorting the array using Shell Sort
        shellSort(array);

        System.out.println("Sorted Array:");
        printArray(array);

        scanner.close();
    }
}
