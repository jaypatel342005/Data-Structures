import java.util.Scanner;
public class Lab4_23{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array : ");
		int n = sc.nextInt();
		int[] prev = new int[n];
		int[] next = new int[n+1]; 
		for(int i=0;i<n;i++){
			System.out.println("Enter value of arr["+i+"] : ");
			prev[i] = sc.nextInt();
		}
		System.out.print("Enter number you want to insert : ");
		int num = sc.nextInt(); 
		int j=0;
		int index = 0;
		for(int i=0;i<prev.length;i++){
			if(num<prev[i]){
				index=i;
				break;
			}
		}
		for(int i=0;i<next.length;i++,j++){
			if(index == i){
				next[i] = num;
				j--;
			}
			else{
				next[i] = prev[j];
		}
	}
		System.out.println("After insertion : ");
		for(int i=0;i<next.length;i++){
			System.out.println("Value of arr["+i+"] : "+next[i]);
		}
	}
}