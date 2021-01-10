package problem228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return list;
        }
        int l = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }
            if (l == nums[i - 1]) {
                list.add(String.valueOf(l));
            } else {
                list.add(new StringBuilder(String.valueOf(l)).append("->").append(nums[i - 1]).toString());
            }
            l = nums[i];
        }
        if (l == nums[n - 1]) {
            list.add(String.valueOf(l));
        } else {
            list.add(new StringBuilder(String.valueOf(l)).append("->").append(nums[n - 1]).toString());
        }
        return list;
    }
}