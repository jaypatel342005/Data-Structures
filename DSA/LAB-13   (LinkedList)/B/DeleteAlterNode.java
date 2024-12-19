public class DeleteAlterNode {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        System.out.println("Original List:");
        list.display();

        list.deleteNode();

        System.out.println("List after deleting alternate nodes:");
        list.display();
    }
}

class Node {
    int data;
    public Node first;
    Node last;

    Node(int data) {
        this.data = data;
        this.first = null;
        this.last = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.last = node;
            node.first = tail;
            tail = node;
        }
    }

    public void deleteNode() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null && current.last != null) {
            Node nodeToDelete = current.last;
            current.last = nodeToDelete.last;
            if (nodeToDelete.last != null) {
                nodeToDelete.last.first = current;
            }
            current = current.last;
        }
    }

    public void display() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.last;
        }
        System.out.println();
    }
}
