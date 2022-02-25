package Sorting;

import java.util.*;

/**
 * 692 Medium
 * Bucket Sort
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 */
public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        List<String>[] buckets = new ArrayList[words.length];
        for (int i = 0; i < words.length; i++) buckets[i] = new ArrayList<>();

        for (String w : count.keySet()) {
            buckets[count.get(w)].add(w);
        }

        List<String> ans = new ArrayList<>();
        for (int i = words.length - 1; i >= 0; i--) {
            if (buckets[i].size() == 0)
                continue;
            Collections.sort(buckets[i]);
            for (int j = 0; j < buckets[i].size(); j++) {
                ans.add(buckets[i].get(j));
                if (ans.size() == k)
                    break;
            }
            if (ans.size() == k)
                break;
        }

        return ans;
    }
}
