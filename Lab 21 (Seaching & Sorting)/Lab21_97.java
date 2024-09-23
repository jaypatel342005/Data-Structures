// 97. Write a program to implement Quick Sort using Array. 


import java.util.Scanner;


import java.util.Scanner;

 class Lab21_97 {

    // Function to swap two elements in the array
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Partition function that picks the last element as the pivot
    static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Pivot element
        int i = (low - 1);  // Index of smaller element

        // Reorder elements based on the pivot
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Place the pivot in its correct position
        swap(array, i + 1, high);
        return i + 1;  // Return the partition index
    }

    // Main function to implement Quick Sort
    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array around the pivot
            int pi = partition(array, low, high);

            // Recursively sort elements before and after the partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

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

        // Sort the array using Quick Sort
        quickSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(array);

        scanner.close();
    }
}
