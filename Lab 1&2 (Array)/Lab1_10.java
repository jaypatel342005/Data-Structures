// WAP to convert number of days into year, week & days 


import java.util.Scanner;

public class Lab1_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of day's: ");
        int days = scanner.nextInt();
        
        if (days % 4 == 0 && days % 100!= 0 || days % 400 == 0) {
            int year = days/366;
            int month = (days%366)/30;
            int day = (days%366)%30;
            System.out.println(days + " days is " + year + " years, " + month + " months, " + day + " days");

        } else {
            int year = days/365;
            int month = (days%365)/30;
            int day = (days%365)%30;
            System.out.println(days + " days is " + year + " years, " + month + " months, " + day + " days");
        }


    }
}
