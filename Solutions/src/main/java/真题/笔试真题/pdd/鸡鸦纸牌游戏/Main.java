package 真题.笔试真题.pdd.鸡鸦纸牌游戏;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ji = new int[N];
        int[] ya = new int[N];
        for (int i = 0; i < N; i++) {
            ji[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ya[i] = scanner.nextInt();
        }
        int[] r = game(ji, ya);
        System.out.println(r[0] + " " + r[1]);
    }

    private static int[] game(int[] ji, int[] ya) {
        int[] r = new int[2];
        LinkedList<Integer> rji = new LinkedList<>();
        LinkedList<Integer> rya = new LinkedList<>();
        LinkedList<Integer> pokers = new LinkedList<>();
        int jiIndex = 0, yaIndex = 0;
        int m = ji.length, n = ya.length;
        pokers.offer(ji[jiIndex++]);
        while (jiIndex < m && yaIndex < n) {
            yaIndex = put(ya, yaIndex, pokers, rya);
            jiIndex = put(ji, jiIndex, pokers, rji);
        }
        while (jiIndex < m) {
            jiIndex = put(ji, jiIndex, pokers, rji);
        }
        while (yaIndex < n) {
            yaIndex = put(ya, yaIndex, pokers, rya);
        }
        while (!pokers.isEmpty()) {
            int p = pokers.poll();
            if (p % 2 == 0) {
                rya.offer(p);
            } else {
                rji.offer(p);
            }
        }
        r[0] = rji.size();
        r[1] = rya.size();
        return r;
    }

    private static int put(int[] array, int index, LinkedList<Integer> pokers, LinkedList<Integer> r) {
        if (index >= array.length) return array.length;
        int p = array[index++];
        int pIndex = pokers.indexOf(p);
        int t = pIndex;
        pokers.offer(p);
        while (pIndex >= 0) {
            r.offer(pokers.removeLast());
            pIndex = pokers.indexOf(p);
        }
        if (t >= 0) {
            return put(array, index, pokers, r);
        } else return index;
    }
}
