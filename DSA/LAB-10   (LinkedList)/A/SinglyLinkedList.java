import java.util.Scanner;
// Node class representing the elements of the linked list
class Node {
    int data;
    Node next;

    // Constructor to create a new node with the given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SinglyLinkedList class to handle the operations on the linked list
class LinkedListLogic {
    Node head;
    
    // Constructor to create an empty linked list
    LinkedListLogic() {
        head = null;
    }

    // Insert a node at the front of the linked list
    void insertAtFirst(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Display all nodes in the linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insert a node at the end of the linked list
    void insertAtLast(Node newNode) {
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

    // Insert a node at the specified position in the linked list
    void insertInMiddle(Node newNode, int position) {
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = head;
        for (int i = 1; i < position - 1 && prev != null; i++) {
            prev = prev.next;
        }

        if (prev == null) {
            System.out.println("Invalid position. Insertion failed.");
            return;
        }

        newNode.next = prev.next;
        prev.next = newNode;
    }

    // Delete the first node from the linked list
    void deleteFromFirst() {
        if (head == null) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }

        head = head.next;
    }

    // Delete the last node from the linked list
    void deleteFromLast() {
        if (head == null) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete a node from the specified position in the linked list
    void deleteFromMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node prev = head;
        for (int i = 1; i < position - 1 && prev != null; i++) {
            prev = prev.next;
        }

        if (prev == null || prev.next == null) {
            System.out.println("Invalid position. Deletion failed.");
            return;
        }

        prev.next = prev.next.next;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListLogic list = new LinkedListLogic();

        int choice;
        do {
            System.out.println("Enter Your Choice ");
            System.out.println("Press 1 to insert at the front");
            System.out.println("Press 2 to display all nodes");
            System.out.println("Press 3 to delete first node");
            System.out.println("Press 4 to insert at the end");
            System.out.println("Press 5 to delete last node");
            System.out.println("Press 6 to delete node from specified position");
            System.out.println("Press 7 to exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element");
                    int data = sc.nextInt();
                    Node newNode = new Node(data);

                    list.insertAtFirst(newNode);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.deleteFromFirst();
                    break;
                case 4:
                    System.out.println("Enter Element");
                    int data2 = sc.nextInt();
                    Node newNode2 = new Node(data2);
                    list.insertAtLast(newNode2);
                    break;
                case 5:
                    list.deleteFromLast();
                    break;
                case 6:
                    System.out.println("Enter Position");
                    int position = sc.nextInt();
                    list.deleteFromMiddle(position);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
}