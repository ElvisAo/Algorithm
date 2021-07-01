package leetcode.被围绕的区域;

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

public class UnionFindSolution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        UF uf = new UF(n * m + 1);
        int dummy = m * n;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') uf.uion(i * m, dummy);
            if (board[i][m - 1] == 'O') uf.uion(i * m + m - 1, dummy);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') uf.uion(i, dummy);
            if (board[n - 1][i] == 'O') uf.uion((n - 1) * m + i, dummy);
        }
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < d.length; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.uion(x * m + y, i * m + j);
                    }
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!uf.connected(i * m + j, dummy))
                    board[i][j] = 'X';
            }
        }
    }
}
