package problem501;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private Map<Integer, Integer> mp = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        countEle(root);

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(mp.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Set<Integer> res = new HashSet<>();
        res.add(entries.get(0).getKey());
        int lastCnt = entries.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() != lastCnt) {
                break;
            }
            res.add(entry.getKey());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void countEle(TreeNode root) {
        if (root == null) return;
        if (!mp.containsKey(root.val)) {
            mp.put(root.val, 0);
        }
        mp.put(root.val, mp.get(root.val) + 1);
        countEle(root.left);
        countEle(root.right);
    }
}