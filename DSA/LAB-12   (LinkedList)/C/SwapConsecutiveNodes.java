// Node class to represent each node in the linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class SwapConsecutiveNodes {
    // Function to swap two consecutive nodes in the linked list
    public Node swapConsecutiveNodes(Node head) {
        // If the linked list is empty or has only one node, no need to swap
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node before the head to handle the case of swapping the first two nodes
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node nextNode = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = nextNode;

            prev = curr;
            curr = nextNode;
        }

        return dummy.next;
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
        SwapConsecutiveNodes obj = new SwapConsecutiveNodes();

        // Create the linked list: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original linked list:");
        obj.printList(head);

        // Swap consecutive nodes
        Node newHead = obj.swapConsecutiveNodes(head);

        System.out.println("\nLinked list after swapping consecutive nodes:");
        obj.printList(newHead);
    }
}
