package nowcoder.history.shopee.由前序遍历打印叶子节点;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        findLeaf(nums, 0, nums.length);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void findLeaf(int[] nums, int left, int right) {
        if (right - left <= 1) {
            result.add(nums[left]);
            return;
        }
        int target = nums[left];
        int index = right;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > target) {
                index = i;
                break;
            }
        }
        if (index == left + 1) {
            //无左子树
            findLeaf(nums, index, right);
        } else if (index == right) {
            //无右子树
            findLeaf(nums, left + 1, index);
        } else {
            //都有
            findLeaf(nums, left + 1, index);
            findLeaf(nums, index, right);
        }
    }
}
