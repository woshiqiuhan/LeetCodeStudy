package problem234;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    private boolean flag;//偶数长度为true，奇数为false

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        if (!this.flag) {
            mid = mid.next;
        }
        mid = reverseList(mid);
        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = head, r = head;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        if (r == null) {
            this.flag = true;
        } else {
            this.flag = false;
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
