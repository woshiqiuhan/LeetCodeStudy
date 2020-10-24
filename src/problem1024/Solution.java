package problem1024;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int T) {
        //贪心思想，先排序
        Arrays.sort(clips, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return new Integer(o1[1]).compareTo(new Integer(o2[1]));
            }
            return new Integer(o1[0]).compareTo(new Integer(o2[0]));
        }));
        //定义最右端点
        int r = 0, startPos = 0, cnt = 0;
        int n = clips.length;
        if (clips[n - 1][1] < T) return -1;
        while (r < T && startPos != n) {
            cnt++;
            int l = r, tmp = startPos;
            boolean flag = false;
            for (int i = tmp; i < n; i++) {
                if (l >= clips[i][0]) {
                    if (r <= clips[i][1]) {
                        r = clips[i][1];
                        flag = true;
                        startPos = i + 1;
                    }
                }
            }
            if (!flag) return -1;
        }
        return cnt;
    }
}