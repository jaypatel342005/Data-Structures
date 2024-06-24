import java.util.*;
public class Lab5_32{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total number of words : ");
		int n = sc.nextInt();
		String[] words = new String[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter value of word["+i+"] : ");
			words[i] = sc.next();
		}
		int index = (int)(Math.random()*(n));
		System.out.print("Enter anagram of word "+words[index]+" : ");
		String word = sc.next();
		isAnagram(words[index],word);
	}
	public static void isAnagram(String a,String b){
		if(a.length()==b.length()){
			char[] c = new char[a.length()];
			char[] d = new char[b.length()];
			for(int i=0;i<a.length();i++){
				c[i] = a.charAt(i);
				d[i] = b.charAt(i);
			}
			Arrays.sort(c);
			Arrays.sort(d);
			if(Arrays.equals(c,d)){
				System.out.println("Is Anagram");
			}
			else{
				System.out.println("Not an Anagram");
			}
		}
		else{
			System.out.println("Not an Anagram");
		}
	}
}