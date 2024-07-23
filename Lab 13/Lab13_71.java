// 71. Write a menu driven program to implement following operations on the 
// circular linked list. 
//  Insert a node at the front of the linked list. 
//  Delete a node from specified position. 
//  Insert a node at the end of the linked list. 
//  Display all nodes.

import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node previous = null;
        
        if (position == 1) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else {
            for (int i = 1; i < position; i++) {
                previous = current;
                current = current.next;
            }

            if (current == tail) {
                tail = previous;
                tail.next = head;
            } else {
                previous.next = current.next;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class Lab13_71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front");
            System.out.println("2. Insert a node at the end");
            System.out.println("3. Delete a node from specified position");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at the front: ");
                    int dataFront = scanner.nextInt();
                    list.insertAtFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter data to insert at the end: ");
                    int dataEnd = scanner.nextInt();
                    list.insertAtEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter position to delete: ");
                    int position = scanner.nextInt();
                    list.deleteFromPosition(position);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
