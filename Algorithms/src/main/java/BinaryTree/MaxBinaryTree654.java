package BinaryTree;

public class MaxBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        // find the max int in nums
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        // create a node with the max value
        TreeNode curr = new TreeNode(max);
        // curr.left = constructMaxBinTree(prefix nums)
        int[] left = new int[maxIndex];
        for (int j = 0; j < maxIndex; j++) {
            left[j] = nums[j];
        }
        curr.left = constructMaximumBinaryTree(left);
        // curr.right = constructMaxBinTre(surfix nums)
        int[] right = new int[nums.length - maxIndex - 1];
        int rightCount = 0;
        for (int k = maxIndex + 1; k < nums.length; k++) {
            right[rightCount++] = nums[k];
        }
        curr.right = constructMaximumBinaryTree(right);

        // return curr
        return curr;
    }
}
