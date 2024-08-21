// 91. Write a program to implement a Binary Search using Array. 

import java.util.Scanner;

public class Lab18_91 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        
        int[] array = new int[size];

        
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the element to search for: ");
        int key = scanner.nextInt();

        
        int left = 0;
        int right = array.length - 1;
        int result = -1; 

        while (left <= right) {
            int mid = left + (right - left) / 2;

            
            if (array[mid] == key) {
                result = mid;
                break;
            }

            
            if (array[mid] < key) {
                left = mid + 1;
            } else { 
                right = mid - 1;
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
