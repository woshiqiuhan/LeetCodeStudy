package problem40;

import java.util.*;

class Solution {
    private Set<List<Integer>> res = new HashSet<>();
    private int target;
    private int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(candidates[i]));
                dfs(i + 1, tmp, candidates[i]);
            }
        }
        return new ArrayList<>(this.res);
    }

    private void dfs(int i, ArrayList<Integer> tmp, int sum) {
        if (sum > this.target) return;
        if (sum == this.target) {
            Collections.sort(tmp);
            this.res.add(tmp);
            return;
        }
        for (int j = i; j < this.candidates.length; j++) {
            ArrayList<Integer> temp = new ArrayList<>(tmp);
            temp.add(candidates[j]);
            dfs(j + 1, temp, sum + candidates[j]);
        }
    }
}