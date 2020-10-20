package problem977;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortedSquares(int[] A) {
        Integer[] integers = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return new Integer(Math.abs(o1)).compareTo(new Integer(Math.abs(o2)));
            }
        });

        int[] ints = Arrays.stream(integers)
                .map(o1 -> o1 * o1)
                .mapToInt(Integer::intValue)
                .toArray();
        return ints;
    }
}