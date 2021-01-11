package problem1202;

import java.util.*;

class Solution {
    private int[] fa;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        this.fa = new int[n];

        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }

        pairs.forEach(pair -> {
            Integer i = pair.get(0), j = pair.get(1);
            if (i != j) {
                if (i > j) {
                    Integer tmp = i;
                    i = j;
                    j = tmp;
                }
                merge(i, j);
            }
        });

        for (int i = 0; i < fa.length; i++) {
            findfa(i);
//            System.out.println(i + ": " + fa[i]);
        }

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < fa.length; i++) {
            if (!mp.containsKey(fa[i])) {
                mp.put(fa[i], new ArrayList<>());
            }
            mp.get(fa[i]).add(i);
        }

//        System.out.println(mp);

        mp.keySet().forEach(i -> {
            List<Character> list = new ArrayList<>();
            List<Integer> poses = mp.get(i);
            poses.forEach(pos -> list.add(s.charAt(pos)));
            Collections.sort(list);
            for (int j = 0; j < list.size(); j++) {
                str[poses.get(j)] = list.get(j);
            }
        });
        return new String(str);
    }

    private int findfa(int i) {
        if (fa[i] == i) {
            return i;
        }
        return fa[i] = findfa(fa[i]);
    }

    private void merge(int i, int j) {
        int fi = findfa(i), fj = findfa(j);
        if (fi != fj) {
            if (fi < fj) fa[fj] = fi;
            else fa[fi] = fj;
        }
    }
}