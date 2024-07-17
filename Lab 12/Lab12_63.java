// 63. Write a program to copy a linked list. 
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the linked list
    void insert(int data) {
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

    // Method to display the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to copy the linked list
    LinkedList copy() {
        LinkedList newList = new LinkedList();
        Node current = this.head;
        Node newHead = null;
        Node tail = null;

        while (current != null) {
            Node newNode = new Node(current.data);
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            current = current.next;
        }

        newList.head = newHead;
        return newList;
    }
}

public class Lab12_63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new linked list
        LinkedList originalList = new LinkedList();

        // Prompt user to enter elements for the linked list
        System.out.println("Enter elements for the linked list (enter 'done' to finish):");
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                originalList.insert(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'done' to finish.");
            }
        }

        System.out.println("Original Linked List:");
        originalList.display();

        // Create a copy of the original linked list
        LinkedList copiedList = originalList.copy();

        System.out.println("Copied Linked List:");
        copiedList.display();

        // Modify original list to verify deep copy
        System.out.println("Modifying original list by inserting a new element...");
        originalList.insert(999);

        System.out.println("Modified Original Linked List:");
        originalList.display();

        System.out.println("Copied Linked List (unchanged due to deep copy):");
        copiedList.display();

        scanner.close();
    }
}


