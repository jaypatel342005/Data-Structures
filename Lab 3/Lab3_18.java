import java.util.Scanner;
public class Lab3_18 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value of n : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter value of "+i+" element : ");
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter a number in array which needs to be replaced :");
		int n1 = sc.nextInt();
		System.out.println("Enter a number which will be replaced : ");
		int n2 = sc.nextInt();
		for(int i=0;i<n;i++){
			if(n1 == arr[i]){
				System.out.println("Index = "+i);
				arr[i] = n2;
			}
		}
		System.out.println("Final Array : ");
		for(int i=0;i<n;i++){
			System.out.println("value of "+i+" element = "+arr[i]);
		}

	}
}
