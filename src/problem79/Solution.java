package problem79;

class Solution {
    int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean p = false;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] flag = new boolean[n][m];
                    flag[i][j] = true;
                    dfs(board, i, j, word, 1, flag, n, m);
                    if (p) {
                        break;
                    }
                }
            }
        }
        return p;
    }

    public void dfs(char[][] board, int x, int y, String word, int pos, boolean[][] flag, int n, int m) {
        if (pos == word.length()) {
            p = true;
            return;
        }
        for (int[] ints : next) {
            int nextX = x + ints[0];
            int nextY = y + ints[1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && board[nextX][nextY] == word.charAt(pos) && !flag[nextX][nextY]) {
                flag[nextX][nextY] = true;
                dfs(board, nextX, nextY, word, pos + 1, flag, n, m);
                flag[nextX][nextY] = false;
            }
            if (p) return;

        }
    }
}