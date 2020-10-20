package problem450;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.val == key && root.left == null && root.right == null)) return null;
        TreeNode keyNode;
        if ((keyNode = findKeyNode(root, key)) != null) {
            if (keyNode.left != null) {
                TreeNode maxNode = findMaxNode(root.left);
                keyNode.val = maxNode.val;
                maxNode.val = key;
            } else if (keyNode.right != null) {
                TreeNode minNode = findMinNode(root.right);
                keyNode.val = minNode.val;
                minNode.val = key;
            }
            delete(root, key);
        }
        return root;
    }

    private void delete(TreeNode root, int key) {
        if (root == null) return;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode tmp = que.poll();
            if (tmp.left != null) {
                if (tmp.left.val == key) {
                    tmp.left = null;
                    break;
                }
                que.offer(tmp.left);
            }
            if (tmp.right != null) {
                if (tmp.right.val == key) {
                    tmp.right = null;
                    break;
                }
                que.offer(tmp.right);
            }
        }
    }

    private TreeNode findKeyNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            return root;
        } else if (root.val > key) {
            return findKeyNode(root.left, key);
        } else {
            return findKeyNode(root.right, key);
        }
    }

    private TreeNode findMaxNode(TreeNode root) {
        TreeNode fa = root;
        if (root == null) return root;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private TreeNode findMinNode(TreeNode root) {
        TreeNode fa = root;
        if (root == null) return root;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}