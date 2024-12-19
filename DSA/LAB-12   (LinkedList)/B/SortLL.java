import java.util.Scanner;

public class SortLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperation list = new LinkedListOperation();
        
        System.out.println("Enter elements of the linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1) break;
            list.insert(value);
        }

        // Display the original linked list
        System.out.println("Original linked list:");
        list.display();
        
        // Sort the linked list
        list.head = list.mergeSort(list.head);

        // Display the sorted linked list
        System.out.println("Sorted linked list:");
        list.display();

        sc.close();
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

class LinkedListOperation {
    Node head;

    public LinkedListOperation() {
        this.head = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
    }

    public void display() {
        if (head != null) {
            Node pointer = head;
            System.out.println("\n-------Linked List is-------");
            while (pointer != null) {
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            }
            System.out.println();
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);

        return sortedList;
    }

    public Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public Node sortedMerge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }
}