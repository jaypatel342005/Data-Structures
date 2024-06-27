// WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS 

import java.util.Scanner;

public class Lab1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int totalSeconds = scanner.nextInt();

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println("Converted time: " + timeFormatted);

        scanner.close();
    }
}
