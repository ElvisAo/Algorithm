package leetcode.双指针.颜色分类;

import java.util.Arrays;

/**
 * {@荷兰国旗问题}
 * 用整数 0、 1 和 2 分别表示红色、白色和蓝色
 * 进行排序，使得排序后按红白蓝排序
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 0, 1, 2};
        new Solution().solution_2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * {@流氓解法}
     *
     * @param nums
     */
    public void solution_1(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * {@妙！！！}
     * 1. 第一次遇到0的时候，把三个指针各向后移动一步
     * 2. 第一次遇到1的时候，把12的指针向后移动一个
     * 3. 第一次遇到2的时候，把2指针向后移动一步
     * 操作多次后
     * 4. 再遇到0，把连续0的后面一个（应该是1）设置为0；把连续1的最后一个（应该是2）设置为1，把连续2的后面一个（即当前的0）设置为2
     * 5. 对1和2的操作类似
     *
     * @param nums
     */
    public void solution_2(int[] nums) {
        int i0 = 0, i1 = 0, i2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i2++] = 2;
                nums[i1++] = 1;
                nums[i0++] = 0;
            } else if (nums[i] == 1) {
                nums[i2++] = 2;
                nums[i1++] = 1;
            } else if (nums[i] == 2) {
                nums[i2++] = 2;
            }
        }
    }
}
