package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root != null) {
                searchBST(root, "", result);
            }

            return result;
        }

        private void searchBST(TreeNode root, String path, List<String> result) {
            if (root.left == null && root.right == null) {
                result.add(path + root.val);
            }

            if (root.left != null) {
                searchBST(root.left, path + root.val + "->", result);
            }

            if (root.right != null) {
                searchBST(root.right, path + root.val + "->", result);
            }
        }
    }
}
