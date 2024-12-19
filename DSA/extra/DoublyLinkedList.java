// linked list.
// Insert a node at the front of the linked list.
// Delete a node from specified position.
// Insert a node at the end of the linked list. (Home Work)
// Display all nodes. (Home Work)

class DLinkedList {
    class Node {
        int info;
        Node link;
        Node prev;

        public Node(int data) {
            this.info = data;
            this.link = null;
            this.prev = null;
        }
    }

    Node first;
    Node last;

    public DLinkedList() {
        this.first = null;
        this.last = null;
    }

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.link = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void delete(int data) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node save = first;
        while (save != null && save.info != data) {
            save = save.link;
        }
        if (save == null) {
            System.out.println("Node not found");
            return;
        }
        if (save == first && save == last) {
            first = null;
            last = null;
        } else if (save == first) {
            first = first.link;
            if (first != null) {
                first.prev = null;
            }
        } else if (save == last) {
            last = last.prev;
            last.link=null;
            // if (last != null) {
            //     last = last.link;
            // }
        } else {
            save.prev.link = save.link;
            save.link.prev = save.prev;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            first = newNode;
        } else {
            last.link = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    public void display() {
        if (first == null) {
            System.out.println("This list is empty");
        }
        Node save = first;
        while (save != null) {
            System.out.println(save.info + " ");
            save = save.link;
        }
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.insertAtLast(10);
        dLinkedList.insertAtLast(20);
        dLinkedList.insertAtLast(50);
        dLinkedList.insertAtLast(60);
        dLinkedList.insertAtLast(70);
        dLinkedList.delete(20);
        dLinkedList.display();
    }
}