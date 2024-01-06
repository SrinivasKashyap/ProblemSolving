package LinkedLists;

public class leetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        if (null == a || null == a.next) return false;
        if (null == b) return false;
        a = a.next.next;
        b = b.next;

        while (null != a && null != a.next) {
            if (a == b) return true;
            a = a.next.next;
            b = b.next;
        }
        return false;
    }
}
