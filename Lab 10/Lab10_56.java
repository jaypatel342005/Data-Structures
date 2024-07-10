// Write a program to implement a node structure for singly linked list. Read the data in a node, print the node.

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Method to print the data in the node
    public void printNode() {
        System.out.println("Node data: " + data);
    }
}

 class SinglyLinkedList {
    private Node head = null;

    // Method to add a node to the list
    public void add(int data) {
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

    // Method to print all nodes in the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            temp.printNode();
            temp = temp.next;
        }
    }

    
}


public class Lab10_56 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of nodes to add:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for node " + (i + 1) + ":");
            int data = scanner.nextInt();
            list.add(data);
        }

        System.out.println("Printing the nodes in the list:");
        list.printList();

        scanner.close();
    }
}
