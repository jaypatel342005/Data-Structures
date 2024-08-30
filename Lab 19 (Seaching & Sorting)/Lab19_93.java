// 93. Write a program to implement Insertion Sort using Array.

import java.util.Scanner;

public class Lab19_93 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Array before sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        // insertion Sort
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        // for (int i = 1; i < size; i++) {
        //     for (int j = i; j > 0; j--) {
        //         if (array[j] < array[j - 1]) {
        //             // Swap the elements
        //             int temp = array[j];
        //             array[j] = array[j - 1];
        //             array[j - 1] = temp;
        //         } else {
        //             break; // Break the loop if the correct position is found
        //         }
        //     }
        // }

        System.out.println("\nArray after sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
