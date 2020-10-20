package problem416;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    private int[] nums;
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        return dfs(sum >> 1, 0);
    }

    private boolean dfs(int attr, int pos) {
        if (attr < 0 || pos >= this.nums.length) return false;
        if (attr == 0) return true;
        return dfs(attr - this.nums[pos], pos + 1) || dfs(attr, pos + 1);
    }
}