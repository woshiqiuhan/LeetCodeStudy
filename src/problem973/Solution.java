package problem973;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res =new int[K][2];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) - (Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1])) < 0)return -1;
                else if(Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) - (Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1])) > 0)return 1;
                else return 0;

            }
        });
        for(int i = 0; i < K;i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}