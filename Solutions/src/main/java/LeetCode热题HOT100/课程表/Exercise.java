package LeetCode热题HOT100.课程表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Exercise {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> successorCourses = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegreeMap.put(i, 0);
            successorCourses.put(i, new LinkedList<>());
        }
        for (int[] course : prerequisites) {
            inDegreeMap.put(course[0], inDegreeMap.get(course[0]) + 1);
            successorCourses.get(course[1]).add(course[0]);
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
            if (entry.getValue() == 0) q.offer(entry.getKey());
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            if (!successorCourses.containsKey(c)) continue;
            for (int successor : successorCourses.get(c)) {
                inDegreeMap.put(successor, inDegreeMap.get(successor) - 1);
                if (inDegreeMap.get(successor) == 0) q.offer(successor);
            }
        }
        for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
