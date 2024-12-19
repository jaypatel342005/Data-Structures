import java.util.Scanner;

public class DoubleEndedQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Capacity of the queue: ");
        int capacity = sc.nextInt();

        DequeArray d = new DequeArray(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front end");
            System.out.println("2. Insert at rear end");
            System.out.println("3. Delete from front end");
            System.out.println("4. Delete from rear end");
            System.out.println("5. Display all elements of the queue");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at front: ");
                    int frontElement = sc.nextInt();
                    d.insertFront(frontElement);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at rear: ");
                    int rearElement = sc.nextInt();
                    d.insertRear(rearElement);
                    break;
                case 3:
                    int deletedFront = d.deleteFront();
                    if (deletedFront != -1) {
                        System.out.println("Deleted element from front: " + deletedFront);
                    }
                    break;
                case 4:
                    int deletedRear = d.deleteRear();
                    if (deletedRear != -1) {
                        System.out.println("Deleted element from rear: " + deletedRear);
                    }
                    break;
                case 5:
                    d.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

class DequeArray{
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    public DequeArray(int capacity)
    {
        deque = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    public void insertFront(int data)
    {
        if(isFull())
        {
            System.out.println("-------Queue is full-------");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + deque.length) % deque.length;
        }
        deque[front] = data;
        size++;
    }

    public void insertRear(int data) {
        if (isFull()) {
            System.out.println("-------Queue is full-------");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % deque.length;
        }
        deque[rear] = data;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("-------Queue is Empty-------");
            return -1;
        }
        int deletedItem = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % deque.length;
        }
        size--;
        return deletedItem;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("-------Queue is Empty-------");
            return -1;
        }
        int deletedItem = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + deque.length) % deque.length;
        }
        size--;
        return deletedItem;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("-------Queue is Empty-------");
            return;
        }
        System.out.println("Deque elements:");
        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.print(deque[current] + " ");
            current = (current + 1) % deque.length;
        }
        System.out.println();
    }
}
