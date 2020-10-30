package problem463;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[][] nexts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    que.offer(new Pair<>(i, j));
                    break;
                }
            }
        }
        int cnt = 0;
        while (!que.isEmpty()) {
            Pair<Integer, Integer> head = que.poll();
            int tmpCnt = 0;
            for (int[] next : nexts) {
                int nextX = head.getKey() + next[0];
                int nextY = head.getValue() + next[1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 1) {
                    tmpCnt++;
                    if (!vis[nextX][nextY]) {
                        que.offer(new Pair<>(nextX, nextY));
                        vis[nextX][nextY] = true;
                    }
                }
            }
            switch (tmpCnt) {
                case 0:
                    cnt += 4;break;
                case 1:
                    cnt += 3;break;
                case 2:
                    cnt += 2;break;
                case 3:
                    cnt += 1;break;
                default:
                    break;
            }
        }
        return cnt;
    }
}