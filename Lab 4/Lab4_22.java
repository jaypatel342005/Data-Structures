import java.util.*;

public class Lab4_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of arry : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0 ; i < n ; i++ ){
            System.out.print("Enter value of "+i+" element : ");
            a[i] = sc.nextInt();
        }
        int[] b = new int[n-1];
        System.out.println("enter the index of element to delete the number : ");
        int x = sc.nextInt();
        for ( int i=0 ; i < x ; i++){
            b[i] = a[i];
        }
        for ( int i=x ; i < n-1 ; i++){
            b[i] = a[i+1];
        }
        
        System.out.println("the new array is : ");
        for ( int i=0 ; i < n-1 ; i++){
            System.out.print(b[i]+" ");
        }
    }
    
}
