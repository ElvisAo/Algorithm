/**
 * @description: 在一个有向无环图中，已知每条边长，求出1到n的最短路径，返回1到n的最短路径值。如果1无法到n，输出-1
 * @author Everett
 * @date 7/1/2021 11:26 AM
 */
package nowcoder.树与图.单源最短路径.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int n = 5, m = 5;
        int[][] graph = {{1, 2, 2}, {1, 4, 5}, {2, 3, 3}, {3, 5, 4}, {4, 5, 5}};
        System.out.println(new Solution().findShortestPath(n, m, graph));
    }

    public int findShortestPath(int n, int m, int[][] graph) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] p : dp) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }
        for (int[] edge : graph) {
            dp[edge[0]][edge[1]] = Math.min(edge[2], dp[edge[0]][edge[1]]); // 重边中留最小的
        }
        dp[1][1] = 0;
        Edge start = new Edge(1, 0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        priorityQueue.offer(start);
        while (!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();
            for (int i = 1; i <= n; i++) {
                if (e.end != i && dp[e.end][i] != Integer.MAX_VALUE) {
                    priorityQueue.offer(new Edge(i, dp[e.end][i] + e.cost));
                }
            }
            if (e.end == n) return e.cost;
        }
        return -1;
    }

    class Edge {
        int end, cost;
        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
