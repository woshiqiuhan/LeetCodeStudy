package problem77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        for (int i = 1; i + k <= n + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            dfs(i, n, k, temp);
        }
        return this.res;
    }

    private void dfs(int i, int n, int k, List<Integer> tmp) {
        if (tmp.size() == k) {
            this.res.add(tmp);
            return;
        }
        for (int j = i + 1; j + k <= n + tmp.size() + 1; j++) {
            List<Integer> temp = new ArrayList<>(tmp);
            temp.add(j);
            dfs(j, n, k, temp);
        }
    }
}