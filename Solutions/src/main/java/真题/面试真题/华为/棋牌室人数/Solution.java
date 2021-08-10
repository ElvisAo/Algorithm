package 真题.面试真题.华为.棋牌室人数;

import java.util.Arrays;

/**
 * 作者：牛客931271830号
 * 链接：https://www.nowcoder.com/discuss/692084?source_id=discuss_experience_nctrack&channel=-1
 * 来源：牛客网
 * <p>
 * 一个棋牌室，输入n表示有n场预约，
 * 输入m表示该棋牌室每个时间段最多容纳m人，
 * 然后n个长为3的数组，每个表示一场预约，第一个表示开始时间，第二个表示结束时间，第三个表示人数，
 * 如果这个预约有一个时间段内剩余座位不够他们用，就取消这个预约。输出24h每个小时棋牌室的人数
 * 例输入2 30
 * 0 1 10
 * 1 2 20
 * 输出10 20 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0  // 包括开始不包括结束
 * 解答:建个24长数组，遍历预约，符合要求的加上去就行了
 */
public class Solution {
    public static void main(String[] args) {
        int[][] reservation = {
                {0, 1, 10},
                {1, 2, 20},
        };
        int m = 30;
        System.out.println(Arrays.toString(solution(reservation, m)));
    }

    public static int[] solution(int[][] reservation, int m) {
        int n = reservation.length;
        int[] times = new int[24];
        for (int i = 0; i < n; i++) {
            int[] reserve = reservation[i];
            int s = reserve[0], e = reserve[1], nums = reserve[2];
            boolean flag = true;
            for (int j = s; j <= e; j++) {
                if (times[j] + nums > m) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = s; j < e; j++) {
                    times[j] += nums;
                }
            }
        }
        return times;
    }
}
