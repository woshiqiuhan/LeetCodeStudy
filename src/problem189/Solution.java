package problem189;

/**
 * 时间复杂度O(n)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k %= n;

        if (k == 0) {
            return;
        }

        // 记录交换次数
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            int last = nums[i];
            int lastIndex = i;
            while (true) {
                lastIndex = (lastIndex + k) % n;
                int tmp = nums[lastIndex];
                nums[lastIndex] = last;
                last = tmp;
                cnt++;
                if (lastIndex == i) {
                    if (cnt != n) {
                        break;
                    }
                    // 若已交换n次则跳出循环
                    return;
                }
            }
        }
    }
}