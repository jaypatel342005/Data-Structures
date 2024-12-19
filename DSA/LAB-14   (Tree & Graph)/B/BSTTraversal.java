import java.util.Scanner;

public class BSTTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice, key;
        while (true) {
            System.out.println("Binary Search Tree Operations:");
            System.out.println("1. Inorder Search");
            System.out.println("2. Preorder Search");
            System.out.println("3. Postorder Search");
            System.out.println("4. Insert");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inorder Traversal of BST: ");
                    bst.inOrder();
                    break;
                case 2:
                    System.out.print("Preorder Traversal of BST: ");
                    bst.preOrder();
                    break;
                case 3:
                    System.out.print("Postorder Traversal of BST: ");
                    bst.postOrder();
                    break;
                case 4:
                    System.out.print("Enter the key to insert: ");
                    key = sc.nextInt();
                    bst.insert(key);
                    System.out.println(key + " inserted into the BST.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
            System.out.println();
        }
    }
}

class BinarySearchTree {
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}
