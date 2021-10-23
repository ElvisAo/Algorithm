package Labuladong及巧妙算法.FIFO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        int res = fifo(arr, m, n);
        System.out.println(res);
    }

    private static int fifo(int[] arr, int m, int n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {    // 没有，发生了缺页
                counter++;
                if (set.size() == m) {
                    Integer removed = list.pollLast();
                    set.remove(removed);
                }
                list.offerFirst(arr[i]);
                set.add(arr[i]);
            }
        }
        return counter;
    }
}
