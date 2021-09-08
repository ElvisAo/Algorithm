package leetcode.树和图.Dijkstra系列.概率最大的路径;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class State {
        int id;
        double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    private List<double[]>[] createGraph(int[][] edges, double[] succProb, int n) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0], end = edges[i][1];
            double weight = succProb[i];
            graph[start].add(new double[]{1.0 * end, weight});
            graph[end].add(new double[]{1.0 * start, weight});
        }
        return graph;
    }

    private double dijkstra(List<double[]>[] graph, int start, int end, int n) {
        PriorityQueue<State> pq = new PriorityQueue<>((x, y) -> x.probFromStart > y.probFromStart ? -1 : 1);
        double[] probTo = new double[n];
        Arrays.fill(probTo, -1.0);
        probTo[start] = 1.0;
        pq.offer(new State(start, 1.0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curId = curState.id;
            double curProbFromStart = curState.probFromStart;
            if (curId == end) return curProbFromStart;
            if (curProbFromStart < probTo[curId]) continue;
            for (double[] adj : graph[curId]) {
                int next = (int) adj[0];
                double nextProb = adj[1] * curProbFromStart;
                if (nextProb > probTo[next]) {
                    probTo[next] = nextProb;
                    pq.offer(new State(next, nextProb));
                }
            }
        }
        return 0.0; // 无法到达，返回0
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = createGraph(edges, succProb, n);
        return dijkstra(graph, start, end, n);
    }
}
