package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> qOne = new LinkedList<TreeNode>();
        LinkedList<TreeNode> qTwo = new LinkedList<TreeNode>();

        if (null != root) {
            qOne.add(root);

            while (qOne.size() > 0 || qTwo.size() > 0) {
                while (qOne.size() > 0) {
                    TreeNode node = qOne.pollFirst();
                    if (null != node.left)
                        qTwo.add(node.left);
                    if (null != node.right)
                        qTwo.add(node.right);
                    if (qOne.size() == 0)
                        result.add(node.val);
                }
                while (qTwo.size() > 0) {
                    TreeNode node = qTwo.pollFirst();
                    if (null != node.left)
                        qOne.add(node.left);
                    if (null != node.right)
                        qOne.add(node.right);
                    if (qTwo.size() == 0)
                        result.add(node.val);
                }
            }
        }
        return result;
    }
}
