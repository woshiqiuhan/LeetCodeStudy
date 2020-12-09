package problem621;

import java.util.Arrays;

class Solution {
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        

        int[] cnt = new int['Z' - 'A'];
        int[] taskWait = new int['Z' - 'A'];

        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        for (int i = 0; i < cnt.length / 2; i++) {
            int temp = cnt[i];
            cnt[i] = cnt[cnt.length - 1 - i];
            cnt[cnt.length - 1 - i] = temp;
        }

        for (int i = 0; ; i++) {
            boolean isTask = false;
            boolean flag = false;
            for (int j = 0; j < cnt.length; j++) {
                if (cnt[j] > 0) {  //存在未完成的任务
                    if (!isTask && taskWait[j] == 0) { //间隔期到了
                        cnt[j]--;
                        isTask = true;
                        taskWait[j] = n;
                    } else {
                        if (taskWait[j] > 0) {
                            taskWait[j]--;
                        }
                    }
                }
                if (!flag && cnt[j] > 0) {  //此单位时间结束后是否还存在未完成任务
                    flag = true;
                }
            }
            if (!flag) {
                return i + 1;
            }
        }
    }
}