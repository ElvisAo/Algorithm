package leetcode.动态规划.最长递增子序列;

public class Exercise {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0, right = index;    // 左闭右开
            while (left < right) {  // 二分查找左边界（大于poker的最小的数
                int mid = left + ((right - left) >> 1);
                if (top[mid] < poker) left = mid + 1;
                else right = mid;   // left == right会退出，所以这里right=mid即可
            }
            if (left == index) index++;
            top[left] = poker;
        }
        return index;
    }
}
