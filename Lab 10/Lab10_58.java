
// Write a program to count the number of nodes in a singly circularly linked list.

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

 class CircularLinkedList {
    private Node head = null;

    // Method to add a node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to count the number of nodes in the list
    public int countNodes() {
        if (head == null) {
            return 0;
        }

        int count = 1; // Starting count from 1 since head is not null
        Node temp = head;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}

public class Lab10_58 {
     public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);

            System.out.println("Number of nodes in the circular linked list: " + list.countNodes());
    }
    
}
