package BinaryTree;

public class MaxDepthOfBinaryTree104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_depth = maxDepth(root.left);
            int right_depth = maxDepth(root.right);
            return Math.max(left_depth, right_depth) + 1;
        }
    }
}
