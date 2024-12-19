import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        int temp;
        boolean flag=true;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j+1]<array[j]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                    flag=false;
                }
            }
            if(flag){
                return;
            }
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
        bubbleSort(array);
        printArray(array);
    }
}
