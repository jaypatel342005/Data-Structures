import java.util.Scanner;

public class Lab4_24 {
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

        // Get the element to be deleted from the user
        System.out.print("Enter the element to be deleted: ");
        int element = scanner.nextInt();

        // Delete the element and get the new array
        int[] newArray = deleteFromSortedArray(sortedArray, element);
        
        // Print the new array
        System.out.println("New array after deletion:");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    public static int[] deleteFromSortedArray(int[] array, int element) {
        int size = array.length;
        int count = 0;

        // Check if the element to be deleted exists in the array
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                count++;
            }
        }

        // If the element does not exist in the array, return the original array
        if (count == 0) {
            return array;
        }

        // Create a new array with a size reduced by the count of the element to be deleted
        int[] newArray = new int[size - count];
        int index = 0;

        // Copy elements from the original array to the new array, skipping the element to be deleted
        for (int i = 0; i < size; i++) {
            if (array[i] != element) {
                newArray[index++] = array[i];
            }
        }

        return newArray;
    }
}
