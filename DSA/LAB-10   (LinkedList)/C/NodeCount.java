public class NodeCount 
{
    public static void main(String[] args) {
        LinkedListOperation list=new LinkedListOperation();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.counter();
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
class LinkedListOperation
{
    Node head;
    Node tail;

    public LinkedListOperation()
    {
        this.head=null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head; 
        } else {
            tail.next = node;
            tail = node;
            tail.next = head; 
        }
    }
    public void display() {
        if (head != null) {
            Node pointer = head;
            System.out.println("\n-------Circular Linked List is-------");
            do {
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            } while (pointer != head);
        }
    }
    public void counter()
    {
        if (head != null) {
            Node pointer = head;
            int node_counter=0;
            do {
                pointer=pointer.next;
                node_counter++;
            } while (pointer != head);
            System.out.println("\nNode count is : "+node_counter);
        }
    }
    
}