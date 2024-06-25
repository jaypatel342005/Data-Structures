import java.util.Scanner;

public class Lab6_33 {

    
    public static int[] swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

      
        int[] swappedNumbers = swap(num1, num2);

        System.out.println("After swapping:");
        System.out.println("First number: " + swappedNumbers[0]);
        System.out.println("Second number: " + swappedNumbers[1]);

        scanner.close();
    }
}

