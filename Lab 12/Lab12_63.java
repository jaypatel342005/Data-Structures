// 63. Write a program to copy a linked list. 


import java.util.Scanner;

class Node {
    int info;
    Node link;

    Node(int info) {
        this.info = info;
        this.link = null;
    }
}

class LinkedList {
    Node first = null;


    void insert(int info) {
        Node newNode = new Node(info);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

   
    void display() {
        Node save = first;
        while (save != null) {
            System.out.print(save.info + " ");
            save = save.link;
        }
        System.out.println();
    }


Node copy() {
        LinkedList newList = new LinkedList();
        Node save = this.first;
        Node newfirst = null;
        Node last = null;

        while (save != null) {
            Node newNode = new Node(save.info);
            if (newfirst == null) {
                newfirst = newNode;
                last = newNode;
            } else {
                last.link = newNode;
                last = last.link;
            }
            save = save.link;
        }

        newList.first = newfirst;
        display();
        return newfirst;
    }

    // void reverse() {
    //     Node prev = null;
    //     Node save = first;
    //     Node next = null;

    //     while (save != null) {
    //         next = save.link; 
    //         save.link = prev; 
    //         prev = save;      
    //         save = next;
    //     }

    //     first = prev; 
    //     display();
// }
}

public class Lab12_63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

  
        LinkedList originalList = new LinkedList();

        
        System.out.println("Enter elements for the linked list (enter 'done' to finish):");
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                originalList.insert(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'done' to finish.");
            }
        }

        System.out.println("Original Linked List:");
        originalList.display();

      
        // LinkedList copiedList = originalList.copy();
        
        System.out.println("Copied Linked List:");
        originalList.copy();

        // System.out.println("reverse linked list ");
        // originalList.reverse();

        // System.out.println("Modifying original list by inserting a new element...");
        // originalList.insert(999);

        // System.out.println("Modified Original Linked List:");
        // originalList.display();

        // System.out.println("Copied Linked List (unchanged due to deep copy):");
        // copiedList.display();

        scanner.close();
    }
}