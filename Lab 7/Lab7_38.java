//38. Write a menu driven program to implement following operations on the Stack using an Array
// PUSH, POP, DISPLAY
// PEEP, CHANGE

import java.util.Scanner;

 class Stack {
    Scanner scanner = new Scanner(System.in);
    int top = -1;
    int max;
    int[] stackArray;
    
    public Stack(int size) {
        this.max = size;
        stackArray = new int[max];
        // for(int i=0 ; i<max; i++){
        //     System.out.print("Enter value of "+i+" element : ");
        //     stackArray[i] = scanner.nextInt();
        //     top++;
        // }
    }

    public void push(int x){
        if(top >= max-1){
            System.out.println("Stack Overflow");
            return;
        }
        else{
        top++;
        stackArray[top] = x;
        System.out.println(x + " pushed to stack");
        }
    }

    public int pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
        int popped = stackArray[top];
        top--;
        return popped;
        }
     }

     public int peep(){
        if(top < 0){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
        return stackArray[top];
        }
     }

     public void display(){
        if(top < 0){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Stack:");
        for(int i = top; i >= 0; i--){
            System.out.println(stackArray[i]);
        }
    }

     public void change(int index, int value){
        if(index > top || index < 0){
            System.out.println("Invalid Index");
            return;
        }
        stackArray[index] = value;
        System.out.println("Value changed at index " + index + " to " + value);
     }


    
    

    
}
public class Lab7_38 {
    
    public static void main(String[] args) {
        System.out.println("enter the size of stake : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Stack s1 = new Stack(size);
        System.out.println("chose the operation no. that you want ");
        System.out.println("1. push");
        System.out.println("2. pop");
        System.out.println("3. peep");
        System.out.println("4. display");
        System.out.println("5. change");
        int choice = scanner.nextInt();
        if( choice >= 1 && choice<=5){
            switch(choice){
                case 1:
                    System.out.println("Enter the value to push : ");
                    int value = scanner.nextInt();
                    s1.push(value);
                    break;
                case 2:
                    int popped = s1.pop();
                    if(popped!= -1){
                        System.out.println("Popped value is : "+popped);
                    }
                    break;
                case 3:
                    int peeked = s1.peep();
                    if(peeked!= -1){
                        System.out.println("Top value is : "+peeked);
                    }
                    break;
                case 4:
                    s1.display();
                    break;
                case 5:
                    System.out.println("Enter the index and new value to change : ");
                    int index = scanner.nextInt();
                    int newValue = scanner.nextInt();
                    s1.change(index, newValue);
                    break;
                default:
             }
        }
        else{
            System.out.println("Invalid choice");
        }

    }
}
