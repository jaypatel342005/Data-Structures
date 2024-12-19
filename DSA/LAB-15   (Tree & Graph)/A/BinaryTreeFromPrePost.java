class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeFromPrePost {
    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePostHelper(preorder, postorder);
    }

    private TreeNode constructFromPrePostHelper(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (root.val != postorder[postIndex]) {
            root.left = constructFromPrePostHelper(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = constructFromPrePostHelper(preorder, postorder);
        }
        postIndex++;

        return root;
    }

    // Helper function to print inorder traversal of the tree
    public void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);

    }

    public static void main(String[] args) {
        BinaryTreeFromPrePost treeBuilder = new BinaryTreeFromPrePost();

        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };

        TreeNode root = treeBuilder.constructFromPrePost(preorder, postorder);

        System.out.print("Inorder traversal of constructed tree: ");
        treeBuilder.printInorder(root); // Output should show the inorder traversal of the tree
    }
}
