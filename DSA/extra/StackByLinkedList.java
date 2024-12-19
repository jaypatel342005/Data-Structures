class CLL {

	public Node first;
	public Node last;

	class Node {
		int info;
		Node link;

		public Node(int data) {
			this.info = data;
			this.link = null;
		}
	}

	// add first

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (first == null) {
			newNode.link = newNode;
			first = newNode;
			last = newNode;
		}

		newNode.link = first;
		last.link = newNode;
		first = newNode;

		return;
	}

	// add last

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (first == null) {
			newNode.link = newNode;
			first = newNode;
			last = newNode;
		}

		newNode.link = first;
		last.link = newNode;
		last = newNode;

		return;
	}

	// add at order

	public void addOrder(int data) {
		Node newNode = new Node(data);
		if (first == null) {
			newNode.link = newNode;
			first = newNode;
			last = newNode;
		}

		if (newNode.info <= first.info) {
			newNode.link = first;
			last.link = newNode;
			first = newNode;
		}

		Node save = first;

		while (save != last && newNode.info >= save.link.info) {
			save = save.link;
		}

		newNode.link = save.link;
		save.link = newNode;

		if (save == last) {
			last = newNode;
		}

		return;
	}

	// delete a node

	void delete(int key) {
        if (first == null) return;
        if (first.info == key) {
            if (first.link == first) { // Only one node in the list
                first = null;
                last = null;
            } else {
                last.link = first.link;
                first = first.link;
            }
            return;
        }

        Node current = first;
        Node previous = null;
        do {
            previous = current;
            current = current.link;
            if (current.info == key) {
                previous.link = current.link;
                if (current == last) { 
                    last = previous;
                }
                return;
            }
        } while (current != first);
    }
	public void printList() {
		if (first == null) {
			System.out.println("list is empty");
			return;
		}
		Node curNode = first;
		do {
			System.out.print(curNode.info + "--> ");
			curNode = curNode.link;
		} while (curNode != first);

		System.out.println("null");
	}
}

public class Cir_Lin_Lis_Demo {
	public static void main(String[] args) {
		CLL list = new CLL();

		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		list.addOrder(5);
		list.addOrder(6);
		list.addLast(7);
		list.addLast(8);
		list.addLast(9);
		list.delNode(2);
		list.printList();

	}
}