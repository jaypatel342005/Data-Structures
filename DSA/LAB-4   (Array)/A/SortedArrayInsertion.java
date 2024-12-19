import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n+1];

        System.out.println("Enter the elements of the array in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        System.out.print("Enter the number to insert: ");
        int num = scanner.nextInt();

        System.out.println("Original Array: " + Arrays.toString(arr));

        /*Find position where elements should be entered.*/
        int pos=0;
        for(int i=0;i<n;i++){
            if(arr[i]<num){
                pos++;
            }else{
                break;
            }
        }
        System.out.println(num + " should be entered at position "+ pos );
        
        /* Execute a loop to move all elements right by 1 position having 
             index greater than position where to insert element */
        
        for(int i=n-1;i>=pos;i--) {
            arr[i+1] = arr[i];
        }
        
          // Insert element at given position
        arr[pos] = num;

        System.out.println("Array after insertion: " + Arrays.toString(arr));

    }
}
