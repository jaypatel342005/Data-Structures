import java.util.Scanner;
public class Lab3_16{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of n : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++){
			System.out.println("Enter value of "+i+" element : ");
			arr[i] = sc.nextInt();
		}
		int min=arr[0],max=arr[0],min_pos=0,max_pos=0;
		for(int i=0;i<arr.length;i++){
			if(min>arr[i]){
				min = arr[i];
				min_pos = i;
			}
			if(max<arr[i]){
				max = arr[i];
				max_pos = i;
			}
		}
		System.out.println("Position of smallest number = "+min_pos+"\nPosition of largest number = "+max_pos);
	}
}