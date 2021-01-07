package problem547;

class Solution {
    private int[] fa;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        if (n == 0) {
            return 0;
        }

        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (fa[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    private int find(int i) {
        if (fa[i] == i) {
            return i;
        }
        return fa[i] = find(fa[i]);
    }

    private void merge(int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi != fj) {
            fa[fj] = fi;
        }
    }
}