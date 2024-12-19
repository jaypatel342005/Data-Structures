import java.util.Scanner;

public class LinearSearch{
    public static int linearSearch(int[] array,int searchValue){
        for(int i=0;i<array.length;i++){
            if(array[i]==searchValue){
                return i;
            }
        }
        return -1;
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
        System.out.print("Enter value you want to search : ");
        int searchValue = sc.nextInt();
        int index = linearSearch(array,searchValue);
        if(index!=-1){
            System.out.println(searchValue + " is found at index "+index+".");
        }
        else{
            System.out.println(searchValue + " is not found.");
        }
    }
}