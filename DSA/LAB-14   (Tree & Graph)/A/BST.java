import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice, key;
        while (true) {
            System.out.println("Binary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display ( <1>Inorder Traversal <2>Preorder Traversal <1>Postorder Traversal)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    key = sc.nextInt();
                    bst.insert(key);
                    System.out.println(key + " inserted into the BST.");
                    break;
                case 2:
                    System.out.print("Enter the key to delete: ");
                    key = sc.nextInt();
                    if (bst.search(key)) {
                        bst.delete(key);
                        System.out.println(key + " deleted from the BST.");
                    } else {
                        System.out.println(key + " not found in the BST.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the key to search: ");
                    key = sc.nextInt();
                    if (bst.search(key)) {
                        System.out.println(key + " found in the BST.");
                    } else {
                        System.out.println(key + " not found in the BST.");
                    }
                    break;
                case 4:
                    System.out.print("Enter order : ");
                    int order = sc.nextInt();
                    switch (order) {
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
                        default:
                            break;
                    }
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

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data < key) {
            return searchRec(root.right, key);
        }
        return searchRec(root.left, key);
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
