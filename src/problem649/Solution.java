package problem649;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(senate.charAt(i));
        }
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                int f = removeS(list, i, list.get(i));
                if (f == 0) {
                    if (list.get(i) == 'R') {
                        return "Radiant";
                    }
                    return "Dire";
                }
                if (f == 2) {
                    i--;
                }
            }
        }
        return list.get(0) == 'R' ? "Radiant" : "Dire";
    }

    private int removeS(List<Character> list, int i, char a) {
        boolean flag = false;
        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(j) != a) {
                list.remove(j);
                flag = true;
                break;
            }
        }
        if (!flag) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) != a) {
                    list.remove(j);
                    return 2;
                }
            }
        }
        return flag ? 1 : 0;
    }
}

/*
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
*/