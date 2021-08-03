package nowcoder.动态规划.数组中的最长连续子序列;


import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO 有bug
 */
class UionFind {
    private HashMap<Integer, Integer> parent = new HashMap<>();
    private HashMap<Integer, Integer> weight = new HashMap<>();
    private HashSet<Integer> checkIn = new HashSet<>();
    private int maxWeight;

    public UionFind(int[] array) {
        for (int i = 0; i < array.length; i++) {
            checkIn.add(array[i]);
            parent.put(array[i], array[i]);
            weight.put(array[i], 1);
        }
        maxWeight = 1;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    private boolean contains(int i) {
        return checkIn.contains(i);
    }

    private int parent(int i) {
        while (i != parent.get(i)) {
            parent.put(i, parent.get(i));
            i = parent.get(i);
        }
        return i;
    }

    private boolean isConnect(int i, int j) {
        return parent(i) == parent(j);
    }

    public void uion(int i, int j) {
        if (!contains(i) || !contains(j)) return;
        int ip = parent(i);
        int jp = parent(j);
        if (ip == jp) return;
        if (weight.get(ip) < weight.get(jp)) {
            parent.put(ip, jp);
            weight.put(jp, weight.get(ip) + weight.get(jp));
            maxWeight = Math.max(maxWeight, weight.get(jp));
        } else {
            parent.put(jp, ip);
            weight.put(ip, weight.get(ip) + weight.get(jp));
            maxWeight = Math.max(maxWeight, weight.get(ip));
        }
    }
}

public class Exercise_UF {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(new Exercise_UF().solution(arr));
    }

    public int solution(int[] arr) {
        UionFind uf = new UionFind(arr);
        for (int i = 0; i < arr.length; i++) {
            uf.uion(arr[i], arr[i] - 1);
        }
        return uf.getMaxWeight();
    }
}
