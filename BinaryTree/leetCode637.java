package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode637 {
        public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        List<Double> result = new ArrayList<Double>();

        if (null != root)q1.add(root);

        while (q1.size() > 0 || q2.size() > 0) {
            Long sum = 0L;
            Long c = 0L;
            if (q1.size() > 0) {            
                while(q1.size() > 0) {
                    TreeNode node = q1.removeLast();
                    sum += (long)node.val;
                    c++;
                    if (null != node.left) q2.add(node.left);
                    if (null != node.right) q2.add(node.right);
                }
                double temp = (double)sum/(double)c;
                result.add(temp);
            } else {
                while (q2.size() > 0) {
                    TreeNode node = q2.removeLast();
                    sum += (long)node.val;
                    c++;
                    if (null != node.left) q1.add(node.left);
                    if (null != node.right) q1.add(node.right);
                }
                double temp = (double)sum/(double)c;
                result.add(temp);
            }
        }
        return result;
    }
}
