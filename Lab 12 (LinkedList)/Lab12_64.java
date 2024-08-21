// 64. Write a program to reverse a linked list.

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

    // Method to reverse the linked list
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current;      // Move pointers one position ahead
            current = next;
        }

        head = prev; // Set the new head of the reversed list
    }
}


public class Lab12_64  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.println("Enter elements for the linked list (enter 'done' to finish):");
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                list.insert(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'done' to finish.");
            }
        }

        System.out.println("Original Linked List:");
        list.display();

        // Reverse the linked list
        list.reverse();

        System.out.println("Reversed Linked List:");
        list.display();

        scanner.close();
    }
}
