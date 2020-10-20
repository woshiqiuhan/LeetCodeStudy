package problem617;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;

        if (t1.left == null) {
            t1.left = t2.left;
        } else if (t2.left != null) {
            mergeTrees(t1.left, t2.left);
        }

        if (t1.right == null) {
            t1.right = t2.right;
        } else if (t2.right != null) {
            mergeTrees(t1.right, t2.right);
        }

        return t1;
    }
}