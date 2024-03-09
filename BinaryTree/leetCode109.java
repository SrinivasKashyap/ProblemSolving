package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode109 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> qOne = new LinkedList<>();
        LinkedList<TreeNode> qTwo = new LinkedList<>();

        if (null != root) {
            qOne.add(root);
            boolean reverse = false;
            while (qOne.size() > 0 || qTwo.size() > 0) {
                List<Integer> temp = new ArrayList<>();
                if (qOne.size() > 0) {
                    while (qOne.size() > 0) {
                        TreeNode node = qOne.pollFirst();
                        temp.add(node.val);
                        if (null != node.left)
                            qTwo.add(node.left);
                        if (null != node.right)
                            qTwo.add(node.right);
                    }
                } else {
                    while (qTwo.size() > 0) {
                        TreeNode node = qTwo.pollFirst();
                        temp.add(node.val);
                        if (null != node.left)
                            qOne.add(node.left);
                        if (null != node.right)
                            qOne.add(node.right);
                    }
                }
                if (reverse) {
                    reverse = false;
                    int i = 0, j = temp.size() - 1;
                    while (i < j) {
                        int a = temp.get(i);
                        int b = temp.get(j);
                        temp.set(i, b);
                        temp.set(j, a);
                        i++;
                        j--;
                    }
                } else {
                    reverse = true;
                }
                result.add(temp);
            }
        }
        return result;
    }
}
