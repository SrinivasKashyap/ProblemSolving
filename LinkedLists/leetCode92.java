package LinkedLists;

public class leetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int i=1;

        if (null == curr) return curr;

        while (null != curr) {

            if (i == left) {
                ListNode first = curr;
                ListNode innerPrev = null;
                while (i < right) {
                    ListNode next = curr.next;
                    curr.next = innerPrev;
                    innerPrev = curr;
                    curr = next;
                    i++;
                }
                ListNode next = curr.next;
                curr.next = innerPrev;
                if (null != prev) prev.next = curr;
                first.next = next;
                prev = curr;
                curr = next;
                break;
            } else {
                prev = curr;
                curr = curr.next;
                i++;
            }
        }
        if (left == 1) return prev;
        return head;
    }
}
