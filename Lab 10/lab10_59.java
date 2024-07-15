import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to append a new node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to compare two linked lists
    static boolean areIdentical(LinkedList list1, LinkedList list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // If both lists are empty, they are identical
        return current1 == null && current2 == null;
    }
}


public class Lab10_59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        System.out.println("Enter elements for the first linked list (type 'end' to stop):");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            int data = Integer.parseInt(input);
            list1.append(data);
        }

        System.out.println("Enter elements for the second linked list (type 'end' to stop):");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            int data = Integer.parseInt(input);
            list2.append(data);
        }

        scanner.close();

        System.out.println("List1 and List2 are identical: " + LinkedList.areIdentical(list1, list2));
    }
}
