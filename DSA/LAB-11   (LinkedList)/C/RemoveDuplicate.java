import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListOperation list = new LinkedListOperation();

        System.out.println("Enter elements of the linked list (enter -1 to end):");
        while (true) {
            int value = scanner.nextInt();
            if (value == -1)
                break;
            list.insert(value);
        }

        // Display the linked list before removing duplicates
        System.out.println("Original linked list:");
        list.display();

        // Remove duplicates
        list.removeDuplicates();

        // Display the linked list after removing duplicates
        System.out.println("Linked list after removing duplicates:");
        list.display();

        scanner.close();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperation {
    Node head;

    public LinkedListOperation() {
        this.head = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
    }

    public void display() {
        if (head != null) {
            Node pointer = head;
            System.out.println("\n-------Linked List is-------");
            while (pointer != null) {
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            }
            System.out.println();
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}