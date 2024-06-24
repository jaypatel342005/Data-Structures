import java.util.Scanner;
public class Lab3_15{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value of n : ");
		int n = sc.nextInt();
		float avg=0;
		for(int i=1;i<=n;i++){
			avg += i;
		}	
		avg/=n;
		System.out.println("Average = "+avg);
	}
}