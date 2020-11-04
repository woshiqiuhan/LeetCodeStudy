package problem57;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean flag = false;
        boolean f = false;
        for (int i = 0; i < intervals.length; i++) {
            if (isOverlapping(intervals[i], newInterval)) {
                f = true;
                int min = Math.min(intervals[i][0], newInterval[0]);
                if (intervals[i][1] >= newInterval[1]) {
                    if (flag) {
                        flag = false;
                    }
                    res.add(new int[]{min, intervals[i][1]});
                } else {
                    flag = true;
                    newInterval[0] = min;
                }
            } else {
                if (flag) {
                    flag = false;
                    res.add(newInterval);
                }
                res.add(intervals[i]);
            }
        }
        if (flag || !f) {
            res.add(newInterval);
        }
        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] < o2[0]) ? -1 : ((o1[0] == o2[0]) ? 0 : 1);
            }
        });
        return res.toArray(new int[res.size()][]);
    }

    private boolean isOverlapping(int[] a, int[] b) {
        return !(a[1] < b[0] || a[0] > b[1]);
    }
}

/*
[[1,2],[3,5],[6,7],[8,10],[12,16]]
[4,8]

[[1,5],[6,9]]
 */