import java.util.Scanner;
public class Lab3_14{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter lower number : ");
		int m = sc.nextInt();
		System.out.print("Enter higher number : ");
		int n = sc.nextInt();
		int sum=0;
		for(int i=m;i<=n;i++){
			sum += i;
		}
		System.out.println("Sum = "+sum);
	}
}