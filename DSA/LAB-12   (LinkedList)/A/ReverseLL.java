import java.util.Scanner;

public class ReverseLL 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperation list = new LinkedListOperation();
        
        System.out.println("Enter elements of the linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1) break;
            list.insert(value);
        }

        // Display the original linked list
        System.out.println("Original linked list:");
        list.display();
        
        // Reverse the linked list
        list.reverse();

        // Display the reversed linked list
        System.out.println("Reversed linked list:");
        list.display();

        sc.close();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperation {
    Node head;

    public LinkedListOperation() {
        this.head = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
    }

    public void display() {
        if (head != null) {
            Node pointer = head;
            System.out.println("\n-------Linked List is-------");
            while (pointer != null) {
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            }
            System.out.println();
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        

        while (current != null) {
            next = current.next;   // Store next node
            current.next = prev;   // Reverse current node's pointer
            prev = current;        // Move pointers one position ahead
            current = next;
        }

        head = prev;  // Reset head to the new first node
    }
}