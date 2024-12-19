class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SmallestLargestBST {

    public int findSmallest(TreeNode root) {
        // Traverse to the leftmost node in the BST
        while (root.left != null) {
            root = root.left;
        }
        // Return the value of the leftmost node
        return root.val;
    }

    public int findLargest(TreeNode root) {
        // Traverse to the rightmost node in the BST
        while (root.right != null) {
            root = root.right;
        }
        // Return the value of the rightmost node
        return root.val;
    }

    public static void main(String[] args) {
        SmallestLargestBST bst = new SmallestLargestBST();

        // Create a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Find the smallest element
        int smallest = bst.findSmallest(root);
        System.out.println("Smallest element in the BST: " + smallest);

        // Find the largest element
        int largest = bst.findLargest(root);
        System.out.println("Largest element in the BST: " + largest);
    }
}
