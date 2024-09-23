// 95. Write a program to implement Radix Sort using Array.

import java.util.Arrays;
import java.util.Scanner;

 class lab20_95 {

    // A utility function to get the maximum value in an array
    static int getMax(int[] array, int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // A function to perform counting sort based on a significant digit
    static void countingSort(int[] array, int n, int exp) {
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array to store the count of occurrences of digits

        // Initialize count array as 0
        Arrays.fill(count, 0);

        // Store the count of occurrences in the count array
        for (int i = 0; i < n; i++) {
            int index = (array[i] / exp) % 10;
            count[index]++;
        }

        // Change count[i] so that it contains the actual position of the digit in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array using the count array
        for (int i = n - 1; i >= 0; i--) {
            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers based on the current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    // The main function to implement Radix Sort
    static void radixSort(int[] array, int n) {
        // Find the maximum number to know the number of digits
        int max = getMax(array, n);

        // Do counting sort for every digit. Instead of passing the digit number, exp is passed.
        // exp is 10^i where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, n, exp);
        }
    }

    // A utility function to print an array
    static void printArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Driver program to test the Radix Sort implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take dynamic input for the array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Take dynamic input for array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        printArray(array, n);

        // Perform Radix Sort
        radixSort(array, n);

        System.out.println("Sorted array:");
        printArray(array, n);

        scanner.close();
    }
}
