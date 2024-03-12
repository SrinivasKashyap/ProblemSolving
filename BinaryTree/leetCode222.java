package BinaryTree;

public class leetCode222 {
    Integer count = 0;

    public int countNodes(TreeNode root) {
        inOrderTraversal(root);
        return count;
    }

    public void inOrderTraversal(TreeNode root) {
        if (null == root)
            return;
        inOrderTraversal(root.left);
        count++;
        inOrderTraversal(root.right);
    }
}
