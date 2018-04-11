package leetcode.sorts;

public class InsertionSortLinkedList {

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


    public static ListNode insertionSortList_leetcodeSolution(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null) return head;

        // recursive call to sift largest to the end
        head.next = insertionSortList(head.next);

        ListNode parent = head;

        ListNode next = head.next;

        ListNode before = null;

        // set next to parent because head will be swapped
        if(head.val > next.val) parent = next;

        // swap
        // [before] -> [head] -> [next]
        // [before] -> [next] -> [head]
        // shift forward
        // [next] -> [head] -> [head.next]
        while(next != null && head.val > next.val) {
            swap(before, head, next);
            before = next;
            next = head.next;
        }

        return parent;
    }

    public static void swap(ListNode parent, ListNode first, ListNode second) {
        first.next = second.next;
        if(parent != null) parent.next = second;
        second.next = first;
    }

//    public static void main(String[] args) {
//
//        ListNode ln3 = new ListNode(8,
//                new ListNode(2,
//                        new ListNode(9,
//                                new ListNode(5,
//                                        new ListNode(2,
//                                                new ListNode(1))))));
//
//        ListNode result = insertionSortList(ln3);
//        while (result != null) {
//            System.out.println(result.val + " ");
//            result = result.next;
//        }
//    }

    public static void main(String[] args) {
        String str = "14";
        System.out.println(str.compareTo("12"));
        System.out.println(str.compareToIgnoreCase("abc"));
    }
}
