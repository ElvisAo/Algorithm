package nowcoder.动态规划.数组中的最长连续子序列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 1, 2, 3, 6, 7, 12, 11};
        System.out.println(new Solution().solution_1(array));
    }


    public int solution_1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int s = 0, r = 1, cur = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else if (arr[i] == arr[i - 1]) continue;
            else if (arr[i] > arr[i - 1] + 1) {
                s = i;
                cur = 1;
            }
            r = Math.max(cur, r);
        }
        return r;
    }

    class UF {
        private Map<Integer, Integer> parent = new HashMap<>();     // 避免开数组的额外开销
        private Map<Integer, Integer> weight = new HashMap<>();
        private Set<Integer> checkIn = new HashSet<>();     // 对数组元素去重
        private int maxWeight;


        public int getMaxWeight() {
            return maxWeight;
        }

        public UF(int[] array) {
            for (int i = 0; i < array.length; i++) {
                checkIn.add(array[i]);
                parent.put(array[i], array[i]);
                weight.put(array[i], 1);
            }
            maxWeight = 1;
        }

        public void union(int i, int j) {
            if (!checkIn.contains(i) || !checkIn.contains(j)) return;
            int ip = findParent(i);
            int jp = findParent(j);
            if (ip == jp) return;
            else {
                int wip = weight.get(ip);
                int wjp = weight.get(jp);
                if (wip > wjp) {
                    weight.put(ip, wip + wjp);
                    parent.put(jp, ip);
                } else {
                    weight.put(jp, wip + wjp);
                    parent.put(ip, jp);
                }
                maxWeight = Math.max(maxWeight, Math.max(weight.get(jp), weight.get(ip)));
            }
        }

        public boolean isConnected(int i, int j) {
            return findParent(i) == findParent(j);
        }

        public int findParent(int i) {
            while (parent.get(i) != i) {
                parent.put(i, parent.get(i));
                i = parent.get(i);
            }
            return i;
        }
    }

    public int solution_2(int[] arr) {
        UF uf = new UF(arr);
        for (int i = 0; i < arr.length; i++) uf.union(arr[i], arr[i] - 1);
        return uf.getMaxWeight();
    }
}
