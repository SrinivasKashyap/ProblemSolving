package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetCode129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<Integer>());
        return sum;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (null == root.left && null == root.right) {
            sum += generateNum(list);
            return;
        }
        int n = list.size();
        if (null != root.left) {
            dfs(root.left, list);
            list.remove(n);
        }
        if (null != root.right) {
            dfs(root.right, list);
            list.remove(n);
        }
    }

    public int generateNum(List<Integer> list) {
        int n = list.size();
        int num = 0;
        for (int i = 0; i < n; i++) {
            double multiplier = Math.pow(10, n - (i + 1));
            num += (list.get(i) * multiplier);
        }
        return num;
    }
}
