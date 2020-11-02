package problem349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tmp = null;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1) {
            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            if (Arrays.binarySearch(nums2, i) >= 0) {
                res.add(i);
            }
        }
        tmp = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            tmp[i++] = re;
        }
        return tmp;
    }
}