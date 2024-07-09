import java.util.Scanner;

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
        else{
            Node temp = head;
            new_node.next = null;
            while (temp.next != null) {
                temp = temp.next;
                }
                temp.next = new_node;
        }


        
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
        
        // If head node itself holds the key to be deleted
        if (temp!=null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
        
        // Search for the key to be deleted, keep track of the previous node as well
        while (temp!=null && temp.data!=key) {
            prev = temp;
            temp = temp.next;
        }
        
        // If key was not present in linked list
        if (temp == null) return;
        
        // Unlink the node from linked list
        prev.next = temp.next;
    }
    
    // Function to reverse the linked list
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next_node = null;
    }



    
}
class Lab10_1{
public static void main(String[] args) {
    // Start with the empty list
    Linked_list list = new Linked_list();
    
    // Insert nodes at the beginning
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the elements of the linked list, -1 to stop:");
    int n = sc.nextInt();
    while(n!= -1){
        list.insertAtFirst(n);
        n = sc.nextInt();
    }
    
    // Print the original list
    System.out.println("Original List:");
    list.printList();
    
    // Delete a node with given key
    System.out.println("Enter the key to delete:");
    int key = sc.nextInt();
    list.deleteNode(key);
    
    // Print the modified list
    System.out.println("Modified List after deletion:");
    list.printList();
}
}
