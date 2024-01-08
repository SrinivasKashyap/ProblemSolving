package BinaryTree;

public class leetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return null;

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
