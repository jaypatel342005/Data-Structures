// 51. Write a menu driven program to implement following operations on a circular queue using an Array 
//  enqueue 
//  dequeue 
//  Display all elements of the queue 

import java.util.Scanner;

 class CircularQueue {
     int front, rear, size;
     int queue[];

    CircularQueue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        queue = new int[size];
    }

    // Function to enqueue an element at the end of the queue
    void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
            return;
        } else if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = data;
        
        System.out.println(data + " enqueued to queue");
        display();
    }

    // Function to dequeue an element from the front of the queue
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        System.out.println(queue[front] + " is dequeued from queue");
        display();
    }

    // Function to display the elements of the queue
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    
}

public class Lab9_51 {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(1000);

        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to enqueue: ");
                    data = sc.nextInt();
                    q.enqueue(data);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
    
}
