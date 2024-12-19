// Node class representing the elements of the linked list
class Node {
    int data;
    Node next;

    // Constructor to create a new node with the given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NodeImplementation{
    public static void main(String[] args) {
        // Create a new node 
        Node node1 = new Node(42);
        Node node2 = new Node(52);
        Node node3 = new Node(72);

        node1.next=node2;
        node2.next=node3;
        node3.next=null;

        // Print the node data
        System.out.println("Node1 data: " + node1.data);
        System.out.println("Node2 data: " + node2.data);
        System.out.println("Node3 data: " + node3.data);
        System.out.println("Node1 link: " + node1.next.data); //52
    }
}
