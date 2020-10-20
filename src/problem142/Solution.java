package problem142;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (fast != null) {
            low = low.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == low) {
                ListNode tmp = head;
                while (tmp != low) {
                    tmp = tmp.next;
                    low = low.next;
                }
                return tmp;
            }
        }
        return null;
    }
}