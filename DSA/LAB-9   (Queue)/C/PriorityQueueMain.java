import java.util.Scanner;

public class PriorityQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Capacity of the queue: ");
        int capacity = sc.nextInt();

        PriorityQueue pq=new PriorityQueue(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = sc.nextInt();
                    pq.insert(element);
                    break;
                case 2:
                    int deletedElement = pq.delete();
                    if (deletedElement != -1) {
                        System.out.println("Deleted element: " + deletedElement);
                    }
                    break;
                case 3:
                    pq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}

class PriorityQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insert(int element) {
        if (isFull()) {
            System.out.println("-------Queue is full-------");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = element;
        } else {
            int i;
            for (i = rear; i >= front; i--) {
                if (element > queue[i]) {
                    queue[i + 1] = queue[i];
                } else {
                    break;
                }
            }
            queue[i + 1] = element;
            rear++;
        }
        size++;
    }

    public int delete() {
        if (isEmpty()) {
            System.out.println("-------Queue is Empty-------");
            return -1;
        }

        int deletedElement = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        size--;
        return deletedElement;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("-------Queue is Empty-------");
            return;
        }

        System.out.println("Priority Queue elements:");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}