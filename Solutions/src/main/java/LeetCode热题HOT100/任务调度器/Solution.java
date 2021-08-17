package LeetCode热题HOT100.任务调度器;

import java.util.HashMap;

/**
 * TODO 待完成
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ln = tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        return 0;
    }
}
