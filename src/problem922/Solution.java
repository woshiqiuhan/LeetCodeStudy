package problem922;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int p = 0, q = 1;
        for (int i = 0; i < A.length; i++) {
            if ((i & 1) == 0 && (A[i] & 1) == 1) {
                while (q < A.length && (A[q] & 1) == 1) {
                    q += 2;
                }
                swap(A, i, q);
                q += 2;
            } else if ((i & 1) == 1 && (A[i] & 1) == 0){
                while (p < A.length && (A[p] & 1) == 0) {
                    p += 2;
                }
                swap(A, i, p);
                p += 2;
            }
        }
        return A;
    }

    private void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}