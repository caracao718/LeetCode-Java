package BinaryTree;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}
