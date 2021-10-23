package 真题.笔试真题.UNKONWN.xy的第n个正整数倍数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextByte();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solution(n, x, y));
        }
    }

    private static int solution(int n, int x, int y) {
        if (x == 1 || y == 1) return n;
        if (Math.min(x, y) * n <= Math.max(x, y)) return Math.min(x, y) * n;
        int m = 1000000007;
        int res = Math.min(x, y);
        for (int i = 1, j = 1, k = 0; k < n; ) {
            int xi = x * i, yj = y * j;
            if (xi < yj) {
                res = xi % m;
                i++;
            } else if (xi > yj) {
                res = yj % m;
                j++;
            } else {
                res = xi % m;
                i++;
                j++;
            }
            k++;
        }
        return res;
    }
}
