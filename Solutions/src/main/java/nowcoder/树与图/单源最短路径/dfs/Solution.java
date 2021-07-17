/**
 * @author Everett
 * @date 7/1/2021 3:21 PM
 */
package nowcoder.树与图.单源最短路径.dfs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5, m = 5;
        int[][] graph = {{1, 2, 2}, {1, 4, 5}, {2, 3, 3}, {3, 5, 4}, {4, 5, 5}};
        System.out.println(new Solution().findShortestPath(n, m, graph));
    }

    public int findShortestPath(int n, int m, int[][] graph) {
        int[][] simpleGraph = new int[n + 1][n + 1];
        for (int[] p : simpleGraph) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }
        for (int[] edge : graph) {
            simpleGraph[edge[0]][edge[1]] = Math.min(edge[2], simpleGraph[edge[0]][edge[1]]); // 重边中留最小的
        }
        simpleGraph[1][1] = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        for (int i = 2; i <= n; i++) {
            if (simpleGraph[1][i] != Integer.MAX_VALUE) {
                visited[i] = true;
                dfs(simpleGraph, n, i, n, simpleGraph[1][i], visited);
                visited[i] = false;
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    int minCost = Integer.MAX_VALUE;

    private void dfs(int[][] simpleGraph, int n, int v, int target, int cost, boolean[] visited) {
        if (v == target) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (simpleGraph[v][i] != Integer.MAX_VALUE && !visited[i]) {
                visited[i] = true;
                dfs(simpleGraph, n, i, n, cost + simpleGraph[v][i], visited);
                visited[i] = false;
            }
        }
    }
}
