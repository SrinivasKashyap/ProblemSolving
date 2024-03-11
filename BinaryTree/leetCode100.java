package BinaryTree;

public class leetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p) return false;
        if (null == q) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
