import java.util.Scanner;

public class Lab4_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] array = new int[size];

        // Get the elements of the array from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Remove duplicates and get the new array
        int[] newArray = removeDuplicates(array, size);
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    public static int[] removeDuplicates(int[] array, int size) {
        // Create a new array to store the unique elements
        int[] tempArray = new int[size];
        int newSize = 0;

        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < newSize; j++) {
                if (array[i] == tempArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                tempArray[newSize++] = array[i];
            }
        }

        // Create a result array of the correct size
        int[] resultArray = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            resultArray[i] = tempArray[i];
        }

        return resultArray;
    }
}
