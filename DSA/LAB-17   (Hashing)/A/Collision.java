import java.util.Arrays;
import java.util.Scanner;

public class Collision {
    static int[] hash = new int[20];

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        System.out.println("---------Enter the element of the array---------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the "+(i+1)+" element of array");
            arr[i] = sc.nextInt();
        }
        store(arr);
        System.out.println(Arrays.toString(hash));
        // sc.close();
    }

    public static void store(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = hashFn(arr[i]);
            hash[index] = arr[i];
        }
    }

    public static int hashFn(int n) {
        int index = (n % 18) + 2;
        if (hash[index] != 0) {
            while (hash[index] != 0) {
                index = (++index) % 20;
            }
        }
        return index;
    }
}