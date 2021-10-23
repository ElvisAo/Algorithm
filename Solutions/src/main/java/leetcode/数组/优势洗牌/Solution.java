package leetcode.数组.优势洗牌;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }

    class Pair {
        int val, index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        LinkedList<Pair> l1 = new LinkedList<>();
        LinkedList<Pair> l2 = new LinkedList<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            l1.addLast(new Pair(nums1[i], i));
            l2.addLast(new Pair(nums2[i], i));
        }
        l1.sort((x, y) -> x.val > y.val ? 1 : -1);
        l2.sort((x, y) -> x.val > y.val ? 1 : -1);
        int[] res = new int[n];
        while (!l2.isEmpty()) {
            Pair p2 = l2.pollLast();
            if (l1.peekLast().val > p2.val) {
                res[p2.index] = l1.pollLast().val;
            } else {
                res[p2.index] = l1.pollFirst().val;
            }
        }
        return res;
    }
}
