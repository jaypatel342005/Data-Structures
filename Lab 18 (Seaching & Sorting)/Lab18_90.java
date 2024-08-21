// 90. Write a program to implement a Linear Search using Array

import java.util.Scanner;

public class Lab18_90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        
        int[] array = new int[size];

        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the element to search for: ");
        int key = scanner.nextInt();

        
        int result = -1; 
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                result = i;
                break;
            }
        }

        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        
        scanner.close();
    }
}
