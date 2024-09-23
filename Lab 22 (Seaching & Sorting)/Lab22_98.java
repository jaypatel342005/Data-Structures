// 98. Write a program to implement Heap Sort using Array.

import java.util.Scanner;

public class Lab22_98 {

    // Function to heapify a subtree rooted with node i, n is the size of the heap
    static void heapify(int[] array, int n, int i) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // Left child
        int right = 2 * i + 2;   // Right child

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    // Function to swap two elements
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Function to implement Heap Sort
    static void heapSort(int[] array, int n) {
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            swap(array, 0, i);

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // Function to print an array
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        printArray(array);

        // Sort the array using Heap Sort
        heapSort(array, n);

        System.out.println("Sorted array:");
        printArray(array);

        scanner.close();
    }
}

