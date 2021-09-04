package leetcode.数学.打乱数组;

import java.util.Arrays;
import java.util.Random;

class Solution {
    int[] original;
    int[] op;
    int n;

    public Solution(int[] nums) {
        this.n = nums.length;
        this.op = Arrays.copyOf(nums, n);
        this.original = Arrays.copyOf(nums, n);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            swap(op, i, random.nextInt(i + 1));
        }
        return op;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}