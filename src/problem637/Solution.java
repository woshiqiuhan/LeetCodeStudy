package problem637;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();
            long sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode head = que.poll();
                if (head.left != null) {
                    que.offer(head.left);
                }
                if (head.right != null) {
                    que.offer(head.right);
                }
                sum += head.val;
            }
            res.add((double)sum/(double)len);
        }
        return res;

    }
}
