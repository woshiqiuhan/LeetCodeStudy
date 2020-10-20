package problem206;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pPro = head;
        ListNode pMove = head.next;

        while (pMove.next != null) {
            ListNode tmp = pMove.next;
            pMove.next = pPro;
            pPro = pMove;
            pMove =tmp;
        }
        pMove.next = pPro;
        head.next = null;
        return pMove;
    }
}
