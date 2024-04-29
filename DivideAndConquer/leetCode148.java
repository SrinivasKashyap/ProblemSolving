package DivideAndConquer;

import LinkedList.ListNode;

public class leetCode148 {
    public ListNode sortList(ListNode head) {
        ListNode node = mergeSort(head);
        return node;
    }

    public ListNode mergeSort(ListNode head) {
        if (null == head)
            return null;
        if (head.next == null)
            return head;

        // find mid
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        count /= 2;
        ListNode mid = head;
        int i = 1;
        while (i < count) {
            mid = mid.next;
            i++;
        }

        ListNode right = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        right = mergeSort(right);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        // left and right halves will differ maximum by one node because of the divide
        // and conquer approach
        if (left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        if (right != null) {
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
