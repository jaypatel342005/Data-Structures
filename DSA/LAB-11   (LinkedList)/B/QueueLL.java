public class QueueLL
{
    public static void main(String[] args) {
        LinkedListQueue list=new LinkedListQueue();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.display();
        list.delete();
        list.delete();
        list.delete();
        list.display();
    }
}
class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class LinkedListQueue
{
    Node head;
    public LinkedListQueue()
    {
        this.head=null;
    }
    public void add(int value)
    {
        Node node = new Node(value);

        if (head == null) 
        {
            head = node;
            return;
        }
        Node pointer=head;
        while(pointer.next!=null)
        {
            pointer=pointer.next;
        }
        pointer.next=node;
    }

    public void delete()
    {
        if(head==null)
        {
            System.out.println("Queue OverFlow");
            return;
        }
        head=head.next;
    }

    public void display()
    {
        Node pointer=head;
        while(pointer!=null)
        {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
}
