// 71. Write a menu driven program to implement following operations on the circular linked list. 
//  Insert a node at the front of the linked list. 
//  Delete a node from specified position. 
//  Insert a node at the end of the linked list. 
//  Display all nodes.

import java.util.Scanner;

class Node {
    int info;
    Node link;
    
    Node(int info) {
        this.info = info;
        this.link = null;
    }
}

class CircularLinkedList {
     Node first;
     Node last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    public void insertAtFront(int info) {
        Node newNode = new Node(info);
        if (first == null) {
            first = newNode;
            last = newNode;
            newNode.link = first;
        } else {
            newNode.link = first;
            first = newNode;
            last.link = first;
        }
    }

    public void insertAtEnd(int info) {
        Node newNode = new Node(info);
        if (first == null) {
            first = newNode;
            last = newNode;
            newNode.link = first;
        } else {
            last.link = newNode;
            last = newNode;
            last.link = first;
        }
    }

    public void deleteFromPosition(int position) {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = first;
        Node previous = null;
        
        if (position == 1) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.link;
                last.link = first;
            }
        } else {
            for (int i = 1; i < position; i++) {
                previous = current;
                current = current.link;
            }

            if (current == last) {
                last = previous;
                last.link = first;
            } else {
                previous.link = current.link;
            }
        }
    }

    public void display() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = first;
        do {
            System.out.print(temp.info + " ");
            temp = temp.link;
        } while (temp != first);
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
                    System.out.print("Enter info to insert at the front: ");
                    int dataFront = scanner.nextInt();
                    list.insertAtFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter info to insert at the end: ");
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
