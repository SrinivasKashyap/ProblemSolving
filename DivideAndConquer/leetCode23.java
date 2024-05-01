package DivideAndConquer;

import LinkedList.ListNode;

public class leetCode23 {
    // Approach 1
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = new ListNode();

        // ListNode[] ptrs = new ListNode[lists.length];

        // //assign ptrs to head of the lists
        // for (int i=0; i<lists.length; i++) {
        // ptrs[i] = lists[i];
        // }

        boolean endOfLists = false;
        boolean first = true;

        while (!endOfLists) {
            endOfLists = true;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (null == list)
                    continue;
                endOfLists = false;
                if (list.val < min) {
                    min = list.val;
                    index = i;
                }
            }
            if (!endOfLists) {
                if (first) {
                    curr.val = min;
                    dummy.next = curr;
                    first = false;
                    lists[index] = lists[index].next;
                } else {
                    ListNode next = new ListNode(min);
                    curr.next = next;
                    curr = next;
                    lists[index] = lists[index].next;
                }
            }
        }
        return dummy.next;
    }

    // Approach 2
    public ListNode merge(ListNode a, ListNode b) {
        ListNode temp = new ListNode(-1);
        ListNode res = temp;

        while (null != a && null != b) {
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        while (null != a) {
            temp.next = a;
            a = a.next;
            temp = temp.next;
        }
        while (null != b) {
            temp.next = b;
            b = b.next;
            temp = temp.next;
        }
        return res.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        int last = lists.length - 1;
        while (last > 0) {
            int i = 0;
            int j = last;
            while (i < j) {
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
                last--;
            }
        }
        return lists[last];
    }
}
