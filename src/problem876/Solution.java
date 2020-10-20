package problem876;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = head;
        ListNode r = head.next;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        return r;
    }
}