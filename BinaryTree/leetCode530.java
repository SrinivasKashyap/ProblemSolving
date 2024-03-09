package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetCode530 {
    public int getMinimumDifference(TreeNode root) {
        return util(root, new ArrayList<Integer>());
    }

    public int util(TreeNode root, List<Integer> subtract) {
        if (null == root)
            return Integer.MAX_VALUE;
        int leftDiff = Integer.MAX_VALUE;
        int rightDiff = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int n = subtract.size();
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(root.val - subtract.get(i));
            diff = (temp < diff ? temp : diff);
        }
        if (null != root.left) {
            subtract.add(root.val);
            leftDiff = util(root.left, subtract);
            subtract.remove(n);
        }
        if (null != root.right) {
            subtract.add(root.val);
            rightDiff = util(root.right, subtract);
            subtract.remove(n);
        }
        int temp = (leftDiff < rightDiff ? leftDiff : rightDiff);
        return (temp < diff ? temp : diff);
    }
}
