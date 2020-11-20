package problem134;

import javafx.util.Pair;

import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        Pair<Integer, Integer>[] mp = new Pair[n];
        for (int i = 0; i < n; i++) {
            mp[i] = new Pair<>(i, gas[i] - cost[i]);
        }
        Arrays.sort(mp, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int total = 0;
        for (Pair<Integer, Integer> integerIntegerPair : mp) {
            System.out.println(integerIntegerPair.getKey() + " " + integerIntegerPair.getValue());
        }
        for (int i = 0; i < n; i++) {
            total += mp[i].getValue();
            if (total < 0) {
                return -1;
            }
        }
        return mp[0].getKey();
    }
}