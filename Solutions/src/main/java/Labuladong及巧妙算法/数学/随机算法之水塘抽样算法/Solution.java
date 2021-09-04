package Labuladong及巧妙算法.数学.随机算法之水塘抽样算法;

import common.ListNode;

import java.util.Random;

public class Solution {
    /**
     * 思路：当遇到第i个元素时，有1/i的概率选择他，1-1/i的概率保留原选择
     * 数学证明：
     * 假设一共有n个元素，每个元素被选择的概率都是1/n，对于第i个元素，其被选择的概率
     * P_i = 1/i * [1-1/(i+1)] * [1-1/(i+2)] * [1 - 1/(i+3)] * ... * [1 - 1/n]
     * 意思是假设只有i个，则显然第一个1/i好理解，后面的表示选择了第i个，则后面的都不选，化简后：
     * P_i = 1/i * [i/(i+1)] * [(i+1)/(i+2)] * ... * [(n-1)/n] = 1/n
     *
     * @param head
     * @return
     */
    public int getOneRandom(ListNode head) {
        int i = 0, r = 0;
        Random random = new Random();
        while (head != null) {
            if (random.nextInt(++i) == 0) {
                r = head.val;
            }
            head = head.next;
        }
        return r;
    }

    public int[] getKRandom(ListNode head, int k) {
        int[] r = new int[k];
        Random random = new Random();
        for (int i = 0; i < k && head != null; i++) {   // 先选上前k个元素
            r[i] = head.val;
            head = head.next;
        }
        int i = k;
        while (head != null) {
            // 生成一个[0, i)之前的整数
            int j = random.nextInt(++i);
            if (j < k) {
                r[j] = head.val;
            }
            head = head.next;
        }
        return r;
    }
}
