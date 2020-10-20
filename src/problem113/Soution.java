package problem113;

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
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, new ArrayList<>(), sum);
        return this.res;
    }

    private void dfs(TreeNode root, List<Integer> tmp, int sum) {
        sum -= root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                this.res.add(tmp);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, new ArrayList<>(tmp), sum);
            }
            if (root.right != null) {
                dfs(root.right, new ArrayList<>(tmp), sum);
            }
        }
    }
}