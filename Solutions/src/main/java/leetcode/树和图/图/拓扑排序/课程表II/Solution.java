package leetcode.树和图.图.拓扑排序.课程表II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 210
 */
public class Solution {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(new Solution().findOrder(numCourses, prerequisites)));
    }

    private List<Integer>[] createGraph(int numsCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numsCourses];
        for (int i = 0; i < numsCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] relation : prerequisites) {
            int next = relation[0], pre = relation[1];
            graph[pre].addLast(next);
        }
        return graph;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = createGraph(numCourses, prerequisites);
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (int nxt : graph[i]) {
                inDegree.put(nxt, inDegree.getOrDefault(nxt, 0) + 1);
            }
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] path = new int[numCourses];
        int pathIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            int indeg = inDegree.getOrDefault(i, 0);
            if (indeg == 0) {
                q.offer(i);
            }
        }
        if (q.size() == 0) return new int[]{};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int pre = q.poll();
                path[pathIndex++] = pre;
                List<Integer> successors = graph[pre];
                for (int successor : successors) {
                    inDegree.put(successor, inDegree.get(successor) - 1);
                    if (inDegree.get(successor) == 0) {
                        q.offer(successor);
                    }
                }
            }
        }
        for (int v : inDegree.values()) {
            if (v != 0) return new int[]{};
        }
        return path;
    }
}
