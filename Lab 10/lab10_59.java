// WAP to check whether 2 singly linked lists are same or not. 
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to append a new node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to compare two linked lists
    static boolean areIdentical(LinkedList list1, LinkedList list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // If both lists are empty, they are identical
        return current1 == null && current2 == null;
    }
}

public class lab10_59 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(2);
        list1.append(3);

        LinkedList list2 = new LinkedList();
        list2.append(1);
        list2.append(2);
        list2.append(3);

        LinkedList list3 = new LinkedList();
        list3.append(1);
        list3.append(2);
        list3.append(4);

        System.out.println("List1 and List2 are identical: " + LinkedList.areIdentical(list1, list2));  // Output: true
        System.out.println("List1 and List3 are identical: " + LinkedList.areIdentical(list1, list3));  // Output: false
    }
}



    

