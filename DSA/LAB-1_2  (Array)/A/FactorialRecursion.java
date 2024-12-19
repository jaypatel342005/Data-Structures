import java.util.Scanner;

public class FactorialRecursion {

    static long calculateFactorial(int n){
        if(n<=1){
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        long factorial = calculateFactorial(number);

        System.out.println("The factorial of " + number + " is: " + factorial);
        scanner.close();
    }
}
