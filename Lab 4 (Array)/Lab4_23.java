//. Write a program to insert a number in an array that is already sorted in an ascending order. 

import java.util.Scanner;

public class Lab4_23 {

    static int[] arr;

    public static void insertElement(int element){

        //declare new array
        int[] tempArr = new int[arr.length + 1];
        int i = 0;

        //for all array elements that smaller then element
        while(i < arr.length && arr[i] < element){
            tempArr[i] = arr[i];
            i++;
        }

        //insert element
        tempArr[i] = element;

        //for all array element that greater then element
        while(i < arr.length){
            tempArr[i+1] = arr[i];
            i++;
        }

        arr = tempArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter value of  arr["+i+"] : ");
            arr[i] = sc.nextInt();
        }

        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.print("Enter number you want to insert  : ");
        int element = sc.nextInt();

        insertElement(element);

        System.out.println("array after inserting element : ");

        
        for(int i : arr){
            System.out.print(i + " ");
        }

        sc.close();
    }
}