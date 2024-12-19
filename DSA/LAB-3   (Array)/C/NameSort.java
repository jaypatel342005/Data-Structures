import java.util.*;
public class NameSort {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size=sc.nextInt();
        String[] arr=new String[size];
        for(int i=0;i<size;i++)
        {
            System.out.print("enter the element : ");
            arr[i]=sc.next();
        }
        Arrays.sort(arr);
        for(int i=0;i<size;i++)
        {
            System.out.println("Element of : "+arr[i]);
        }
    }
}
