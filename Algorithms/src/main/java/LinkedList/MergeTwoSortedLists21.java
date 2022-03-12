package LinkedList;

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode resultHead = new ListNode(-1);
        ListNode curr = resultHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        }

        if (l2 == null) {
            curr.next = l1;
        }
        return resultHead.next;
    }
}
