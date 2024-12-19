import java.util.Scanner;

public class LinkedListGCD {
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

        originalList.insertGCD();

        System.out.println("After GCD join linked list:");
        originalList.display();

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
    int node_counter=0;

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
                node_counter++;
            }
            System.out.println();
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public void insertGCD() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current.next != null) {
            int gcdValue = gcd(current.data, current.next.data);
            Node newNode = new Node(gcdValue);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
