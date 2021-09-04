package 真题.笔试真题.美团.数学;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String start = "";
        for (int i = 0; i < n; i++) {
            start += "a";
        }
        int r = bfs(start);
        System.out.println(r);
    }

    private static int bfs(String start) {
        LinkedList<String> q = new LinkedList<>();
        int r = 0, n = start.length();
        HashSet<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (!s.contains("aba") && !s.contains("bab")) {
                    r = (r + 1) % 998244353;
                }
                char[] array = s.toCharArray();
                for (int j = 0; j < n; j++) {
                    if (array[j] == 'a') {
                        array[j] += 1;
                        if (!visited.contains(new String(array))) {
                            q.offer(new String(array));
                            visited.add(new String(array));
                        }
                    } else if (array[j] == 'b') {
                        array[j] -= 1;
                        if (!visited.contains(new String(array))) {
                            q.offer(new String(array));
                            visited.add(new String(array));
                        }
                    }
                }
            }
        }
        return r;
    }
}
