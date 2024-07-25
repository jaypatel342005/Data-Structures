// 50. Write a menu driven program to implement following operations on the Queue 
// using an Array 
//  ENQUEUE 
//  DEQUEUE 
//  DISPLAY

import java.util.Scanner;

 class Queue {
     int front, rear, capacity;
     int queue[];

    Queue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // Function to add an element at the end of the queue
    void enqueue(int data) {
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }
        else {
            queue[rear] = data;
            rear++;
        }
        
        System.out.println(data+" is enqueued in queue");
        display();
        return;
    }

    // Function to remove an element from the front of the queue
    void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            if (rear < capacity) {
                queue[rear] = 0;
            }

            rear--;
        }

        System.out.println(queue[front]+" is dequeued from queue");
        display();
        return;
    }

    // Function to display the elements of the queue
    void display() {
        int i;
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }

        for (i = front; i < rear; i++) {
            System.out.printf("%d ", queue[i]);
        }
        System.out.println();
        return;
    }
 
}


public class Lab9_50 {

    public static void main(String[] args) {
        Queue q = new Queue(1000);

        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
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
