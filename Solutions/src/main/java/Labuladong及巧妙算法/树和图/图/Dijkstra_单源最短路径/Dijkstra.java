package Labuladong及巧妙算法.树和图.图.Dijkstra_单源最短路径;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 743
 */
public class Dijkstra {
    private List<int[]>[] createGraph(int[][] times, int n) {
        List<int[]> graph[] = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        return graph;
    }

    class State {
        int id; // 图节点的id
        int disFromStart;   // 从起始节点到当前节点的距离

        public State(int id, int disFromStart) {
            this.id = id;
            this.disFromStart = disFromStart;
        }
    }

    private int[] dijkstra(List<int[]>[] graph, int start) {
        int[] distTo = new int[graph.length];   // 计算从起始节点到i节点的距离distTo[i]
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((x, y) -> x.disFromStart > y.disFromStart ? 1 : -1);  // 按距离升序
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curId = curState.id, curDist = curState.disFromStart;
            if (curDist > distTo[curId]) continue;  // 已经求出更小的距离了
            for (int[] neighbor : graph[curId]) {
                int nextId = neighbor[0];
                int distToNext = distTo[curId] + neighbor[1];
                if (distTo[nextId] > distToNext) {
                    distTo[nextId] = distToNext;
                    pq.offer(new State(nextId, distToNext));
                }
            }
        }
        return distTo;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = createGraph(times, n);
        int[] distTo = dijkstra(graph, k);
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if (distTo[i] == Integer.MAX_VALUE) return -1;
            r = Math.max(r, distTo[i]);
        }
        return r;
    }
}
