package problem530;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int getMinimumDifference(TreeNode root) {
        int res =Integer.MAX_VALUE;
        if (root.left != null) {
            int minimumDifference = getMinimumDifference(root.left);
            res = Math.min(minimumDifference, res);
            TreeNode pMove = root.left;
            while (pMove.right != null) {
                pMove = pMove.right;
            }
            res = Math.min(Math.abs(pMove.val - root.val), res);
        }
        if (root.right != null) {
            int minimumDifference = getMinimumDifference(root.right);
            res = Math.min(minimumDifference, res);
            TreeNode pMove = root.right;
            while (pMove.left != null) {
                pMove = pMove.left;
            }
            res = Math.abs(pMove.val - root.val);
            res = Math.min(Math.abs(pMove.val - root.val), res);
        }
        return res;
    }
}