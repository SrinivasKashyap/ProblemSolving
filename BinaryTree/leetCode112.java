package BinaryTree;

public class leetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root)
            return false;
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int target, int sum) {
        sum += root.val;
        if (null == root.left && null == root.right && sum == target)
            return true;
        if (null == root.left && null == root.right)
            return false;

        boolean left = false;
        boolean right = false;
        if (null != root.left)
            left = dfs(root.left, target, sum);
        if (null != root.right)
            right = dfs(root.right, target, sum);
        return left || right;
    }
}
