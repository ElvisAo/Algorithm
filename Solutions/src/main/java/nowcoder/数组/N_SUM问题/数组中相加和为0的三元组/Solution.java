package nowcoder.数组.N_SUM问题.数组中相加和为0的三元组;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, -2, -1, -1, 0};
        System.out.println(new Solution().solution_3(arr));
    }

    public ArrayList<ArrayList<Integer>> solution_1(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        ArrayList<ArrayList<Integer>> olist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = 0 - num[i];
            int j = 0, k = n - 1;
            for (; j < k; ) {
                if (j == i) {
                    j++;
                    continue;
                } else if (k == i) {
                    k--;
                    continue;
                }
                int sum = num[j] + num[k];
                if (sum == target) {
                    ArrayList<Integer> ilist = new ArrayList<>(3);
                    ilist.addAll(Arrays.asList(num[j], num[i], num[k]));
                    ilist.sort((x, y) -> x > y ? 1 : -1);
                    if (!olist.contains(ilist))
                        olist.add(ilist);
                    j++;
                    k--;
                } else if (sum > target) k--;
                else if (sum < target) j++;
            }
        }
        return olist;
    }

    /**
     * {@注意对num[i]<=0的限制}
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> solution_2(int[] num) {
        ArrayList<ArrayList<Integer>> olist = new ArrayList<>();
        if (num == null || num.length == 0) return olist;
        Arrays.sort(num);
        int n = num.length, c, rema, left, right;
        for (int i = 0; i < n && num[i] <= 0; ) {
            c = num[i];
            rema = 0 - c;
            for (int j = 0, k = n - 1; j < k; ) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (k == i) {
                    k--;
                    continue;
                }
                left = num[j];
                right = num[k];
                if (left + right == rema) {
                    ArrayList<Integer> ilist = new ArrayList<>();
                    ilist.addAll(Arrays.asList(left, c, right));
                    ilist.sort((x, y) -> x > y ? 1 : -1);
                    if (!olist.contains(ilist))
                        olist.add(ilist);
                    while (j < k && num[j] == left) j++;
                    while (j < k && num[k] == right) k--;
                } else {
                    if (left + right > rema)
                        while (j < k && right == num[k]) k--;
                    else if (left + right < rema)
                        while (j < k && left == num[j]) j++;

                }
            }
            while (i < n && num[i] == c) i++;    // 去重
        }
        return olist;
    }


    /**
     * {@注意思想：第一层循环中是第一个数，后面的twosum是找后两个数}
     * {@循环的基本思路：一层循环只找一个数，通常第一层找第一个，第二层找第二个...}
     *
     * @param nums
     * @return
     */
    public ArrayList<ArrayList<Integer>> solution_3(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { // O(n^2)。 第一个数大于 0，后面的数都比它大，肯定不成立了。将判断放在循环条件中能提升效率
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    /**
                     * {@注意：这里是的while跳过是对已经计算了元素进行跳过，对于left来说，如果它与left-1相同了，因为left-1已经计算过，所以可以直接跳过
                     * {@而对于right来说，因为right+1已经计算过了，所以也可以直接跳过}
                     * {@而这里的left-1不能改为left+1；right+1也不能改为right-1}
                     * example: [-2,0,1,1,2]
                     * 如果使用left+1与right-1，就会把-2，1，1的答案漏掉，因为他们都默认下一个重复的是“自己的”，但是其实可能是“别人的”
                     */
                    while (left < right && nums[left] == nums[left - 1]) left++;    // twosum问题的去重
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
