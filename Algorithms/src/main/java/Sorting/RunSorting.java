package Sorting;

import utils.ListNode;

import java.util.Random;

public class RunSorting {
    public static void main(String[] args) {
        Random rand = new Random();
        int upperBound = 100;
        ListNode[] list = new ListNode[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new ListNode(rand.nextInt(upperBound));
        }
        MergeKSortedLists merge = new MergeKSortedLists();
        ListNode result = merge.mergeKLists(list);
        for (int j = 0; j < 10; j++) {
            System.out.print(result.getVal() + " ");
            result = result.getNext();
        }

    }
}
