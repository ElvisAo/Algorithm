/**
 * @description: 核心是利用优先队列
 * @author Everett
 * @date 7/1/2021 10:51 AM
 */
package nowcoder.树与图.最小生成树;


import java.util.PriorityQueue;

class UnionFind {
    int count;  // 联通分支数
    int[] parent;   // 父节点
    int[] weight;   // 每棵树的重量

    public UnionFind(int n) {
        n = n + 1;
        this.count = n;
        this.parent = new int[n];
        this.weight = new int[n];
        for (int i = 0; i < n; i++) this.parent[i] = i;
        for (int i = 0; i < n; i++) this.weight[i] = 1;
    }

    public void union(int i, int j) {
        int ip = findParent(i);
        int jp = findParent(j);
        if (ip == jp) return;
        if (weight[ip] < weight[jp]) {
            this.parent[ip] = jp;
            weight[jp] += weight[ip];
        } else {
            this.parent[jp] = ip;
            weight[ip] += weight[jp];
        }
        count--;
    }

    private int findParent(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return findParent(i) == findParent(j);
    }

    public int getCount() {
        return count;
    }
}

class WeightedEdge {
    int start, end, weight;

    public WeightedEdge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Solution {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] cost = {{1, 3, 3}, {1, 2, 1}, {2, 3, 1}};
        System.out.println(new Solution().miniSpanningTree(n, m, cost));
    }


    public int miniSpanningTree(int n, int m, int[][] cost) {
        PriorityQueue<WeightedEdge> q = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        UnionFind uf = new UnionFind(n);
        int r = 0;
        for (int[] c : cost) {
            q.offer(new WeightedEdge(c[0], c[1], c[2]));
        }
        while (!q.isEmpty()) {
            WeightedEdge edge = q.poll();
            if (!uf.isConnected(edge.start, edge.end)) {
                uf.union(edge.start, edge.end);
                r += edge.weight;
            }
        }
        return r;
    }
}
