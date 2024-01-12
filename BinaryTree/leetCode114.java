package BinaryTree;

public class leetCode114 {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (null == root) return null;
        
        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);
        if (null != root.left) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (null == leftTail && null == rightTail) return root;
        else if (null != rightTail) return rightTail;
        return leftTail;
    }
}
