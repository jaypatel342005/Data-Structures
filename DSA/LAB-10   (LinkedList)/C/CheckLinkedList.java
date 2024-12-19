import java.util.Scanner;

public class CheckLinkedList 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedListOperation list_first = new LinkedListOperation();
        LinkedListOperation list_second = new LinkedListOperation();
        
        System.out.println("Enter elements of the first linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1) break;
            list_first.insert(value);
        }
        
        System.out.println("Enter elements of the second linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1) break;
            list_second.insert(value);
        }

        // Display both lists
        list_first.display();
        list_second.display();
        
        // Check if lists are the same
        boolean result = list_first.isSame(list_second);
        if (result) {
            System.out.println("The linked lists are the same.");
        } else {
            System.out.println("The linked lists are not the same.");
        }

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
            return;
        } 
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = node;
    }

    public void display() {
        Node current = head;
        System.out.println();
        System.out.println("-------Linked List is-------");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isSame(LinkedListOperation otherList) {
        Node current1 = this.head;
        Node current2 = otherList.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }
}
