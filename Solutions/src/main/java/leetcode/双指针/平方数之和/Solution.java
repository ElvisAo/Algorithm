package leetcode.双指针.平方数之和;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        for (; i <= j; ) {
            int sum = i * i + j * j;
            if (sum > c) j--;
            else if (sum == c) return true;
            else if (sum < c) i++;
        }
        return false;
    }
}
