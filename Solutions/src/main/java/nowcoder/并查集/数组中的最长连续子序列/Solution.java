package nowcoder.并查集.数组中的最长连续子序列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().solution_2(arr));
    }

    /**
     * {@先排序}
     *
     * @param arr
     * @return
     */
    public int solution_1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxSeq = 1, curSeq = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                if (arr[i] - arr[i - 1] == 1)
                    curSeq++;
                else {
                    curSeq = 1;
                    continue;
                }
            } else if (arr[i] < arr[i - 1]) {
                curSeq = 1;
            } else continue;
            maxSeq = Math.max(curSeq, maxSeq);
        }
        return maxSeq;
    }

    class UF {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> weight = new HashMap<>();
        Set<Integer> checkIn = new HashSet<>();

        public int getMaxWeight() {
            return maxWeight;
        }

        int maxWeight;

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
            if (!checkIn.contains(i)) return -1;
            while (parent.get(i) != i) {
                parent.put(i, parent.get(i));
                i = parent.get(i);
            }
            return i;
        }
    }

    public int solution_2(int[] arr) {
        UF uf = new UF(arr);
        for (int i = 0; i < arr.length; i++) {
            uf.union(arr[i], arr[i] - 1);
        }
        return uf.getMaxWeight();
    }
}
