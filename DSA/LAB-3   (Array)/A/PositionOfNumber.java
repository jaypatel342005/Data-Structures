
import java.util.Scanner;

public class PositionOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter Array Elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        int minPosition = 0;
        int maxPosition = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minPosition = i;
            }
            if (arr[i] > max) {
                max = arr[i];
                maxPosition = i;
            }
        }

        System.out.println("Position of the smallest number is "+ minPosition +" & the largest number is "+maxPosition);
    }   
}