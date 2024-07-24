
// 72. Write a menu driven program to implement following operations on the doubly 
// linked list. 
//  Insert a node at the front of the linked list. 
//  Delete a node from specified position. 
//  Insert a node at the end of the linked list. (Home Work) 
//  Display all nodes. (Home Work)

import java.util.Scanner;

class Node {
    int data;
    Node lptr; 
    Node rptr; 

    Node(int data) {
        this.data = data;
        this.lptr = null;
        this.rptr = null;
    }
}

class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // Insert a node at the front of the linked list
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.rptr = head;
            head.lptr = newNode;
            head = newNode;
        }
        System.out.println("Node inserted at the front.");
    }

    // Delete a node from specified position
    public void deleteAtPosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node current = head;
        int i;

        for (i = 1; current != null && i < position; i++) {
            current = current.rptr;
        }

        if (current == null) {
            System.out.println("Position not found!");
            return;
        }

        if (head == current) {
            head = current.rptr;
        }

        if (current.rptr != null) {
            current.rptr.lptr = current.lptr;
        }

        if (current.lptr != null) {
            current.lptr.rptr = current.rptr;
        }

        System.out.println("Node deleted at position " + position);
    }

    // Insert a node at the end of the linked list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.rptr != null) {
                current = current.rptr;
            }
            current.rptr = newNode;
            newNode.lptr = current;
        }
        System.out.println("Node inserted at the end.");
    }

    // Display all nodes
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.rptr;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front");
            System.out.println("2. Delete a node from specified position");
            System.out.println("3. Insert a node at the end");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    data = scanner.nextInt();
                    list.insertFront(data);
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 3:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insertEnd(data);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
