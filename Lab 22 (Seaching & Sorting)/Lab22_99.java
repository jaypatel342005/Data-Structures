// 99. Write a program to implement Shell Sort using Array.


import java.util.Scanner;


 class Lab21_99 {

    // Function to swap two elements in an array
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Function to implement Shell Sort
    static void shellSort(int[] array, int n) {
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            for (int j = gap; j < n; j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (array[i + gap] > array[i]) {
                        break;
                    } else {
                        swap(array, i + gap, i);
                    }
                }
            }
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

        // Sort the array using Shell Sort
        shellSort(array, n);

        System.out.println("Sorted array:");
        printArray(array);

        scanner.close();
    }
}
