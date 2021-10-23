package Labuladong及巧妙算法.树和图.图.拓扑排序;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer>[] createGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph[from].addLast(to);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = createGraph(numCourses, prerequisites);
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (int to : graph[i]) {
                inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            }
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree.getOrDefault(i, 0) == 0) {
                q.offer(i);
            }
        }   // 把度为0的点入栈
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer from = q.poll();
                for (int next : graph[from]) {
                    inDegree.put(next, inDegree.get(next) - 1);
                    if (inDegree.get(next) == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        for (int v : inDegree.values()) {
            if (v != 0) return false;
        }
        return true;
    }
}
