package Sorting;

/**
 * 912. Medium
 * Counting Sort
 *
 * Given an array of integers nums, sort the array in ascending order.
 */
public class SortAnArray912 {
    public int[] sortArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) { // add 50000 to all elements so that we can use an array to keep track of their count.
            nums[i] += 50000;
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int j = 1; j <= max; j++) {
            count[j] += count[j - 1];
        }
        int[] sorted = new int[nums.length];
        for (int num : nums) {
            int index = count[num] - 1;
            count[num]--;
            sorted[index] = num;
        }
        for (int i = 0; i < nums.length; i++) {
            sorted[i] -= 50000;
        }
        return sorted;
    }
}
