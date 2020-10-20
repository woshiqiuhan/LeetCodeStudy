package problem143;

import java.util.List;

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);

        while (l2 != null) {
            ListNode tmp = l2.next;
            l2.next = l1.next;
            l1.next = l2;

            l1 = l2.next;
            l2 = tmp;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = head;
        ListNode r = head;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        return l;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pPro = head;
        ListNode pMove = head.next;

        while (pMove.next != null) {
            ListNode tmp = pMove.next;
            pMove.next = pPro;
            pPro = pMove;
            pMove = tmp;
        }
        pMove.next = pPro;
        head.next = null;
        return pMove;
    }
}