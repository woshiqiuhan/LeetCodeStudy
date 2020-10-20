package problem844;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = getStack(S);
        Stack<Character> t = getStack(T);

        return s.equals(t);
    }

    private Stack<Character> getStack(String S) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(S.charAt(i));
            }
        }
        return s;
    }
}