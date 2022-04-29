package Graph;

import java.util.HashSet;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }
        int ls =0;

        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (hs.contains(current + 1)) {
                    current += 1;
                    streak += 1;
                }
                ls = Math.max(ls, streak);
            }
        }
        return ls;
    }
}
