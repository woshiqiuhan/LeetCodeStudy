package problem127;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) return 0;
        boolean[] vis = new boolean[wordList.size()];
        Queue<Pair<String, Integer>> que = new LinkedList<>();
        que.offer(new Pair<>(beginWord, 0));
        while (!que.isEmpty()) {
            Pair<String, Integer> head = que.poll();
            if (head.getKey().equals(endWord)) {
                return head.getValue() + 1;
            }
            for (int j = 0; j < wordList.size(); j++) {
                if (!vis[j] && judge(wordList.get(j), head.getKey())) {
                    vis[j] = true;
                    que.offer(new Pair<>(wordList.get(j), head.getValue() + 1));
                }
            }
        }
        return 0;
    }

    private boolean judge(String s, String nowWord) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != nowWord.charAt(i)) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}