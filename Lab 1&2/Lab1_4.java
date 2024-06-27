// Write a program to find factorial of a number. 
import java.util.Scanner;

public class Lab1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int fac = 1 ;
        for(int i = 1; i <= n; i++){
            fac = fac * i;
        }
        System.out.println("Factorial of " + n + " is " + fac);
    }
}
