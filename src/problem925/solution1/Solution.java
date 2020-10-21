package problem925.solution1;

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();

        if (n >= m) return name.equals(typed);

        boolean flag = true;
        for (int i = 0, j = 0; i < n && j < m; ) {
            char c = name.charAt(i);
            int cntc = 0, cntcc = 0;
            while (i < n && name.charAt(i) == c){
                cntc++;
                i++;
            }
            while (j < m && typed.charAt(j) == c) {
                cntcc++;
                j++;
            }
            if (cntc > cntcc || ((i == n && j != m) || (i != n && j == m))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
