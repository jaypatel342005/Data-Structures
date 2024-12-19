import java.util.Scanner;

public class HeapSort {
    
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; // left = 2*i + 1
        int rightChild = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // If right child is larger than largest so far
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the Array : ");
        int size_of_array=sc.nextInt();
        int[] arr = new int[size_of_array];
        System.out.println("----------Enter the element of the array----------");
        for(int i=0;i<size_of_array;i++)
        {
            arr[i]=sc.nextInt();
        }
        heapSort(arr);
        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
