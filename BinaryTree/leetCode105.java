package BinaryTree;

public class leetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return util(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    public TreeNode util(int[] preorder, int[] inorder, int stIn, int endIn, int stPre, int endPre) {
        if ((stPre > endPre)) return null;

        TreeNode root = new TreeNode(preorder[stPre]);
        int mid = -1;

        for (int i=stIn; i<=endIn; i++) {
            if (inorder[i] == preorder[stPre]) mid = i;
        }

        int leftStIn = stIn;
        int leftEndIn = mid-1;
        int rightStIn = mid+1;
        int rightEndIn = endIn;

        int leftStPre = stPre + 1;
        int leftEndPre = leftStPre + (leftEndIn - leftStIn);
        int rightStPre = leftEndPre + 1;
        int rightEndPre = endPre;

        root.left = util(preorder, inorder, leftStIn, leftEndIn, leftStPre, leftEndPre);
        root.right = util(preorder, inorder, rightStIn, rightEndIn, 
        rightStPre, rightEndPre);

        return root;
    }
}
