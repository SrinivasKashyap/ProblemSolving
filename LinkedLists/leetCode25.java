package LinkedLists;

public class leetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int n = 0;
        while (null != node) {
            n++;
            node = node.next;
        }
        n = n/k;

        ListNode curr = head;
        ListNode prev = null;

        int nCount = 0;

        while (null != curr) {
            int i=1;
            ListNode first = curr;
            ListNode innerPrev = null;
            nCount++;
            while (i<k) {
                if (nCount > n) break;
                ListNode next = curr.next;
                curr.next = innerPrev;
                innerPrev = curr;
                curr = next; 
                i++;
            }
            ListNode next = curr.next;
            curr.next = innerPrev;
            first.next = next;
            if (null != prev) prev.next = curr;
            if (nCount == 1) head = curr;
            // return curr;
            prev = first;
            curr = next;
        }

        return head;
    }
}
