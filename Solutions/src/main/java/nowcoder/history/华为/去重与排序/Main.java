package nowcoder.history.华为.去重与排序;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> r = new LinkedList<>();
        while (scanner.hasNextInt()) {  // 注意：这里不能使用hasnextLine，也许是有空行
            int n = scanner.nextInt();
//            if(n==0)break;
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                if (!q.contains(t)) q.add(t);
            }
            while (!q.isEmpty()) {
                r.addLast(q.poll());
            }
        }
        while (!r.isEmpty()) {
            System.out.println(r.removeFirst());
        }
    }
}
