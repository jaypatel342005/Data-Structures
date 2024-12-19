public class StackLL {
    public static void main(String[] args) {
        LinkedListStack list=new LinkedListStack();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.display();
        list.pop();
        list.pop();
        list.pop();
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
class LinkedListStack
{
    Node head;
    public LinkedListStack()
    {
        this.head=null;
    }
    public void push(int value)
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

    public void pop()
    {
        if (head == null) 
        {
            System.out.println("------The List is empty------");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node pre_pointer=head;
        Node pointer=head.next;
        while(pointer.next!=null)
        {
            pointer=pointer.next;
            pre_pointer=pre_pointer.next;
        }
        pre_pointer.next=null;
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

