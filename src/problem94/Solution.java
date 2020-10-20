package problem94;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversal1(root);
        return this.res;
    }

    public void inorderTraversal1(TreeNode root) {
        if (root == null) return;
        inorderTraversal1(root.left);
        this.res.add(root.val);
        inorderTraversal1(root.right);
    }
}