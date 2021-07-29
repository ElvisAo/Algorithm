package 真题.笔试真题.pdd.线段判定;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] segement = new int[N][2];
        for (int i = 0; i < N; i++) {
            segement[i][0] = scanner.nextInt();
            segement[i][1] = scanner.nextInt();
        }
        System.out.println(contains(segement));
    }

    private static boolean contains(int[][] array) {
        Arrays.sort(array, (x, y) -> {
            if (x[0] == y[0]) return y[1] - x[1];
            else return x[0] - y[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            int[] cur = array[i];
            if (i == 0) list.offer(cur);
            else {
                int[] last = list.getLast();
                if (cur[0] >= last[0] && cur[1] <= last[1]) {
                    return true;
                } else {
                    list.offer(cur);
                }
            }
        }
        return false;
    }
}

