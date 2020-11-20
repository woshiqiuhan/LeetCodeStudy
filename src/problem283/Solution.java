package problem283;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        /*for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }*/
        int[] tmp = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                tmp[cnt++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
    }
}