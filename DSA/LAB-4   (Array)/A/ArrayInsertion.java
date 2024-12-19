import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size+1];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the number to insert: ");
        int numberToInsert = sc.nextInt();

        System.out.print("Enter the index at which to insert the number: ");
        int insertIndex = sc.nextInt();

        System.out.println("Original Array: " + Arrays.toString(array));

        // Shift elements to the right from insertIndex onwards
        for (int i = size - 1; i >= insertIndex; i--) {
            array[i+1] = array[i];
        }

        // Insert the number at the insertIndex
        array[insertIndex] = numberToInsert;

        System.out.println("Array after insertion: " + Arrays.toString(array));

    }
}
// import java.util.Arrays;
// import java.util.Scanner;

// public class ArrayInsertion {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the size of the array: ");
//         int size = scanner.nextInt();
//         int[] array = new int[size];

//         System.out.println("Enter the elements of the array:");
//         for (int i = 0; i < size; i++) {
//             System.out.print("Element " + (i+1) + ": ");
//             array[i] = scanner.nextInt();
//         }

//         System.out.print("Enter the number to insert: ");
//         int numberToInsert = scanner.nextInt();

//         System.out.print("Enter the index at which to insert the number: ");
//         int insertIndex = scanner.nextInt();

//         System.out.println("Original Array: " + Arrays.toString(array));

//         int[] newArray = new int[size + 1];

//         // Copy elements to the new array before the insert index
//         for (int i = 0; i < insertIndex; i++) {
//             newArray[i] = array[i];
//         }

//         // Insert the new element
//         newArray[insertIndex] = numberToInsert;

//         // Copy elements to the new array after the insert index
//         for (int i = insertIndex; i < size; i++) {
//             newArray[i + 1] = array[i];
//         }

//         System.out.println("Array after insertion: " + Arrays.toString(newArray));

//     }
// }
