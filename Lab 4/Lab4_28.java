import java.util.Scanner;
public class Lab4_28{
	public static void main(String[] args) {
		try{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter value of arr["+i+"] : ");
			arr[i] = sc.nextInt();
		}
			System.out.println("Enter 1 for sum : ");
			System.out.println("Enter 2 for min : ");
			System.out.println("Enter 3 for max : ");
			System.out.println("Enter 4 for avg : ");
			String s = sc.next();
			switch(s){
				case "1":
					Array_Database a = new Array_Database(arr);
					System.out.print("Sum = "+a.sum(arr));
					break;
				case "2":
					Array_Database b = new Array_Database(arr);
					System.out.print("Min = "+b.min(arr));
					break;
				case "3":
					Array_Database c = new Array_Database(arr);
					System.out.print("Max = "+c.max(arr));
					break;
				case "4":
					Array_Database d = new Array_Database(arr);
					System.out.print("Avg = "+d.avg(arr));
					break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
class Array_Database{
	int[] a;
	public Array_Database(int[] a){
		this.a = a;
	}
	public int sum(int[] a){
		int ans=0;
		for(int i=0;i<a.length;i++){
			ans += a[i];
		}
		return ans;
	}
	public int min(int[] a){
		int ans=a[0];
		for(int i=0;i<a.length;i++){
			if(ans>a[i]){
				ans = a[i];
			}
		}
		return ans;
	}
	public int max(int[] a){
		int ans=a[0];
		for(int i=0;i<a.length;i++){
			if(ans<a[i]){
				ans = a[i];
			}
		}
		return ans;
	}
	public float avg(int[] a){
		float ans=0;
		for(int i=0;i<a.length;i++){
			ans += a[i]; 
		}
		ans/=a.length;
		return ans;
	}
}