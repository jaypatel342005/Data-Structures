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
    Node head;

    void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Circular link to itself
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Node inserted at the front.");
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Circular link to itself
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
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
        Node prev = null;
        int count = 1;
        while (current.next != head && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (count < position) {
            System.out.println("Position out of range. Cannot delete.");
            return;
        }
        if (prev != null) {
            prev.next = current.next;
        } else { // jo pelo element delete karvo hoi to else ma jase
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            if (last == head) { // jo linkedlist ma ek j element hase to if execute thase
                head = null;
            } else {// jo ek karta vadhare element hase to else block execute thase
                last.next = current.next;
                head = current.next;
            }
        }
        System.out.println("Node deleted from position " + position);
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        // used do while bcoz the loop needs to traverse through the entire list 
        // at least once and  return to the starting point (which is the head node).
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        int choice, data, position;

        Scanner scanner = new Scanner(System.in);

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
                    cll.insertFront(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt();
                    cll.insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    cll.deleteAtPosition(position);
                    break;
                case 4:
                    System.out.print("Nodes in the list: ");
                    cll.display();
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
    