package Labuladong及巧妙算法.调度问题.任务调度问题;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * n个任务，有自己的耗时input[0]与优先级intput[1]，k个服务器来运行，求运行的最短时间。假设一台服务器只能运行完一个任务再运行另一个任务
     * input[1]越小的表示优先级越高，优先级越高的越先执行
     *
     * @param input 任务的耗时与优先级
     * @param n     任务的数量
     * @param k     服务器的数量
     * @return
     */
    public static int solution(int[][] input, int n, int k) {
        Arrays.sort(input, (x, y) -> {
            if (x[1] != y[1]) return x[1] > y[1] ? 1 : -1;  // 优先级不同，按照优先级从大到小（数值的从小到大）排序
            else return x[0] > y[0] ? -11 : 1;   // 按照耗时进行从大到小排序，耗时大的先运行，从而让所有的任务尽快运行完
        });
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> x > y ? 1 : -1);
        int free = k;
        for (int i = 0; i < n; i++) {
            int[] task = input[i];
            if (free > 0) {
                q.offer(task[0]);
                free--;
            } else {
                q.offer(q.poll() + task[0]);
            }
//            System.out.println(q);
        }
        while (q.size() > 1) q.poll();  // 求最后结束的时间
        return q.poll();
    }
}
