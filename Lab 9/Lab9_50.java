// 50. Write a menu driven program to implement following operations on the Queue 
// using an Array 
//  ENQUEUE 
//  DEQUEUE 
//  DISPLAY

import java.util.Scanner;

class Queue {
    private int front, rear, size, capacity;
    private int[] queueArray;

    public Queue(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        queueArray = new int[this.capacity];
    }

    // Check if the queue is full
    boolean isFull() {
        return (size == capacity);
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return (size == 0);
    }

    // Enqueue operation
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        size++;
        System.out.println(item + " enqueued to the queue.");
    }

    // Dequeue operation
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return Integer.MIN_VALUE;
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(item + " dequeued from the queue.");
        return item;
    }

    // Display operation
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        Queue queue = new Queue(capacity);

        int choice, item;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to enqueue: ");
                    item = scanner.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
