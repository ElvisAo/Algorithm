package 真题.笔试真题.pdd.数据集合;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * TODO 未解决
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] samples = new int[T][4];
        for (int i = 0; i < T; i++) {
            samples[i][0] = scanner.nextInt();
            samples[i][1] = scanner.nextInt();
            samples[i][2] = scanner.nextInt();
            samples[i][3] = scanner.nextInt();
        }
        int[] r = new int[T];
        for (int i = 0; i < T; i++) {
            r[i] = containes(samples[i][0], samples[i][1], samples[i][2], samples[i][3]);
        }
        for (int num : r) {
            System.out.println(num);
        }
    }

    public static int containes(int A, int B, int C, int Q) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        return dfs(A, B, C, Q, list);
    }

    public static int dfs(int A, int B, int C, int Q, LinkedList<Integer> list) {
        if (A > Q) return 0;
        int sub = Q - B;
        int chu = Q / C;
//        boolean isZhengchu = Q%C;
        while (Q >= A) {
            while (list.size() > 0) {
                int t = list.removeFirst();
                int add = t + B;
                int multi = t * C;
                if (t == Q || add == Q || multi == Q) return 1;
                if (multi > Q || add > Q || t > Q) return 0;
                list.add(add);
                list.add(multi);
            }
        }
        return 0;
    }
}
