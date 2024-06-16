import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a redius of circal : ");
        double radius = sc.nextDouble();
        double area = radius * radius * Math.PI;
        System.out.println("Area of circal is : " + area);
        System.out.println("Perimeter of circal is : " + 2 * radius * Math.PI);
        
    }
}
