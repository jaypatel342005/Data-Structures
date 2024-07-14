

// Write a menu driven program to implement following operations on the singly 
// linked list.  
//  Insert a node at the front of the linked list. 
//  Display all nodes. 
//  Delete a first node of the linked list. 
//  Insert a node at the end of the linked list. 
//  Delete a last node of the linked list. 
//  Delete a node from specified position.



import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class SinglyLinkedList {
    private Node head;

    // Insert a node at the front of the linked list
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Display all nodes
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Delete the first node of the linked list
    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        head = head.next;
    }

    // Insert a node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete the last node of the linked list
    public void deleteLastNode() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Delete a node from a specified position
    public void deleteNodeAtPosition(int position) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Position out of range.");
                return;
            }
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Position out of range.");
            return;
        }
        current.next = current.next.next;
    }
}

public class Lab10_57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front of the linked list");
            System.out.println("2. Display all nodes");
            System.out.println("3. Delete the first node of the linked list");
            System.out.println("4. Insert a node at the end of the linked list");
            System.out.println("5. Delete the last node of the linked list");
            System.out.println("6. Delete a node from specified position");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at the front: ");
                    data = scanner.nextInt();
                    list.insertAtFront(data);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.deleteFirstNode();
                    break;
                case 4:
                    System.out.print("Enter data to insert at the end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 5:
                    list.deleteLastNode();
                    break;
                case 6:
                    System.out.print("Enter position to delete node from: ");
                    position = scanner.nextInt();
                    list.deleteNodeAtPosition(position);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");      
            }
        } while (choice != 7);
   
        scanner.close();
    }
}
