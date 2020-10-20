package problem24;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;  //节点不足两个

        ListNode lt = head;
        ListNode ls = lt.next;
        ListNode lf = ls.next;

        head = ls;  //头两个节点特殊处理
        head.next = lt;
        if (lf == null) {  //只有两个节点
            lt.next = null;
        } else {
            lt.next = lf;

            lt = head.next; //不变的
            ls = lt.next;
            lf = ls.next;

            while (lt != null && ls != null && lf != null) {
                ListNode tmp = lf.next;

                lt.next = lf;  //重排列
                lf.next = ls;
                ls.next = tmp;

                if (tmp == null) break;

                lt = lt.next.next; //重新赋值
                ls = lt.next;
                lf = ls.next;
            }
        }

        return head;
    }
}