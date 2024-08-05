// 53. Implement Priority Queue using array that performs following operations: INSERT, DELETE, DISPLAY 

import java.util.Scanner;

public class Lab9_53 {

    private static class PriorityQueue {
        private int[] queue;
        private int size;
        private int capacity;

        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.size = 0;
        }

        // Method to insert an element into the priority queue
        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Priority queue is full. Cannot insert.");
                return;
            }

            // Insert the new element at the end of the array
            queue[size] = value;
            size++;
            // Reorder the array to maintain priority queue properties
            int i = size - 1;
            while (i > 0 && queue[i] > queue[i - 1]) {
                int temp = queue[i];
                queue[i] = queue[i - 1];
                queue[i - 1] = temp;
                i--;
            }
        }

        // Method to delete the highest priority element from the priority queue
        public void delete() {
            if (size == 0) {
                System.out.println("Priority queue is empty. Cannot delete.");
                return;
            }
            // Remove the highest priority element (first element in the array)
            for (int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            size--;
        }

        // Method to display elements of the priority queue
        public void display() {
            if (size == 0) {
                System.out.println("Priority queue is empty.");
                return;
            }
            System.out.print("Priority Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the priority queue:");
        int capacity = scanner.nextInt();

        PriorityQueue pq = new PriorityQueue(capacity);

        while (true) {
            System.out.println("Priority Queue Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    pq.insert(value);
                    break;
                case 2:
                    pq.delete();
                    break;
                case 3:
                    pq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
