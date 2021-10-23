package Labuladong及巧妙算法.遥控器输入;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 思路：用map记录每个字符的位置，然后每次按键为：Math.abs(cur.x - last.x) + Math.abs(cur.y - last.y) + 1;其中1是确认，前面的是移动次数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            HashMap<Character, Coordinate> map = new HashMap<>();
            scanner.nextLine(); // 在ide中，不跳这一行会报错
            for (int x = 0; x < n; x++) {
                String nextLine = scanner.nextLine();
                char[] arr = nextLine.toCharArray();
                for (int y = 0; y < m; y++) {
                    map.put(arr[y], new Coordinate(x, y));
                }
            }   // 处理输入

            char[] arr = scanner.nextLine().toCharArray();
            int res = 0;
            Coordinate last = null;
            for (int j = 0; j < arr.length; j++) {
                char c = arr[j] == ' ' ? '_' : arr[j];
                if (j == 0) {
                    Coordinate cor = map.get(c);
                    res += cor.x + cor.y + 1;
                    last = cor;
                } else {
                    Coordinate cur = map.get(c);
                    res += Math.abs(cur.x - last.x) + Math.abs(cur.y - last.y) + 1;
                    last = cur;
                }
            }
            System.out.println(res);
        }
    }
}
