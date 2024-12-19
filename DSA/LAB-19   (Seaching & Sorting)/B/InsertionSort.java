import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] array){
        int j,x;
        for(int i=1; i<array.length; i++){
            x=array[i];
            j = i-1;
            while (j >= 0 && array[j] > x) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
        }
        return;
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
        insertionSort(array);
        printArray(array);
    }

}
