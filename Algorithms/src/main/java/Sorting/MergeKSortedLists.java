package Sorting;

import utils.ListNode;

/**
 * 23. Hard Feb 11, 2022
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if(len == 1) {
            return lists[0];
        }

        int high = len - 1;

        while (high != 0) {
            int low = 0;
            while (low < high) {
                lists[low] = mergeTwoList(lists[low++], lists[high--]);
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode tail = null;

        while (list1 != null & list2 != null) {
            ListNode next;
            if (list1.getVal() < list2.getVal()) {
                next = list1;
                list1 = list1.getNext();
            } else {
                next = list2;
                list2 = list2.getNext();
            }

            if (result == null) {
                result = next;
            } else {
                tail.setNext(next);
            }
            tail = next;
        }

        ListNode temp = (list1 != null) ? list1: list2;
        if (tail != null) {
            tail.setNext(temp);
        } else {
            result = temp;
        }


        return result;
    }
}
