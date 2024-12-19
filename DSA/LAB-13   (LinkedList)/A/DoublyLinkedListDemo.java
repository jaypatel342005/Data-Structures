import java.util.Scanner;
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Node inserted at the front.");
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        System.out.println("Node inserted at the end.");
    }

    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (position <= 0) {
            System.out.println("Invalid position. Cannot delete.");
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of range. Cannot delete.");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {  //Jo first node delete karvo hoi, atle else is required.
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        System.out.println("Node deleted from position " + position);
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice, data, position;

        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert node at front");
            System.out.println("2. Insert node at end");
            System.out.println("3. Delete node from position");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt();
                    dll.insertFront(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt(); 
                    dll.insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt(); 
                    dll.deleteAtPosition(position);
                    break;
                case 4:
                    System.out.print("Nodes in the list: ");
                    dll.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
