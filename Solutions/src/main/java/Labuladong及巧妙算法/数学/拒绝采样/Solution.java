package Labuladong及巧妙算法.数学.拒绝采样;

import java.util.Random;

/**
 * leetcode 470
 * 公式基础：(rand_x-1)*y + rand_y 能均匀生成在1~x*y间的数
 * 注意：(rand_x-1)乘的是y，而不是rand_y
 * eg：x=3，y=4
 * x\y  1  2  3  4
 * 1    1  2  3  4     x-1==0
 * 2    5  6  7  8     x-1==1,(x-1)*y==1,2,3,4
 * 3    9  10 11 12
 */
public class Solution {
    // 用rand7实现rand10
    private int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    public int rand10() {
        int rand_x, rand_y, r, y = 7;
        do {
            rand_x = rand7();
            rand_y = rand7();
            r = (rand_x - 1) * y + rand_y;
        } while (r > 40);
        return 1 + (r - 1) % 10;    // 因为最后要求的是1~10，而r为1~40，直接取模有0，所以就-1再模
    }
}
