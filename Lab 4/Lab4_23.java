import java.util.Scanner;

public class Lab4_23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the sorted array from the user
        System.out.print("Enter the size of the sorted array: ");
        int size = scanner.nextInt();

        // Initialize the sorted array
        int[] sortedArray = new int[size];
        
        // Get the elements of the sorted array from the user
        System.out.println("Enter the elements of the sorted array in ascending order:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value of "+i+" element : ");
            sortedArray[i] = scanner.nextInt();
        }

        // Get the element to be inserted from the user
        System.out.print("Enter the element to be inserted: ");
        int element = scanner.nextInt();

        // Insert the element and get the new array
        int[] newArray = insertIntoSortedArray(sortedArray, element);
        
        // Print the new array
        System.out.println("New array after insertion:");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    public static int[] insertIntoSortedArray(int[] array, int element) {
        int size = array.length;
        int[] newArray = new int[size + 1];
        int i = 0;

        // Copy elements from the original array to the new array until the insertion point is found
        while (i < size && array[i] < element) {
            newArray[i] = array[i];
            i++;
        }

        // Insert the new element
        newArray[i] = element;

        // Copy the remaining elements from the original array to the new array
        while (i < size) {
            newArray[i + 1] = array[i];
            i++;
        }

        return newArray;
    }
}

