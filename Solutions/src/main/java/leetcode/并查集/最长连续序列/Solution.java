package leetcode.并查集.最长连续序列;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().solution_2(nums));
    }

    class UF {
        private HashMap<Integer, Integer> parent = new HashMap<>();
        private HashMap<Integer, Integer> weight = new HashMap<>();
        private HashSet<Integer> ele = new HashSet<>();
        int maxWeight;

        public UF(int[] array) {
            int t;
            for (int i = 0; i < array.length; i++) {
                t = array[i];
                parent.put(t, t);
                weight.put(t, 1);
                ele.add(t);
            }
            maxWeight = 1;
        }

        private int parent(int i) {
            while (i != parent.get(i)) {
                parent.put(i, parent.get(i));
                i = parent.get(i);
            }
            return i;
        }

        public void union(int i, int j) {
            if (!ele.contains(i) || !ele.contains(j)) return;
            int ip = parent(i);
            int jp = parent(j);
            if (ip != jp) {
                int iw = weight.get(ip);
                int jw = weight.get(jp);
                if (iw < jw) {
                    parent.put(ip, jp);
                    weight.put(jp, iw + jw);
                } else {
                    parent.put(jp, ip);
                    weight.put(ip, iw + jw);
                }
                maxWeight = Math.max(maxWeight, jw + iw);
            }
        }

        public int getMaxWeight() {
            return maxWeight;
        }
    }

    /**
     * {@并查集}
     *
     * @param nums
     * @return
     */
    public int solution_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        UF uf = new UF(nums);
        for (int i = 0; i < n; i++) {
            uf.union(nums[i], nums[i] - 1);
        }
        return uf.getMaxWeight();
    }

    /**
     * {@纯hash法，超时；+剪枝}
     *
     * @param nums
     * @return
     */
    public int solution_2(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(nums[i]);
        int r = 0, v;
        for (int i = 0; i < n; i++) {
            v = nums[i];
            if (set.contains(v + 1)) continue;  // 剪枝
            while (set.contains(v - 1)) v--;
            r = Math.max(r, nums[i] - v + 1);
        }
        return r;
    }
}
