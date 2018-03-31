package leetcode.sorts;

public class MergeSortLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + val + '}';
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode front = head;
        ListNode next = head.next;

        while(next != null && next.next != null) {
            front = front.next;
            next = next.next.next;
        }

        ListNode current = front.next;
        front.next = null;

        return merge(sortList(head), sortList(current));
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null) return null;
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode head;
        ListNode current;

        if(head1.val <= head2.val) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while(head1 != null || head2 != null) {

            if(head1 == null) {
                current.next = head2;
                head2 = head2.next;
            } else if(head2 == null) {
                current.next = head1;
                head1 = head1.next;
            } else if(head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        return head;
    }
}
