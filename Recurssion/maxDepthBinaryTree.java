public class maxDepthBinaryTree {
        public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }
}
