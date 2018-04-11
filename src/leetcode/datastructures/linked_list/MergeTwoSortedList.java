package leetcode.datastructures.linked_list;

public class MergeTwoSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;

        ListNode result;

        if(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                result = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                result = new ListNode(l1.val);
                l1 = l1.next;
            }
        } else if(l1 == null) {
            result = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            result = new ListNode(l1.val);
            l1 = l1.next;
        }

        result.next = mergeTwoLists(l1, l2);

        return result;
    }
}
