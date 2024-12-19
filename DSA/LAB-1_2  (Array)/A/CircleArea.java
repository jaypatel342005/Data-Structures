import java.util.Scanner;
public class CircleArea {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Radius: ");
        double radius=scanner.nextDouble();

        double answer=Math.PI*radius*radius;

        System.out.println("Area Of Circle : "+answer);
        scanner.close();
    }
}