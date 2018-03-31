package hackerrank;

public class CycleDetection {
    class Node {
        int data;
        Node next;
    }

    static boolean hasCycle(Node head) {
        if(head == null) return false;
        if(head.next == null) return false;
        if(head == head.next) return true;

        Node front = head.next;
        Node back = head;

        while(front != null) {
            back = back.next;
            front = front.next;
            if(front == null) return false;
            front = front.next;
            if(front == back) return true;
        }

        return false;
    }

}
