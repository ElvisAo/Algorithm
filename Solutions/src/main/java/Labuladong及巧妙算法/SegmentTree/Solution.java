package Labuladong及巧妙算法.SegmentTree;


import java.util.Arrays;

/**
 * TODO 待完善
 */
class SegmentTree {
    class Segment {
        int left, right;
        int val;

        public Segment() {
        }

        public Segment(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    int[] arr;
    int size;
    Segment[] t;

    public SegmentTree(int[] arr) {
        this.size = arr.length;
        this.arr = new int[size + 1];
        for (int i = 0; i < size; i++) {
            this.arr[i + 1] = arr[i];
        }
        t = new Segment[size + 1];
        Arrays.fill(t, new Segment());
        build(1, 1, size);
    }

    private void build(int p, int l, int r) {
        if (p > size) return;
        t[p].left = l;
        t[p].right = r;
        if (l == r) {
            t[p].val = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(p * 2, l, mid);
        build(p * 2 + 1, mid + 1, r);
        t[p].val = Math.max(t[p * 2].val, t[p * 2 + 1].val);
    }

    /**
     * 把arr[x]修改为v
     *
     * @param p
     * @param x
     * @param v
     */
    public void change(int p, int x, int v) {
        if (t[p].left == t[p].right) {
            t[p].val = v;
            return;
        }
        int mid = (t[p].left + t[p].right) / 2;
        if (x < mid) change(p * 2, x, v);
        else change(p * 2 + 1, x, v);
        t[p].val = Math.max(t[p * 2].val, t[p * 2 + 1].val);
    }

    public int ask(int p, int l, int r) {
        if (l <= t[p].left && r >= t[p].right) return t[p].val;
        int mid = (t[p].left + t[p].right) / 2;
        int val = Integer.MIN_VALUE;
        if (l <= mid) val = Math.max(val, ask(p * 2, l, r));
        if (r >= mid) val = Math.max(val, ask(p * 2 + 1, l, r));
        return val;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 8, 1, 2, 9, 5, 7, 0};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.ask(1, 1, n));
    }
}
