package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInBST230 {
    // BFS
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderBFS(root, inOrder);
        return inOrder.get(k - 1);
    }
    private void inOrderBFS(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderBFS(root.left, list);
        list.add(root.val);
        inOrderBFS(root.right, list);
    }
}

class StackSolution {
    // iterative solution with in order traversal with stack
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        inOrderTraversal(root, stack, k);
        return stack.pop();
    }

    private void inOrderTraversal(TreeNode root, Stack<Integer> stack, int k) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, stack, k);
        if (stack.size() >= k) {
            return;
        }
        stack.push(root.val);
        inOrderTraversal(root.right, stack, k);
    }
}
