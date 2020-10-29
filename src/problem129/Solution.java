package problem129;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            pre(root, "");
        }
        return sum;
    }

    private void pre(TreeNode root, String tmp) {
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(tmp + root.val);
            return;
        }
        if (root.left != null) {
            pre(root.left, tmp + root.val);
        }
        if (root.right != null) {
            pre(root.right, tmp + root.val);
        }
    }
}