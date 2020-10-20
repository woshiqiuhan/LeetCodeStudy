package problem701;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode pMove = root;
        while (true) {
            if (pMove.val > val) {
                if (pMove.left == null) {
                    pMove.left = new TreeNode(val);
                    break;
                } else {
                    pMove = pMove.left;
                }
            } else {
                if (pMove.right == null) {
                    pMove.right = new TreeNode(val);
                    break;
                } else {
                    pMove = pMove.right;
                }
            }
        }
        return root;
    }

}