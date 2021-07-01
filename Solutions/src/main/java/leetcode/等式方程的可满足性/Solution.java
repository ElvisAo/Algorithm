package leetcode.等式方程的可满足性;

class UF {
    private int count;  // 连通分量数
    private int[] parent;   // 存储一棵树,parent[i]表示i的父节点
    private int[] weight;   // 每棵树的重量,weight[i]表示i下面的节点数

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    /**
     * 连接p、q节点
     */
    public void uion(int p, int q) {
        int pp = findAncestor(p);
        int qp = findAncestor(q);
        if (pp == qp) return;
        if (weight[pp] < weight[qp]) {
            parent[pp] = qp;
            weight[qp] += weight[pp];
        } else {
            parent[qp] = pp;
            weight[pp] += weight[qp];
        }
        count--;
    }

    /**
     * 判断p、q节点是否联通
     */
    public boolean connected(int p, int q) {
        return findAncestor(p) == findAncestor(q);
    }

    /**
     * 查找祖先节点
     */
    private int findAncestor(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void show() {
        for (int i = 0; i < parent.length; i++) {
            System.out.println("ele:" + i + " parent:" + findAncestor(i));
        }
    }
}

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations)
            if (eq.charAt(1) == '=') uf.uion(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
        for (String eq : equations)
            if (eq.charAt(1) == '!' && uf.connected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) return false;
        return true;
    }
}
