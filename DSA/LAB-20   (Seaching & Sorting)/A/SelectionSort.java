import java.util.Scanner;

public class SelectionSort {

    public static void selectionSort(int[] array){
        int minIndex,temp;
        for(int i=0;i<array.length;i++){
            minIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            temp=array[i];
            array[i] = array[minIndex];  
            array[minIndex] = temp;
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
        selectionSort(array);
        printArray(array);
    }

}
