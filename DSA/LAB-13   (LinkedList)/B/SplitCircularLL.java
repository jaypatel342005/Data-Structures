import java.util.Scanner;

public class SplitCircularLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        System.out.print("Enter the number of elements in the circular linked list: ");
        int size_of_list = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < size_of_list; i++) {
            int value = scanner.nextInt();
            list.addLast(value);
        }

        System.out.println("Original list:");
        list.display();

        CircularLinkedList[] splitLists = list.split();
        System.out.println("First half:");
        splitLists[0].display();
        System.out.println("Second half:");
        splitLists[1].display();

        scanner.close();
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

class CircularLinkedList {
    Node head;
    Node tail;

    public CircularLinkedList() {
        this.head = null;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            node.next = node;
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head; // Update the tail's next pointer
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            node.next = node;
            head = node;
            tail = head;
        } else {
            node.next = head;
            tail.next = node;
            tail = node;
        }
    }

    public void remove(int value) {
        if (head == null) return;
        if (head.data == value && head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.data == value) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node pointer = head;
        do {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        } while (pointer != head);
        System.out.println();
    }

    public CircularLinkedList[] split() {
        CircularLinkedList list1 = new CircularLinkedList();
        CircularLinkedList list2 = new CircularLinkedList();

        if (head == null || head.next == head) {
            list1.head = head;
            list1.tail = tail;
            return new CircularLinkedList[]{list1, list2};
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next.next == head) {
            fast = fast.next;
        }

        Node head1 = head;
        Node head2 = slow.next;

        slow.next = head1;
        fast.next = head2;

        list1.head = head1;
        list1.tail = slow;
        list2.head = head2;
        list2.tail = fast;

        return new CircularLinkedList[]{list1, list2};
    }
}
