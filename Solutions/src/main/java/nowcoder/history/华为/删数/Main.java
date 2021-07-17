package nowcoder.history.华为.删数;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            if (N > 1000) N = 1000;
            list.add(helper(N));
        }
        list.stream().forEach(x -> System.out.println(x));
    }

    private static int helper(int N) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) q.offer(i);
        int count = 1;
        while (q.size() != 1) {
            if (count % 3 == 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
            count++;
        }
        return q.poll();
    }
}
