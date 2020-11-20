package problem147;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode pPre = head;
        if (pPre == null) {
            return head;
        }
        ListNode pMove = pPre.next;
        while (pPre != null && pMove != null) {
            if (pMove.val <= head.val) {  //pMove为新头结点
                pPre.next = pMove.next;
                pMove.next = head;
                head = pMove;
            } else {
                if (pPre == head) {
                    pPre = pMove;
                } else {
                    ListNode tmp = head;
                    while (tmp != pPre) {
                        if (tmp.val < pMove.val && tmp.next.val >= pMove.val) {
                            pPre.next = pMove.next;
                            pMove.next = tmp.next;
                            tmp.next = pMove;
                            break;
                        }
                        tmp = tmp.next;
                    }
                }
            }
            if (pPre != null) {
                pMove = pPre.next;
            }
            if (pMove != null && pMove.val >= pPre.val) {
                pPre = pMove;
                pMove = pPre.next;
            }
        }
        return head;
    }

    private void print(ListNode head) {
        ListNode pMove = head;
        while (pMove != null) {
            System.out.print(pMove.val + " ");
            pMove = pMove.next;
        }
        System.out.println();
    }
}

/*

class Solution {
    public ListNode insertSort(ListNode head){
        ListNode pMove = head.next;
        ListNode lastNode = head;
        while(pMove != null){
            ListNode tmp = pMove;
            pMove = pMove.next;
            if(tmp.val >= lastNode.val){
                lastNode = tmp;
            }else{
                lastNode.next = pMove;
                if(tmp.val <= head.val){
                    tmp.next = head;
                    head = tmp;
                }else{
                    ListNode temp = head;
                    ListNode lastTemp = head;
                    while(temp != tmp && tmp.val > temp.val){
                        lastTemp = temp;
                        temp = temp.next;
                    }
                    tmp.next = temp;
                    if(temp != head){
                        lastTemp.next =tmp;
                    }
                }

            }
        }
        return head;
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null)return null;
        return insertSort(head);
    }
}
*/