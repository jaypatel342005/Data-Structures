// 77. Write a menu driven program to implement Binary Search Tree (BST) & perform 
// following operations 
//  Insert a node, Delete a node, Search a node




import java.util.Scanner;

// Node class representing each node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int data) {
        key = data;
        left = right = null;
    }
}

// Binary Search Tree class with basic operations
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

    // Delete a node from the BST
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a node
    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with one or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Find the smallest value (inorder successor)
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Search for a node in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive search function
    boolean searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root != null;
        if (key > root.key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    // Inorder traversal to display the BST in sorted order
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
}

public class Lab14_77 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, key;

        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert a Node");
            System.out.println("2. Delete a Node");
            System.out.println("3. Search for a Node");
            System.out.println("4. Display Inorder Traversal");
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
                    System.out.print("Enter the value to delete: ");
                    key = sc.nextInt();
                    bst.deleteKey(key);
                    System.out.println("Node deleted.");
                    break;

                case 3:
                    System.out.print("Enter the value to search: ");
                    key = sc.nextInt();
                    if (bst.search(key))
                        System.out.println("Node found.");
                    else
                        System.out.println("Node not found.");
                    break;

                case 4:
                    System.out.println("Inorder traversal of the BST:");
                    bst.inorder();
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
