// 78. Write a menu driven program to implement Binary Search Tree (BST) & perform 
// following operations 
//  Preorder Traversal, Postorder Traversal, Inorder Traversal


import java.util.Scanner;

// Node class representing each node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Binary Search Tree class with traversal operations
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a node in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new node
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Preorder Traversal (Root, Left, Right)
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Inorder Traversal (Left, Root, Right)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class Lab14_78 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, key;

        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert a Node");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    key = sc.nextInt();
                    bst.insert(key);
                    System.out.println("Node inserted.");
                    break;

                case 2:
                    System.out.println("Preorder traversal of the BST:");
                    bst.preorder();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Inorder traversal of the BST:");
                    bst.inorder();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Postorder traversal of the BST:");
                    bst.postorder();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}
