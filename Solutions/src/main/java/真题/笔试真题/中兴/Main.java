package 真题.笔试真题.中兴;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i = '0'; i <= '9'; i++) map.put(i, i - '0');
        for (char i = 'A'; i <= 'Z'; i++) map.put(i, i - 'A' + 10);
        int T = scanner.nextInt();
        while (T > 0) {
            String s = scanner.next();
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            helper(s, l, r, map);
            T--;
        }
    }

    private static void helper(String s, long l, long r, HashMap<Character, Integer> map) {

    }

    private static long parseLong(String s, long radix, HashMap<Character, Integer> map) {
        int n = s.length();
        long r = 0l;
        for (int i = 0; i < n; i++) {
            int index = n - i - 1;
            char c = s.charAt(index);
            int val = map.get(c);
            r += Math.pow(i, val);
        }
        return r;
    }
}