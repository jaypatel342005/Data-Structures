import java.util.Scanner;

public class CopyLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperation originalList = new LinkedListOperation();

        System.out.println("Enter elements of the original linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1)
                break;
            originalList.insert(value);
        }

        // Display the original linked list
        System.out.println("Original linked list:");
        originalList.display();

        // Copy the linked list
        LinkedListOperation copiedList = originalList.copyList();

        // Display the copied linked list
        System.out.println("Copied linked list:");
        copiedList.display();

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

    public LinkedListOperation copyList() {
        if (head == null) {  
            return null;
        }

        LinkedListOperation copiedList = new LinkedListOperation();
        Node pointer = head;
        while (pointer != null) {
            copiedList.insert(pointer.data);
            pointer = pointer.next;
        }
        return copiedList;
    }
}