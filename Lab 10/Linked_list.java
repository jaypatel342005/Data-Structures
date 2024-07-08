
/**
 * Linked_list
 */

// Node class

class Node {
    int data;
    Node next;

    Node(int data) {
       this.data = data;
        this.next = null;
    }
}

// Linked_list class
public class Linked_list {
    Node head;
    
    // Function to add a node at the beginning of the linked list
    void insertAtFirst(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;


    }

    void insertAtLast(int new_data){
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next!=null)
            last = last.next;
        last.next = new_node;
    }
    
    // Function to print the linked list
    void printList() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Function to delete a node with given key
    void deleteNode(int key) {
        // Store head node
        Node temp = head, prev = null;
    }
    
    // Function to reverse the linked list
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next_node = null;
    }

    
}
