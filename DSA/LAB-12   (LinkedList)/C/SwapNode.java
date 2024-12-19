import java.util.Scanner;

public class SwapNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperation originalList = new LinkedListOperation();

        System.out.println("Enter elements of the original linked list (enter -1 to end):");
        while (true) {
            int value = sc.nextInt();
            if (value == -1)
                break;
            originalList.insert(value);
        }

        // Display the original linked list
        System.out.println("Original linked list:");
        originalList.display();

        System.out.print("Enter the swap position term : ");
        int swap_position=sc.nextInt();

        originalList.swap(swap_position);

        System.out.println("After swap linked list:");
        originalList.display();

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
    int node_counter=0;

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
                node_counter++;
            }
            System.out.println();
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public void swap(int position) {
        if (position >= node_counter || position <= 0) {
            System.out.println("Position is out of the range");
        } else {
            int first_position = position;
            int last_position = node_counter - position + 1;
            if (position == 1) {
                Node last_prev = head;
                while (last_prev.next != null && last_prev.next.next != null) {
                    last_prev = last_prev.next;
                }
                Node last = last_prev.next;
                last_prev.next = head;
                head = last;
                last.next = head.next;
                head.next = null;
            } else {
                Node first_pre = head;
                Node last_pre = head;
                for (int i = 1; i < first_position - 1; i++) {
                    first_pre = first_pre.next;
                }
                for (int i = 1; i < last_position - 1; i++) {
                    last_pre = last_pre.next;
                }
                
                Node first = first_pre.next;
                Node last = last_pre.next;
                
                Node temp = first.next;
                first_pre.next = last;
                last_pre.next = first;
                first.next = last.next;
                last.next = temp;
            }
        }
    }
    

}