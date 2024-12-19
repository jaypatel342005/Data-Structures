class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SameTree {
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Both trees are empty
        if (p == null && q == null) {
            return true;
        }
        // One tree is empty, and the other is not
        if (p == null || q == null) {
            return false;
        }
        // The current nodes have different values
        if (p.val != q.val) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(4);
        tree1.left.right = new TreeNode(1);


        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(4);
        // tree2.left.right = new TreeNode(1);

        System.out.println(isSameTree(tree1, tree2)); // Output: true

        // TreeNode tree3 = new TreeNode(1);
        // tree3.left = new TreeNode(2);

        // TreeNode tree4 = new TreeNode(1);
        // tree4.right = new TreeNode(2);

        // System.out.println(isSameTree(tree3, tree4)); // Output: false
    }
}
