package BinaryTree;

public class leetCode236 {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        util(root, p, q);
        return lca;
    }
    public boolean util(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) return false;
        boolean left = util(root.left, p, q);
        boolean right = util(root.right, p, q);
        if (root == p || root == q) {
            if ((left || right) && null == lca) lca = root;
            return true;
        } else {
            if (left && right && null == lca) lca = root;
            return left || right;
        }
    }
}
