package problem144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        que.addLast(root);

        while (!que.isEmpty()) {
            TreeNode node = que.removeLast();
            res.add(node.val);
            if (node.right != null) {
                que.addLast(node.right);
            }
            if (node.left != null) {
                que.addLast(node.left);
            }
        }
        return res;
    }
}