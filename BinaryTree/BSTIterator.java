package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    List<Integer> arr = new ArrayList<Integer>();
    int index = -1;
    int n = -1;

    public BSTIterator(TreeNode root) {
        inOrderTraversal(root, arr);
    }

    public int next() {
        int n = arr.size();
        if (index < n - 1) {
            index++;
            return arr.get(index);
        }
        return -1;
    }

    public boolean hasNext() {
        int n = arr.size();
        if (index < n - 1)
            return true;
        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> arr) {
        if (null == root)
            return;
        inOrderTraversal(root.left, arr);
        arr.add(root.val);
        inOrderTraversal(root.right, arr);
    }
}
