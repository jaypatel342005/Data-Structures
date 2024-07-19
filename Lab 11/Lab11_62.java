// 62. WAP to remove duplicate elements from a singly linked list. 
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Method to remove duplicates from the list without using HashSet
    public void removeDuplicates() {
        Node current = head;

        // Iterate through the list
        while (current != null) {
            Node runner = current;
            // Check for duplicates and remove them
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


public class Lab11_62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice, value;

        while (true) {
            System.out.println("\nSingly Linked List Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Remove Duplicates");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    System.out.println("List elements:");
                    list.display();
                    break;
                case 3:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}

