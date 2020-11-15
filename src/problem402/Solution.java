package problem402;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> que = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !que.isEmpty() && que.peekLast() > num.charAt(i)) {
                k--;
                que.pollLast();
            }
            que.offerLast(num.charAt(i));
        }
        while (k-- > 0) {
            que.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        while (!que.isEmpty()) {
            char digit = que.pollFirst();
            if (flag && digit == '0') {
                continue;
            }
            flag = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}