import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeletion {
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

        System.out.print("Enter the index of the number to delete: ");
        int deleteIndex = scanner.nextInt();

        System.out.println("Original Array: " + Arrays.toString(array));

        if (deleteIndex < 0 || deleteIndex >= size) {
            System.out.println("Invalid index. Deletion Not Possible.");
        } else {
            // Arrays.sort
            for (int i = deleteIndex; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0; // Set the last element to 0 or any other default value

            System.out.println("Array after deletion: " + Arrays.toString(array));
        }
    }
}

// import java.util.Arrays;
// import java.util.Scanner;

// public class ArrayDeletion {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the size of the array: ");
//         int size = scanner.nextInt();
//         int[] array = new int[size];

//         System.out.println("Enter the elements of the array:");
//         for (int i = 0; i < size; i++) {
//             System.out.print("Element " + (i + 1) + ": ");
//             array[i] = scanner.nextInt();
//         }

//         System.out.println("Enter the index of the number to delete: ");
//         int deleteIndex = scanner.nextInt();

//         System.out.println("Original Array: " + Arrays.toString(array));

//         if (deleteIndex < 0 || deleteIndex >= size) {
//             System.out.println("Invalid index. Deletion aborted.");
//         } else {
//             int[] newArray = new int[size - 1];
//             int newArrayIndex = 0;

//             for (int i = 0; i < size; i++) {
//                 if (i != deleteIndex) {
//                     newArray[newArrayIndex] = array[i];
//                     newArrayIndex++;
//                 }
//             }

//             System.out.println("Array after deletion: " + Arrays.toString(newArray));
//         }
//     }
// }
