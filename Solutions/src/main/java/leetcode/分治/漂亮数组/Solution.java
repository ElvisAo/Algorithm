package leetcode.分治.漂亮数组;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 932
 * TODO 待深入理解
 */
public class Solution {
    private Map<Integer, int[]> memory = new HashMap();

    {
        memory.put(1, new int[]{1});
    }

    /**
     * 思路分析：i<j时，不存在k满足i<k<j使得A[k]*2 == A[i] + A[j]
     * 注意：A[k]*2为偶数，那么如果A[i]+A[j]为奇数，则一定满足。而偶数+奇数为奇数
     * 难点在于怎么才能把前面设置为奇数？2*i-1，即为奇数
     * 而2*i即为偶数
     */
    public int[] beautifulArray(int n) {
        if (memory.containsKey(n)) return memory.get(n);
        int[] result = new int[n];
        int i = 0; // result数组的访问下标 这里使用ArrayList更简洁 但是性能略差

        // 这里注意哈 (n + 1) / 2 + n / 2 = n 整数除法有个向下取整
        // 所以当n为奇数时 左半区元素比右边要多一个 习惯就好
        // 如果{ X, Y, Z }是一个漂亮数组，则{ k * X + b, k * Y + b, k * Z + b } 也一定是漂亮数组，其实就是相当于对分治的小数组进行了放大，从而保证数的范围始终为1~n
        for (int num : beautifulArray((n + 1) / 2))     // left包括(n+1)/2个奇数
            result[i++] = num * 2 - 1;
        for (int num : beautifulArray(n / 2))   // right包括n/2个偶数
            result[i++] = num * 2;

        memory.put(n, result);
        return result;
    }
}
