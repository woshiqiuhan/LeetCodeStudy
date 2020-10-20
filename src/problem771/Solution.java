package problem771;

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] flag = new boolean[130];

        int cnt = 0;
        for (int i = 0; i < J.length(); i++) {
            flag[J.charAt(i)] = true;
        }

        for (int i = 0; i < S.length(); i++) {
            if (flag[S.charAt(i)]) {
                cnt++;
            }
        }
        return cnt;
    }
}