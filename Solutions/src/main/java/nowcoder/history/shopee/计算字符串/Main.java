package nowcoder.history.shopee.计算字符串;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().computeString("[c]"));
    }

    /**
     * @param str string字符串
     * @return string字符串
     */
    public String computeString(String str) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) q.offer(str.charAt(i));
        return helper(q);
    }

    public String helper(Queue<Character> q) {
        StringBuilder sb = new StringBuilder();
        int k = 1;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (isAlpha(c)) sb.append(c);
            if (isDigit(c)) k = c - '0';
            if (c == '[') {
                String s = helper(q);
                for (int i = 0; i < k; i++)
                    sb.append(s);
            }
            if (c == ']') break;
        }
        return sb.toString();
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}