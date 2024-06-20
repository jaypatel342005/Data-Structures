import java.util.Scanner;

public class Lab4_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the first array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
    
        for (int i = 0; i < size1; i++) {
            System.out.print("Enter " + i + " elements for the first array: ");
            arr1[i] = scanner.nextInt();
        }

        // Input the size of the second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        
        for (int i = 0; i < size2; i++) {
            System.out.print("Enter " + i + " elements for the second array: ");
            arr2[i] = scanner.nextInt();
        }

        // Merge the arrays
        int mergedSize = size1 + size2;
        int[] mergedArray = new int[mergedSize];
        for (int i = 0; i < size1; i++) {
            mergedArray[i] = arr1[i];
        }
        for (int i = 0; i < size2; i++) {
            mergedArray[size1 + i] = arr2[i];
        }

        // Print the merged array
        System.out.println("Merged array:");
        for (int i = 0; i < mergedSize; i++) {
            System.out.print(mergedArray[i] + " ");
        }

        scanner.close();
    }
}
