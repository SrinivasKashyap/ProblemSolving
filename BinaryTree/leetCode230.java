package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetCode230 {
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        util(root, k);
        return result;
    }

    int order = 0;

    public void util(TreeNode root, int k) {
        if (null == root) {
            return;
        }
        util(root.left, k);
        ++order;
        if (order == k)
            result = root.val;
        util(root.right, k);
    }
}
