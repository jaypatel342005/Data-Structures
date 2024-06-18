import java.util.Scanner;

public class Lab3_13 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++){
			System.out.println("Enter value of "+i+" element : ");
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr.length;i++){
			System.out.println("Value of "+i+" element = "+arr[i]);
		}
	} 
}
