package problem116;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> que = new ArrayDeque<>();

        Node pMove = root;
        que.offer(pMove);
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                Node head = que.poll();
                if (i != n - 1){
                    head.next = que.peek();
                }
                if (head.left != null) {
                    que.offer(head.left);
                }
                if (head.right != null) {
                    que.offer(head.right);
                }
            }
        }
        return root;
    }
}