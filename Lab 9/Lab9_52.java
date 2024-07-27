// 52. Write a menu driven program to implement following operations on the 
// Doubled Ended Queue using an Array 
//  Insert at front end, Insert at rear end 
//  Delete from front end, Delete from rear end 
//  Display all elements of the queue


import java.util.Scanner;

class Deque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public Deque(int size) {
        deque = new int[size];
        front = -1;
        rear = 0;
        this.size = size;
    }

    // Check if the deque is full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return (front == -1);
    }

    // Insert at front end
    public void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        // If the deque is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        // Front is at the first position of deque
        else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }

        deque[front] = key;
    }

    // Insert at rear end
    public void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        // If the deque is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        // Rear is at the last position of deque
        else if (rear == size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }

        deque[rear] = key;
    }

    // Delete from front end
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // Front is at the last position of deque
        else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
    }

    // Delete from rear end
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // Rear is at the first position of deque
        else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    // Display all elements of the deque
    public void displayDeque() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Elements in the deque are: ");

        int i = front;
        while (i != rear) {
            System.out.print(deque[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println(deque[rear]);
    }
}


public class Lab9_52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the deque: ");
        int size = scanner.nextInt();

        Deque deque = new Deque(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front end");
            System.out.println("2. Insert at rear end");
            System.out.println("3. Delete from front end");
            System.out.println("4. Delete from rear end");
            System.out.println("5. Display all elements of the queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at front: ");
                    int frontElement = scanner.nextInt();
                    deque.insertFront(frontElement);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at rear: ");
                    int rearElement = scanner.nextInt();
                    deque.insertRear(rearElement);
                    break;
                case 3:
                    deque.deleteFront();
                    break;
                case 4:
                    deque.deleteRear();
                    break;
                case 5:
                    deque.displayDeque();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
