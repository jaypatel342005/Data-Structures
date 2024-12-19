class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class RemoveDuplicatesSortedLinkedList {
    // Function to remove duplicates from a sorted linked list
    public Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Function to print the linked list
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedLinkedList obj = new RemoveDuplicatesSortedLinkedList();

        // Create the sorted linked list: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(6);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(13);
        head.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next = new Node(27);
        head.next.next.next.next.next.next.next = new Node(27);

        System.out.println("Original linked list:");
        obj.printList(head);

        // Remove duplicates
        Node newHead = obj.removeDuplicates(head);

        System.out.println("\nLinked list after removing duplicates:");
        obj.printList(newHead);
    }
}
