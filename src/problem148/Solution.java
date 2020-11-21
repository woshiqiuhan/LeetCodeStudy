package problem148;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeSort(ListNode head) {
        if (head != null && head.next != null) {
            int len = 0;
            ListNode pMove = head;
            while (pMove != null) {
                len++;
                pMove = pMove.next;
            }
            len = len / 2 - 1;
            ListNode list1 = head, list2 = null;
            pMove = head;
            while (len-- != 0) {
                pMove = pMove.next;
            }
            list2 = pMove.next;
            pMove.next = null;
            list1 = mergeSort(list1);
            list2 = mergeSort(list2);
            return merge(list1, list2);
        }
        return head;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode newhead = new ListNode(-1);
        ListNode pMove = newhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pMove.next = list1;
                pMove = pMove.next;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                pMove.next = list2;
                pMove = pMove.next;
                list2 = list2.next;
            } else {
                pMove.next = list1;
                pMove = pMove.next;
                list1 = list1.next;
                pMove.next = list2;
                pMove = pMove.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            pMove.next = list1;
        }
        if (list2 != null) {
            pMove.next = list2;
        }
        return newhead.next;
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}