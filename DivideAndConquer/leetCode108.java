package DivideAndConquer;

import BinaryTree.TreeNode;

public class leetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        util(nums, root, 0, nums.length - 1);
        return root;
    }

    public void util(int[] nums, TreeNode root, int l, int r) {
        if (r < l)
            return;
        int m = (l + r) / 2;
        root.val = nums[m];
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        if ((m + 1) <= r) {
            root.right = right;
            util(nums, right, m + 1, r);
        }
        if ((m - 1) >= l) {
            root.left = left;
            util(nums, left, l, m - 1);
        }
    }
}
