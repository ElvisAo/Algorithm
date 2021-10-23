package leetcode.树和图.图.单源最短路径之Dijkstra系列.最小体力消耗路径;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 1631
 * TODO 有bug
 */
public class Solution {
    class State {
        int x, y;   // 当前点
        int effortFromStart;  // 起点到当前点的距离

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    int[][] direcs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 四个方向的数组

    /**
     * 返回（x,y）的相邻坐标
     *
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : direcs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effortTo = new int[m][n];   // 从（0，0）到（i，j）的最小消耗
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((x, y) -> x.effortFromStart > y.effortFromStart ? 1 : -1);
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curx = curState.x, cury = curState.y;
            int curEffort = curState.effortFromStart;
            if (curx == m - 1 && cury == n - 1) return curEffort;   // 已经到了终点
            if (curEffort > effortTo[curx][cury]) continue;     // 如果已经算出了更小的effort，大于才continue
            List<int[]> neighbors = adj(heights, curx, cury);
            for (int[] neighbor : neighbors) {
                int nextx = neighbor[0], nexty = neighbor[1];
                int effortToNext = Math.max(    // 从起点到（i,j）的消耗为相邻格子间的高度差的最大值
                        effortTo[curx][cury],
                        Math.abs(heights[curx][cury] - heights[nextx][nexty])
                );
                if (effortToNext < effortTo[nextx][nexty]) {    // 小于才更新并入队列
                    effortTo[nextx][nexty] = effortToNext;
                    pq.offer(new State(nextx, nexty, effortToNext));
                }
            }
        }
        return -1;  // 正常情况不会用到
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(new Solution().minimumEffortPath(heights));
    }
}
