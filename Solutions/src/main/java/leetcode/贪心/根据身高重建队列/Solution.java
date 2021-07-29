package leetcode.贪心.根据身高重建队列;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 贪心：类似区间问题，先按身高排序，如果身高相同，按前面比它高的人数排序；
     * 然后根据前面比它高的人数进行插入
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            else return y[0] - x[0];
        });
        LinkedList<int[]> r = new LinkedList<>();
        int n = people.length;
        r.offer(people[0]);
        for (int i = 1; i < n; i++) {
            int h = people[i][1];
            r.add(h, people[i]);
        }
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) result[i] = r.get(i);
        return result;
    }
}
