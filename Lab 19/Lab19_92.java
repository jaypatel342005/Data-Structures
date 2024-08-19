// 92. Write a program to implement Bubble using Array.


import java.util.Scanner;

public class Lab19_92{
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
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        
        System.out.println("Sorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        
        scanner.close();
    }
}
