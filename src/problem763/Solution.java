package problem763;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            //确定最左端点字符
            char lChar = S.charAt(i);
            //确定最左端
            int l = i;
            //暂定最右端点为最后一次出现lChar的位置
            int r = S.lastIndexOf(lChar);
            //对i进行迭代，i = r为退出条件代表当前区间长度最长且满足题意
            while (i != r) {
                i++;
                //每次跟新右边界值
                r =Math.max(r, S.lastIndexOf(S.charAt(i)));
            }
            res.add(r - l + 1);
        }

        return res;
    }
}