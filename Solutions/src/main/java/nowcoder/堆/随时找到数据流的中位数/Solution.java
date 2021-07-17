package nowcoder.堆.随时找到数据流的中位数;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] op = {{1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}};
        double[] flowmedian = new Solution().flowmedian(op);
        for (double d : flowmedian) System.out.println(d);
    }

    /**
     * {@Priority的底层是堆}
     * {@核心在于两个优先队列各自维护了最大的一半数和最小的一半数}
     *
     * @param operations
     * @return
     */
    public double[] flowmedian(int[][] operations) {
        //大顶堆
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        //小顶堆
        PriorityQueue<Integer> minqueue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        ArrayList<Double> list = new ArrayList<>();
        int index = 0;

        for (int[] opt : operations) {
            switch (opt[0]) {
                case 1:
                    int value = opt[1];
                    index++;
                    // 让数据在两个堆中“流”一遍
                    if (index % 2 == 1) {   //如果是第奇数个，先入max，再poll一个入min。为了让个数为奇时，直接从min中取一个即可
                        maxqueue.offer(value);
                        minqueue.offer(maxqueue.poll());
                    } else {    // 为什么偶数时要先入min，为了保持min、max的平衡。
                        minqueue.offer(value);
                        maxqueue.offer(minqueue.poll());
                    }
                    break;
                case 2:
                    if (index == 0) {
                        list.add(-1.0);
                    } else if (index % 2 == 0) {    // 因为max中的数实际上是从min中poll过去的，所以是最小一半中的最大数
                        // 而min中的数是从max中poll过去的，所以是最大一半中的最小数
                        list.add((maxqueue.peek() + minqueue.peek()) / 2.0);
                    } else {
                        list.add(minqueue.peek() / 1.0);
                    }
                    break;
                default:
            }
        }

        double[] result = new double[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
