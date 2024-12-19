import java.util.Arrays;
import java.util.Scanner;

public class RedixSort {

    // A utility function to get the maximum value in an array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // A function to do counting sort of array according to the digit represented by exp
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array, so that array now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // The main function to that sorts array[] of size n using Radix Sort
    public static void radixSort(int[] array) {
        // Find the maximum number to know the number of digits
        int max = getMax(array);

        // Do counting sort for every digit. Note that instead of passing the digit number, exp is passed. exp is 10^i where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
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

        // Sorting the array using Radix Sort
        radixSort(array);

        System.out.println("Sorted Array:");
        printArray(array);

        scanner.close();
    }
}
