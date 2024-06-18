import java.util.Scanner;

public class Lab3_17 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		System.out.print("Enter value of n : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter value of "+i+" element : ");
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i] == arr[j]){
					flag = true;
				}
			}
		}           
		if(flag){
			System.out.println("Contains a duplicate number");
		}
		else{
			System.out.println("Does not contain a duplicate number");
		}
	}
}
