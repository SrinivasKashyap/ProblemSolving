package BinaryTree;

public class leetCode98 {
    public boolean isValidBST(TreeNode root) {
        if (null == root)
            return true;
        boolean isLess = isLesser(root.left, root.val);
        boolean isGreat = isGreater(root.right, root.val);
        boolean isLeft = isValidBST(root.left);
        boolean isRight = isValidBST(root.right);

        if (isLeft && isRight && isLess && isGreat)
            return true;
        return false;
    }

    public boolean isLesser(TreeNode root, int val) {
        if (null == root)
            return true;
        if (root.val >= val)
            return false;
        return isLesser(root.left, val) && isLesser(root.right, val);
    }

    public boolean isGreater(TreeNode root, int val) {
        if (null == root)
            return true;
        if (root.val <= val)
            return false;
        return isGreater(root.left, val) && isGreater(root.right, val);
    }

    // Efficient
    public boolean isValidBSTApproach2(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if (null == root)
            return true;
        if (min >= root.val || max <= root.val)
            return false;
        return (isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max));
    }
}
