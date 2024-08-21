//38. Write a menu driven program to implement following operations on the Stack using an Array
// PUSH, POP, DISPLAY
// PEEP, CHANGE

import java.util.Scanner;

class Stack {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] stackArray;

    public Stack() {
        top = -1;
        stackArray = new int[MAX_SIZE];
    }

    public void push(int value) {
        if (top < MAX_SIZE - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack overflow! Cannot push.");
        }
    }

    public void pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--];
            System.out.println("Popped value: " + poppedValue);
        } else {
            System.out.println("Stack is empty! Cannot pop.");
        }
    }

    public void display() {
        if (top >= 0) {
            System.out.print("Stack contents: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty!");
        }
    }

    public void peep(int i) {
        if ((top-i+1)>= 0) {
            System.out.println("peeped value: " + stackArray[top-i+1]);
        } else {
            System.out.println("Stack is empty!");
        }
    }

    public void change(int newValue , int i ) {
        if ((top-i+1) >= 0) {
            stackArray[top-i+1] = newValue;
            System.out.println("Top value changed to: " + newValue);
        } else {
            System.out.println("Stack is empty! Cannot change value.");
        }
    }
}

class Lab7_38{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. DISPLAY");
            System.out.println("4. PEEP");
            System.out.println("5. CHANGE");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.print("Enter index to peep: ");
                    int index = scanner.nextInt();
                    stack.peep(index);
                    break;
                case 5: 
                    System.out.print("Enter index to change: ");
                    int i = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = scanner.nextInt();
                    stack.change(newValue,i);
                    break;
                case 6:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
