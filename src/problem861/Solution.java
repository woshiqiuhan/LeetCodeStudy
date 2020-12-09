package problem861;

public class Solution {
    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int row = A.length, col = A[0].length;
        int[] val = new int[col];
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    A[i][j] = (A[i][j] == 0 ? 1 : 0);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < col; i++) {
            int cnt = 0;
            val[i] = (int) Math.pow(2, row - 1 - i);
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 1) {
                    cnt++;
                }
            }
            if (cnt <= (row / 2)) {
                for (int j = 0; j < row; j++) {
                    A[j][i] = (A[j][i] == 0 ? 1 : 0);
                }
            }
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 1) {
                    res += val[i];
                }
            }
        }
        return res;
    }
}