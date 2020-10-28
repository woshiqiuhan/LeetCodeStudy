package problem1207;

import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 2 && arr[1] != arr[0]) return false;
        boolean[] flag = new boolean[1001];

        int tmpCnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                tmpCnt++;
            } else {
                if (flag[tmpCnt]) {
                    return false;
                }
                flag[tmpCnt] = true;
                tmpCnt = 1;
            }
        }
        return true;
    }
}