// 65. Write a program to sort elements of a linked list. 

import java.util.Scanner;

public class Lab12_65 {

    // Node class representing each element in the linked list
    private static class Node {
        int info;
        Node link;

        Node(int info) {
            this.info = info;
            this.link = null;
        }
    }

    // LinkedList class with methods to insert and sort the list
    private static class LinkedList {
        Node first;

        // Method to insert a new node at the end of the list
        public void insert(int info) {
            Node newNode = new Node(info);
            if (first == null) {
                first = newNode;
            } else {
                Node temp = first;
                while (temp.link != null) {
                    temp = temp.link;
                }
                temp.link = newNode;
            }
        }

        // Method to sort the linked list using Bubble Sort
        public void sort() {
            if (first == null || first.link == null) {
                return;
            }
            boolean swapped;
            do {
                swapped = false;
                Node current = first;
                Node prev = null;
                Node link = first.link;
                while (link != null) {
                    if (current.info > link.info) {
                        // Swap the info
                        if (prev != null) {
                            Node temp = link.link;
                            prev.link = link;
                            link.link = current;
                            current.link = temp;
                        } else {
                            Node temp = link.link;
                            first = link;
                            link.link = current;
                            current.link = temp;
                        }
                        swapped = true;
                        prev = link;
                        link = current.link;
                    } else {
                        prev = current;
                        current = link;
                        link = link.link;
                    }
                }
                
            } while (swapped);
        }

        // Method to display the elements of the linked list
        public void display() {
            if (first == null) {
                System.out.println("Linked list is empty.");
                return;
            }
            Node temp = first;
            System.out.print("Linked List: ");
            while (temp != null) {
                System.out.print(temp.info + " ");
                temp = temp.link;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Linked List Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Sort");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    list.sort();
                    System.out.println("Linked list sorted.");
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

