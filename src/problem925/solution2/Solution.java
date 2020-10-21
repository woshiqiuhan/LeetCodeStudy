package problem925.solution2;

class Solution {  //wrong on test 81
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() >= typed.length()) return name.equals(typed);
        return getSimString(name).equals(getSimString(typed));
    }

    private String getSimString(String str) {
        StringBuilder strb = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; ) {
            char c = str.charAt(i);
            strb.append(str.charAt(i));
            while (i < n && str.charAt(i) == c){
                i++;
            }
        }
        return strb.toString();
    }
}