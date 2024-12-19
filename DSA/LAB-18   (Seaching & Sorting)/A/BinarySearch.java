import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] array,int searchValue){
        int i=0,j=array.length-1,mid;
        while (i<=j) {
            mid = (i+j)/2;
            if(array[mid]==searchValue){
                return mid;
            }
            else if(array[mid]>searchValue){
                j = mid-1;
                
            }
            else{
                i = mid+1;
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
            System.out.print("Enter array element in sorted order : ");
            array[i] = sc.nextInt();
        }
        System.out.print("Enter value you want to search : ");
        int searchValue = sc.nextInt();

        int index = binarySearch(array,searchValue);
        if(index!=-1){
            System.out.println(searchValue + " is found at index "+index+".");
        }
        else{
            System.out.println(searchValue + " is not found.");
        }
 
    }
}
