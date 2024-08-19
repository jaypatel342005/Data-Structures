// 94. Write a program to implement Selection Sort using Array.
import java.util.Scanner;
public class Lab20_94 {
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

    // Selection Sort
    for (int i = 0; i < size - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < size; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }

    System.out.println("\nArray after sorting:");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
  }

}
