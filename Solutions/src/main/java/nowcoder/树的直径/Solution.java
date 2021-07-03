/**
 * @author Everett
 * @date 6/30/2021 6:25 PM
 */
package nowcoder.树的直径;

import common.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 树的直径：未做
 * 对于此类问题，我们需要构建图来做深度优先搜索。
 * <p>
 * 首先，根据父子关系及边权重构建无向图；
 * 然后，随机找一顶点，利用深度优先搜索找到距离该点最远的顶点remote。
 * 最后，从remote顶点开始深度优先搜索找到最长路径，该路径即为直径。
 */
public class Solution {
    public static void main(String[] args) {
        Interval[] Tree_edge = new Interval[5];
//        Interval[] Tree_edge = new Interval[1];
        for (int i = 0; i < Tree_edge.length; i++) {
            Tree_edge[i] = new Interval();
        }
        /*Tree_edge[0].start = 0;
        Tree_edge[0].end = 1;*/
        Tree_edge[0].start = 0;
        Tree_edge[0].end = 1;
        Tree_edge[1].start = 1;
        Tree_edge[1].end = 5;
        Tree_edge[2].start = 1;
        Tree_edge[2].end = 2;
        Tree_edge[3].start = 2;
        Tree_edge[3].end = 3;
        Tree_edge[4].start = 2;
        Tree_edge[4].end = 4;
        int Edge_value[] = {3, 4, 2, 1, 5};
//        int[] Edge_value = {2};
        System.out.println(new Solution().solve(6, Tree_edge, Edge_value));
    }

    /**
     * 树的直径
     *
     * @param n          int整型 树的节点个数
     * @param Tree_edge  Interval类一维数组 树的边
     * @param Edge_value int整型一维数组 边的权值
     * @return int整型
     */

    public int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        if (Tree_edge == null || Edge_value == null || Tree_edge.length != Edge_value.length) {
            return 0;
        }
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int len = Tree_edge.length;
        for (int i = 0; i < len; ++i) {
            Interval inter = Tree_edge[i];
            int start = inter.start;
            int end = inter.end;
            int w = Edge_value[i];
            Edge e1 = new Edge(end, w);
            if (!graph.containsKey(start)) {
                List<Edge> temp = new ArrayList<>();
                graph.put(start, temp);
            }
            graph.get(start).add(e1);   // 对起点构建邻接链表
            Edge e2 = new Edge(start, w);
            if (!graph.containsKey(end)) {
                List<Edge> temp = new ArrayList<>();
                graph.put(end, temp);
            }
            graph.get(end).add(e2); // 对终点构建邻接链表
        }   // 构建邻接链表
        int[] remote = {0, 0};    // remote[0] 代表以0为起点的最长路径长度， remote[1]代表最长路径的终点
        dfs(graph, 0, -1, 0, remote);
        int[] res = {0, 0};
        dfs(graph, remote[1], -1, 0, res);
        return res[0];
    }

    private class Edge {
        int end;
        int w;

        Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }

    /**
     * @param graph 图的邻接表表示
     * @param from  起点
     * @param prev  前驱节点
     * @param path  路径长度
     * @param res   以0为起点的最长路径的长度与终点
     */
    private void dfs(Map<Integer, List<Edge>> graph, int from, int prev, int path, int[] res) {
        List<Edge> edges = graph.get(from); // 获得以该点为起点的边
        for (Edge edge : edges) {   // 遍历这些边
            if (edge.end != prev) { // 这里主要是为了避免把走过的路又走一遍，比如从1->2，
                // 在1的level里面，from为1，end为2；然后进入2后，from为1，因为是无向图，所以还有一个end也为1的边
                path += edge.w;
                if (path > res[0]) {
                    res[0] = path;
                    res[1] = edge.end;
                }
                dfs(graph, edge.end, from, path, res);  // 递归，以end为新的起点，from为pre
                path -= edge.w;    // 回溯
            }
        }
    }
}