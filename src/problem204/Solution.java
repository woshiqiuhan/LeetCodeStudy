package problem204;

class Solution {
    private boolean[] isNotPrime;

    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int cnt = 0;
        isNotPrime = new boolean[n];
        isNotPrime[1] = true;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                isNotPrime[i] = false;
                cnt++;

                for (int j = 2; j * i < n; j++) {
                    if (!isNotPrime[i * j]) {
                        isNotPrime[i * j] = true;
                    }
                }
            }
        }
        return cnt;
    }
}