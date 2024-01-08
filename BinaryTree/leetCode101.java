package BinaryTree;

public class leetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return util(root, root);
    }
    public boolean util(TreeNode leftRoot, TreeNode rightRoot) {
        if (null == leftRoot && null == rightRoot) return true;
        if (null == leftRoot) return false;
        if (null == rightRoot) return false;

        if (leftRoot.val != rightRoot.val) return false;
        
        boolean a = util(leftRoot.left, rightRoot.right);
        boolean b = util(leftRoot.right, rightRoot.left);
        
        if (a && b) return true;
        else return false;
    }
}
