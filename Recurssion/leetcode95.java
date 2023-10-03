/*
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
import java.util.ArrayList;
import java.util.List;

public class leetcode95 {
        public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public List<TreeNode> generate(int l, int r) {
        if (l == r) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            TreeNode node = new TreeNode(l);
            list.add(node);
            return list;
        }
        if (l > r) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        List<TreeNode> res = new ArrayList<TreeNode>();
        for (int i=l; i<=r; i++) {
            List<TreeNode> left = generate(l, i-1);
            List<TreeNode> right = generate(i+1, r);
            for (int j=0; j<left.size(); j++) {
                for (int k=0; k<right.size(); k++) {
                    TreeNode root = new TreeNode(i, left.get(j), right.get(k));
                    res.add(root);
                }
            }
        }
        return res;
    }
}
