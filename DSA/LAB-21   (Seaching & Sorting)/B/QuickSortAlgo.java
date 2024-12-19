import java.util.*;

public class QuickSortAlgo {

    public static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = pivot;
        array[high] = temp;
        return i;
    }

    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pivotindex = partition(array, low, high);

            quickSort(array, low, pivotindex - 1);
            quickSort(array, pivotindex + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Array:");
        int size_of_array = sc.nextInt();

        int array[] = new int[size_of_array];
        System.out.println("Enter the element of the Array");
        for (int i = 0; i < size_of_array; i++) {
            array[i] = sc.nextInt();
        }

        quickSort(array, 0, size_of_array-1);

        for (int i = 0; i < size_of_array; i++) {
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}
