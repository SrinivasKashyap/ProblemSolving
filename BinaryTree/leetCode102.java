package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode102 {
        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();

        if (null != root) q1.add(root);

        while (q1.size() > 0 || q2.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            if (q1.size() > 0) {
                while (q1.size() > 0) {
                    TreeNode node = q1.remove();
                    temp.add(node.val);
                    if (null != node.left) q2.add(node.left);
                    if (null != node.right) q2.add(node.right);
                }
            } else {
                while (q2.size() > 0) {
                    TreeNode node = q2.remove();
                    temp.add(node.val);
                    if (null != node.left) q1.add(node.left);
                    if (null != node.right) q1.add(node.right);
                }
            }
            // List<Integer> tempResult = new ArrayList<>();
            // for (int i=temp.size()-1; i>=0; i--) {
            //     tempResult.add(temp.get(i));
            // }
            result.add(temp);
        }
        return result;
    }
}
