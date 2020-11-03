package problem941;

import javax.swing.*;

class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3) return false;
        if (A[0] >= A[1]) return false;
        boolean f1 = true, f2 = true;
        for (int i = 1; i < n; i++) {
            if (f2) {  //up为true，down为false
                if (A[i] < A[i - 1]) {
                    f2 = false;
                } else if (A[i] == A[i - 1]) {
                    f1 = false;
                    break;
                }
            } else {
                if (A[i] >= A[i - 1]) {
                    f1 = false;
                    break;
                }
            }
        }
        return f1 && !f2;
    }
}