import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] array){
        int n = array.length;
        if(n<2){
            return;
        }
        else{
            int mid = n/2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];
            for(int i=0; i < mid; i++){
                left[i] = array[i];
            } 
            for(int i = mid; i < n; i++){
                right[i - mid] = array[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array,left,right);
        }
        return;
    }

    public static void merge(int[] array, int[] left, int[] right){
        int i=0,j=0,k=0;
    
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        
        
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        
        
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements in array : ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter array element : ");
            array[i] = sc.nextInt();
        }
        mergeSort(array);
        printArray(array);
    }
}
